package br.com.snaperpnfedesktop.view;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.httpclient.protocol.Protocol;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import br.com.ginfes.producao.ServiceGinfesImplProxy;
import br.com.snaperpnfedesktop.bean.CancelamentoLote;
import br.com.snaperpnfedesktop.bean.EnvioLote;
import br.com.snaperpnfedesktop.controller.Assinador;
import br.com.snaperpnfedesktop.controller.Constantes;
import br.com.snaperpnfedesktop.dao.CancelamentoLoteDAO;
import br.com.snaperpnfedesktop.dao.EnvioLoteDAO;
import br.com.snaperpnfedesktop.socket.SocketFactoryDinamico;
import br.gov.sp.prefeitura.www.nfe.CancelamentoNFeRequest;
import br.gov.sp.prefeitura.www.nfe.CancelamentoNFeResponse;
import br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSRequest;
import br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSResponse;
import br.gov.sp.prefeitura.www.nfe.LoteNFeSoapProxy;
import br.inf.portalfiscal.www.nfe.wsdl.nferecepcao2.NfeRecepcao2Stub;
import br.inf.portalfiscal.www.nfe.wsdl.nferetrecepcao2.NfeRetRecepcao2Stub;

public class PrincipalNFe {
	
	private static final int SSL_PORT = 443;
	
	public static void main(String[] args) throws Exception {
		Principal principal = new Principal();
		
		/*
			public static final int METODO_ENVIAR_LOTE_RPS = 1;
			public static final int METODO_CONSULTAR_LOTE_RPS = 2;
			public static final int METODO_CANCELAR_RPS = 3;
			public static final int METODO_ENVIAR_LOTE_NFE = 4;
			public static final int METODO_CONSULTAR_LOTE_NFE = 5;
			public static final int METODO_CANCELAR_NFE = 6;
		 */
		
		int metodo = Constantes.METODO_ENVIAR_LOTE_RPS;
		
		while(true){
			try{
				principal.getTextArea().setText("");

				if(metodo == Constantes.METODO_ENVIAR_LOTE_RPS){
					principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBuscando registro na base de dados.");
					
					EnvioLoteDAO envioLoteDao = new EnvioLoteDAO();
					
					EnvioLote envioBusca = new EnvioLote();
					
					envioBusca.setSituacao("Aguardando Envio");
					
		            ResultSet envioLoteResult = envioLoteDao.getEnvioLote(envioBusca);

		            if(envioLoteResult.isBeforeFirst()){
		            	EnvioLote envio = new EnvioLote();
			            
			            while(envioLoteResult.next()){
			            	envio.setId(envioLoteResult.getInt("ID"));
				            envio.setArquivoEnvio(envioLoteResult.getString("ARQUIVO_ENVIO"));
				            envio.setNomeCertificado(envioLoteResult.getString("NOME_CERTIFICADO"));
				            envio.setSenhaCertificado(envioLoteResult.getString("SENHA_CERTIFICADO"));
				            envio.setSituacao(envioLoteResult.getString("SITUACAO"));
				            envio.setMunicipio(envioLoteResult.getInt("MUNICIPIO"));
				            envio.setEstado(envioLoteResult.getInt("ESTADO"));
			            }
			            
			            principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nLote de id: " + envio.getId() + ".");

			            String path = "C:\\ServiceAssinador\\certificados\\";
			            
			            System.clearProperty("java.protocol.handler.pkgs");
			    		System.clearProperty("javax.net.ssl.keyStoreType");
			            System.clearProperty("javax.net.ssl.keyStore");
			            System.clearProperty("javax.net.ssl.keyStorePassword");
			    		
			    		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
			            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			            // Keystore com o certificado do cliente
			            System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
			            System.setProperty("javax.net.ssl.keyStore", path + envio.getNomeCertificado());
			            System.setProperty("javax.net.ssl.keyStorePassword", envio.getSenhaCertificado());
			            
			            principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nEfetuando envio na base da prefeitura.");
			            
			            if((envio.getMunicipio() + "").equals(Constantes.MUNICIPIO_SAO_PAULO)){
				            //Envio do webservice
				            LoteNFeSoapProxy proxy = new LoteNFeSoapProxy();
							
							EnvioLoteRPSRequest request = new EnvioLoteRPSRequest();
				    		
				    		request.setVersaoSchema(1);
				    		request.setMensagemXML(envio.getArquivoEnvio());
				    		
				    		EnvioLoteRPSResponse response = proxy.envioLoteRPS(request);
				    		
				    		envio.setArquivoRetorno(response.getRetornoXML());
				    		envio.setProtocolo("PROTOCOLO");
				    		envio.setSituacao("Lote Processado");

				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nSalvando retorno na base de dados.");
				    		
				    		//Atualizar banco de dados
				    		envioLoteDao.atualizarEnvioLote(envio);
				    		
				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBase de dados atualizada.");
				    		
				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
			            }else if((envio.getMunicipio() + "").equals(Constantes.MUNICIPIO_SAO_BERNARDO_DO_CAMPO)){				            
				            //Envio do webservice
				            ServiceGinfesImplProxy proxy = new ServiceGinfesImplProxy();
	            			
	            			envio.setArquivoRetorno(proxy.recepcionarLoteRpsV3("<ns2:cabecalho versao=\"3\" xmlns:ns2=\"http://www.ginfes.com.br/cabecalho_v03.xsd\"><versaoDados>3</versaoDados></ns2:cabecalho>", envio.getArquivoEnvio()));
	            			envio.setSituacao("Aguardando Retorno");
	            			
	            			principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nSalvando retorno na base de dados.");
				    		
				    		//Atualizar banco de dados
				    		envioLoteDao.atualizarEnvioLote(envio);
				    		
				    		SAXBuilder sb = new SAXBuilder();
							
							InputStream stream = new ByteArrayInputStream(envio.getArquivoRetorno().getBytes("UTF-8"));
				            
				            Document d = sb.build(stream);
				            
				            Element enviarLoteRpsResposta = d.getRootElement();  
				            
				            List elements = enviarLoteRpsResposta.getChildren();  
				            Iterator i = elements.iterator();  
				           
				            //Iteramos com os elementos filhos, e filhos do dos filhos  
				            while (i.hasNext()) {  
				               Element element = (Element) i.next();

				               if(element.getName() == "Protocolo"){
				            	   envio.setProtocolo(element.getText());
				               }
				            }
				            
				            //Atualizar banco de dados
				    		envioLoteDao.atualizarEnvioLote(envio);
				    		
				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBase de dados atualizada.");
				    		
				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
			            }
		            }else{
		            	principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nNão existe registro para ser enviado.");
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
		            }
				}else if(metodo == Constantes.METODO_CONSULTAR_LOTE_RPS){
					principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBuscando registro na base de dados.");
					
					EnvioLoteDAO envioLoteDao = new EnvioLoteDAO();

					EnvioLote envioBusca = new EnvioLote();
					
					envioBusca.setSituacao("Aguardando Retorno");
					
		            ResultSet envioLoteResult = envioLoteDao.getEnvioLote(envioBusca);

		            if(envioLoteResult.isBeforeFirst()){
		            	EnvioLote envio = new EnvioLote();
			            
			            while(envioLoteResult.next()){
			            	envio.setId(envioLoteResult.getInt("ID"));
				            envio.setArquivoEnvio(envioLoteResult.getString("ARQUIVO_ENVIO"));
				            envio.setNomeCertificado(envioLoteResult.getString("NOME_CERTIFICADO"));
				            envio.setSenhaCertificado(envioLoteResult.getString("SENHA_CERTIFICADO"));
				            envio.setSituacao(envioLoteResult.getString("SITUACAO"));
				            envio.setMunicipio(envioLoteResult.getInt("MUNICIPIO"));
				            envio.setEstado(envioLoteResult.getInt("ESTADO"));
				            envio.setProtocolo(envioLoteResult.getString("PROTOCOLO"));
				            envio.setCnpj(envioLoteResult.getString("CNPJ"));
			            }
			            
			            principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nLote de id: " + envio.getId() + ".");

			            String path = "C:\\ServiceAssinador\\certificados\\";
			            
			            System.clearProperty("java.protocol.handler.pkgs");
			    		System.clearProperty("javax.net.ssl.keyStoreType");
			            System.clearProperty("javax.net.ssl.keyStore");
			            System.clearProperty("javax.net.ssl.keyStorePassword");
			    		
			    		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
			            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			            // Keystore com o certificado do cliente
			            System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
			            System.setProperty("javax.net.ssl.keyStore", path + envio.getNomeCertificado());
			            System.setProperty("javax.net.ssl.keyStorePassword", envio.getSenhaCertificado());
			            
			            principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nEfetuando envio na base da prefeitura.");
			            
			            if((envio.getMunicipio() + "").equals(Constantes.MUNICIPIO_SAO_BERNARDO_DO_CAMPO)){
			            	String arquivoEnvio = 	"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
			            							"<n1:ConsultarLoteRpsEnvio xmlns=\"http://www.w3.org/2000/09/xmldsig#\" xmlns:tipos=\"http://www.ginfes.com.br/tipos_v03.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:n2=\"http://www.altova.com/samplexml/other-namespace\" xmlns:n1=\"http://www.ginfes.com.br/servico_consultar_lote_rps_envio_v03.xsd\" Id=\"\">" +
			            								"<n1:Prestador>" + 
			            									"<tipos:Cnpj>" + envio.getCnpj() + "</tipos:Cnpj>" +
			            									//TODO Trazer inscricao municipal para a base de dados "<tipos:InscricaoMunicipal>" +  + "</tipos:InscricaoMunicipal>" + 
			            								"</n1:Prestador>" +
			            								"<n1:Protocolo>" + envio.getProtocolo() + "</n1:Protocolo>" +
			            							"</n1:ConsultarLoteRpsEnvio>";
			            	
			            	Assinador assinador = new Assinador();
			            	
			            	PublicKey chavePublica = assinador.getPublicKeyFromPFX(path + envio.getNomeCertificado(), envio.getSenhaCertificado().toCharArray());
			        		PrivateKey chavePrivada = assinador.getPrivateKeyFromPFX(path + envio.getNomeCertificado(), envio.getSenhaCertificado().toCharArray());
			        		
			        		String retorno = assinador.assinarDocumento(path, arquivoEnvio, chavePrivada, chavePublica);
			        		
			        		ServiceGinfesImplProxy proxy = new ServiceGinfesImplProxy();
	            			
	            			envio.setArquivoRetornoConsultaLote(proxy.consultarLoteRpsV3("<ns2:cabecalho versao=\"3\" xmlns:ns2=\"http://www.ginfes.com.br/cabecalho_v03.xsd\"><versaoDados>3</versaoDados></ns2:cabecalho>", retorno));
	            			envio.setSituacao("Retorno Processado");
	            			
	            			//Atualizar banco de dados
				    		envioLoteDao.atualizarEnvioLote(envio);
				    		
				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBase de dados atualizada.");
				    		
				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
			            }
		            }
				}else if(metodo == Constantes.METODO_CANCELAR_RPS){
					principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBuscando registro na base de dados.");
					
					CancelamentoLoteDAO cancelamentoLoteDao = new CancelamentoLoteDAO(); 

		            ResultSet cancelamentoLoteResult = cancelamentoLoteDao.getCancelamentoLote();
		            
		            if(cancelamentoLoteResult.isBeforeFirst()){
		            	CancelamentoLote cancelamento = new CancelamentoLote();
			            
			            while(cancelamentoLoteResult.next()){
			            	cancelamento.setId(cancelamentoLoteResult.getInt("ID"));
			            	cancelamento.setArquivoEnvio(cancelamentoLoteResult.getString("ARQUIVO_ENVIO"));
			            	cancelamento.setNomeCertificado(cancelamentoLoteResult.getString("NOME_CERTIFICADO"));
			            	cancelamento.setSenhaCertificado(cancelamentoLoteResult.getString("SENHA_CERTIFICADO"));
			            	cancelamento.setSituacao(cancelamentoLoteResult.getString("SITUACAO"));
			            	cancelamento.setMunicipio(cancelamentoLoteResult.getInt("MUNICIPIO"));
			            }
			            
			            principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nLote de cancelamento id: " + cancelamento.getId() + ".");

			            String path = "C:\\ServiceAssinador\\certificados\\";
			            
			            System.clearProperty("java.protocol.handler.pkgs");
			    		System.clearProperty("javax.net.ssl.keyStoreType");
			            System.clearProperty("javax.net.ssl.keyStore");
			            System.clearProperty("javax.net.ssl.keyStorePassword");
			    		
			    		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
			            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			            // Keystore com o certificado do cliente
			            System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
			            System.setProperty("javax.net.ssl.keyStore", path + cancelamento.getNomeCertificado());
			            System.setProperty("javax.net.ssl.keyStorePassword", cancelamento.getSenhaCertificado());
			            
			            principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nEfetuando envio na base da prefeitura.");
			            
			            if((cancelamento.getMunicipio() + "").equals(Constantes.MUNICIPIO_SAO_PAULO)){
				            //Envio do webservice
				            LoteNFeSoapProxy proxy = new LoteNFeSoapProxy();
				            
				            CancelamentoNFeRequest request = new CancelamentoNFeRequest();
				            
				            request.setVersaoSchema(1);
				            request.setMensagemXML(cancelamento.getArquivoEnvio());
				            
				            CancelamentoNFeResponse response = proxy.cancelamentoNFe(request);
				            
				            cancelamento.setArquivoRetorno(response.getRetornoXML());
				            
				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nSalvando retorno na base de dados.");
				    		
				    		//Atualizar banco de dados
				    		cancelamentoLoteDao.atualizarCancelamentoLote(cancelamento);
				    		
				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBase de dados atualizada.");
				    		
				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
			            }else if((cancelamento.getMunicipio() + "").equals(Constantes.MUNICIPIO_SAO_BERNARDO_DO_CAMPO)){
			            	//Envio do webservice
			            	ServiceGinfesImplProxy proxy = new ServiceGinfesImplProxy();

	            			cancelamento.setArquivoRetorno(proxy.cancelarNfse(cancelamento.getArquivoEnvio()));
	            			
	            			principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nSalvando retorno na base de dados.");
	            			
	            			//Atualizar banco de dados
				    		cancelamentoLoteDao.atualizarCancelamentoLote(cancelamento);
				    		
				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBase de dados atualizada.");
				    		
				    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
			            }
		            }else{
		            	principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nNão existe registro para ser enviado.");
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
		            }
				}else if(metodo == Constantes.METODO_ENVIAR_LOTE_NFE){
					principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBuscando registro na base de dados.");
					
					EnvioLote envioBusca = new EnvioLote();
					
					envioBusca.setSituacao("Aguardando Envio");
					
					EnvioLoteDAO envioLoteDao = new EnvioLoteDAO();

		            ResultSet envioLoteResult = envioLoteDao.getEnvioLoteMercadoria(envioBusca);
		            
		            EnvioLote envio = new EnvioLote();
		            
		            while(envioLoteResult.next()){
		            	envio.setId(envioLoteResult.getInt("ID"));
			            envio.setArquivoEnvio(envioLoteResult.getString("ARQUIVO_ENVIO"));
			            envio.setNomeCertificado(envioLoteResult.getString("NOME_CERTIFICADO"));
			            envio.setSenhaCertificado(envioLoteResult.getString("SENHA_CERTIFICADO"));
			            envio.setSituacao(envioLoteResult.getString("SITUACAO"));
			            envio.setMunicipio(envioLoteResult.getInt("MUNICIPIO"));
			            envio.setEstado(envioLoteResult.getInt("ESTADO"));
		            }
		            
		            if(envio.getArquivoEnvio() != null && !envio.getArquivoEnvio().equals("")){  
			            // Enderecos de Homoloção do Sefaz Virtual para cada WebService existe um endereco Diferente. 
		            	//TODO verificar URLs de homologacao de producao de acordo com o que foi enviado pelo cliente / NFECacerts tambem
			            URL url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeRecepcao2.asmx");   
			            
			            String path = "C:\\ServiceAssinador\\certificados\\";

			            InputStream entrada = new FileInputStream(path + envio.getNomeCertificado());  
			            KeyStore ks = KeyStore.getInstance("pkcs12");  
			            try {  
			                ks.load(entrada, envio.getSenhaCertificado().toCharArray());  
			            } catch (IOException e) {  
			                throw new Exception("Senha do Certificado Digital esta incorreta ou Certificado inválido.");  
			            }  
			            
			            String alias = "";    
			            Enumeration<String> aliasesEnum = ks.aliases();    
			            while (aliasesEnum.hasMoreElements()) {    
			                alias = (String) aliasesEnum.nextElement();    
			                if (ks.isKeyEntry(alias)) break;    
			            }  
			            X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);  
			            PrivateKey privateKey = (PrivateKey) ks.getKey(alias, envio.getSenhaCertificado().toCharArray());  
			            SocketFactoryDinamico socketFactoryDinamico = new SocketFactoryDinamico(certificate, privateKey);  
			            socketFactoryDinamico.setFileCacerts(path + "NFeCacerts");  
			  
			            Protocol protocol = new Protocol("https", socketFactoryDinamico, SSL_PORT);    
			            Protocol.registerProtocol("https", protocol);

			            OMElement ome = AXIOMUtil.stringToOM(envio.getArquivoEnvio());  
			  
			            Iterator<?> children = ome.getChildrenWithLocalName("NFe");    
			            while (children.hasNext()) {  
			                OMElement omElement = (OMElement) children.next();    
			                if ((omElement != null) && ("NFe".equals(omElement.getLocalName()))) {    
			                    omElement.addAttribute("xmlns", "http://www.portalfiscal.inf.br/nfe", null);    
			                }  
			            }  
			  
			            NfeRecepcao2Stub.NfeDadosMsg dadosMsg = new NfeRecepcao2Stub.NfeDadosMsg();  
			            dadosMsg.setExtraElement(ome);  
			            NfeRecepcao2Stub.NfeCabecMsg nfeCabecMsg = new NfeRecepcao2Stub.NfeCabecMsg();  
			             
			            // Codigo do Estado. 
			            nfeCabecMsg.setCUF(envio.getEstado() + "");  
			             
			            // Versao do XML 
			            nfeCabecMsg.setVersaoDados("2.00");  
			  
			            NfeRecepcao2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeRecepcao2Stub.NfeCabecMsgE();  
			            nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);  
			  
			            NfeRecepcao2Stub stub = new NfeRecepcao2Stub(url.toString());  
			            NfeRecepcao2Stub.NfeRecepcaoLote2Result result = stub.nfeRecepcaoLote2(dadosMsg, nfeCabecMsgE);  

			            envio.setArquivoRetorno(result.getExtraElement().toString());
			            envio.setSituacao("Aguardando Retorno");
			            
			            //Lendo o retorno e guardando o protocolo
					            
			            SAXBuilder sb = new SAXBuilder();
						
						InputStream stream = new ByteArrayInputStream(envio.getArquivoRetorno().getBytes("UTF-8"));
			            
			            Document d = sb.build(stream);
			            
			            Element retEnviNFe = d.getRootElement();  
			            
			            List elements = retEnviNFe.getChildren();  
			            Iterator i = elements.iterator();  
			           
			            //Iteramos com os elementos filhos, e filhos do dos filhos  
			            while (i.hasNext()) {  
			               Element element = (Element) i.next();  
			               
			               System.out.println(element.getName());
			               if(element.getName() == "infRec"){
			            	   //System.out.println(element.getChildText("nRec"));
			            	   //System.out.println(element.getChildText("tMed"));
			            	   
			            	   
			            	   List elementsChildren = element.getChildren();
			            	   Iterator i2 = elementsChildren.iterator();
			            	   
			            	   while(i2.hasNext()){
			            		   Element elementChild = (Element) i2.next();
			            		   if(elementChild.getName() == "nRec"){
			            			   System.out.println(elementChild.getName());
				            		   System.out.println(elementChild.getText());
				            		   envio.setProtocolo(elementChild.getText()); // Definindo protocolo
			            		   }
			            	   }
			               }
			            }
					            
			            principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nSalvando retorno na base de dados.");
			    		
			    		//Atualizar banco de dados
			    		envioLoteDao.atualizarEnvioLote(envio);
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBase de dados atualizada.");
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
		            }else{
		            	principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nNão existe registro para ser enviado.");
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
		            }
				}else if(metodo == Constantes.METODO_CONSULTAR_LOTE_NFE){
					principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBuscando registro na base de dados.");
					
					EnvioLoteDAO envioLoteDao = new EnvioLoteDAO();
					
					EnvioLote envioBusca = new EnvioLote();
					
					envioBusca.setSituacao("Aguardando Retorno");

		            ResultSet envioLoteResult = envioLoteDao.getEnvioLoteMercadoria(envioBusca);
		            
		            EnvioLote envio = new EnvioLote();
		            
		            while(envioLoteResult.next()){
		            	envio.setId(envioLoteResult.getInt("ID"));
			            envio.setArquivoEnvio(envioLoteResult.getString("ARQUIVO_ENVIO"));
			            envio.setArquivoRetorno(envioLoteResult.getString("ARQUIVO_RETORNO"));
			            envio.setArquivoRetornoConsultaLote(envioLoteResult.getString("ARQUIVO_RETORNO_CONSULTA_LOTE"));
			            envio.setNomeCertificado(envioLoteResult.getString("NOME_CERTIFICADO"));
			            envio.setSenhaCertificado(envioLoteResult.getString("SENHA_CERTIFICADO"));
			            envio.setSituacao(envioLoteResult.getString("SITUACAO"));
			            envio.setMunicipio(envioLoteResult.getInt("MUNICIPIO"));
			            envio.setEstado(envioLoteResult.getInt("ESTADO"));
			            envio.setProtocolo(envioLoteResult.getString("PROTOCOLO"));
		            }
		            
		            if(envio.getProtocolo() != null && !envio.getProtocolo().equals("")){
			            String path = "C:\\ServiceAssinador\\certificados\\";
			            
			            InputStream entrada = new FileInputStream(path + envio.getNomeCertificado());  
			            KeyStore ks = KeyStore.getInstance("pkcs12");  
			            try {  
			                ks.load(entrada, envio.getSenhaCertificado().toCharArray());  
			            } catch (IOException e) {  
			                throw new Exception("Senha do Certificado Digital esta incorreta ou Certificado inválido.");  
			            }  
			            
			            String alias = "";    
			            Enumeration<String> aliasesEnum = ks.aliases();    
			            while (aliasesEnum.hasMoreElements()) {    
			                alias = (String) aliasesEnum.nextElement();    
			                if (ks.isKeyEntry(alias)) break;    
			            }  
			            X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);  
			            PrivateKey privateKey = (PrivateKey) ks.getKey(alias, envio.getSenhaCertificado().toCharArray());  
			            SocketFactoryDinamico socketFactoryDinamico = new SocketFactoryDinamico(certificate, privateKey);  
			            socketFactoryDinamico.setFileCacerts(path + "NFeCacerts");  
			  
			            Protocol protocol = new Protocol("https", socketFactoryDinamico, SSL_PORT);    
			            Protocol.registerProtocol("https", protocol);

			            /*
			            System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");  
			            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
			  
			            System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");  
			  
			            System.clearProperty("javax.net.ssl.keyStore");  
			            System.clearProperty("javax.net.ssl.keyStorePassword");  
			            System.clearProperty("javax.net.ssl.trustStore");  
			  
			            System.setProperty("javax.net.ssl.keyStore", path + envio.getNomeCertificado());  
			            System.setProperty("javax.net.ssl.keyStorePassword", envio.getSenhaCertificado());  
			  
			            System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
			            System.setProperty("javax.net.ssl.trustStore", path + "NFeCacerts"); 
						*/
			            
			            //TODO ajustar tpAmb de acordo com o que o cliente enviar 
						String msg =  
				                  "<nfeDadosMsg xmlns:ns1=\"http://www.portalfiscal.inf.br/nfe/wsdl/NfeRetRecepcao2\">"  
				                + "<consReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\">"  
				                + "<tpAmb>2</tpAmb>"  
				                + "<nRec>" + envio.getProtocolo() + "</nRec>"  
				                + "</consReciNFe>"  
				                + "</nfeDadosMsg>"; 
						
						NfeRetRecepcao2Stub stub = new NfeRetRecepcao2Stub();  
			            NfeRetRecepcao2Stub.NfeCabecMsg nfeCabec = new NfeRetRecepcao2Stub.NfeCabecMsg();  
			            nfeCabec.setCUF(envio.getEstado() + "");  
			            nfeCabec.setVersaoDados("2.00");  
			  
			            NfeRetRecepcao2Stub.NfeCabecMsgE cabecMsgE = new NfeRetRecepcao2Stub.NfeCabecMsgE();  
			            cabecMsgE.setNfeCabecMsg(nfeCabec);  
			              
			            XMLStreamReader dadosXML = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(msg));  
			            NfeRetRecepcao2Stub.NfeDadosMsg nfeDadosMsg = NfeRetRecepcao2Stub.NfeDadosMsg.Factory.parse(dadosXML);  
			            
			            envio.setArquivoRetornoConsultaLote(stub.nfeRetRecepcao2(nfeDadosMsg, cabecMsgE).getExtraElement().toString());
			            envio.setSituacao("Retorno Processado");
			            
			            //Atualizar banco de dados
			    		envioLoteDao.atualizarEnvioLote(envio);
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBase de dados atualizada.");
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
		            }else{
		            	principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nNão existe registro para ser enviado.");
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
		            }
				}else if(metodo == Constantes.METODO_CANCELAR_NFE){
					//TODO
				}

	    		Thread.sleep(6000);
			}catch(Exception e){
				e.printStackTrace();
				principal.getTextArea().setText(principal.getTextArea().getText() + "\r\n" + e.getMessage());
				principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
				Thread.sleep(6000);
			}
			
			if(metodo == 5)
				metodo = 1;
			else
				metodo++;
		}
	}
}
