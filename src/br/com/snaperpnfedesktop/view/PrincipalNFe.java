package br.com.snaperpnfedesktop.view;

import java.sql.ResultSet;

import br.com.snaperpnfedesktop.bean.CancelamentoLote;
import br.com.snaperpnfedesktop.bean.EnvioLote;
import br.com.snaperpnfedesktop.dao.CancelamentoLoteDAO;
import br.com.snaperpnfedesktop.dao.EnvioLoteDAO;
import br.gov.sp.prefeitura.www.nfe.CancelamentoNFeRequest;
import br.gov.sp.prefeitura.www.nfe.CancelamentoNFeResponse;
import br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSRequest;
import br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSResponse;
import br.gov.sp.prefeitura.www.nfe.LoteNFeSoapProxy;

public class PrincipalNFe {
	public static void main(String[] args) throws Exception {
		Principal principal = new Principal();
		
		int metodo = 1;
		
		while(true){
			try{
				principal.getTextArea().setText("");

				if(metodo == 1){
					principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBuscando registro na base de dados.");
					
					EnvioLoteDAO envioLoteDao = new EnvioLoteDAO();

		            ResultSet envioLoteResult = envioLoteDao.getEnvioLote();
		            
		            EnvioLote envio = new EnvioLote();
		            
		            while(envioLoteResult.next()){
		            	envio.setId(envioLoteResult.getInt("ID"));
			            envio.setArquivoEnvio(envioLoteResult.getString("ARQUIVO_ENVIO"));
			            envio.setNomeCertificado(envioLoteResult.getString("NOME_CERTIFICADO"));
			            envio.setSenhaCertificado(envioLoteResult.getString("SENHA_CERTIFICADO"));
			            envio.setSituacao(envioLoteResult.getString("SITUACAO"));
			            envio.setMunicipio(envioLoteResult.getInt("MUNICIPIO"));
		            }
		            
		            if(!envio.getArquivoEnvio().equals(null) && !envio.getArquivoEnvio().equals("")){
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
			            
			            /*
			            LoteNFeSoapProxy proxy = new LoteNFeSoapProxy();
			            
			            CancelamentoNFeRequest request = new CancelamentoNFeRequest();
			            
			            request.setVersaoSchema(1);
			            request.setMensagemXML(envio.getArquivoEnvio());
			            
			            CancelamentoNFeResponse response = proxy.cancelamentoNFe(request);
			            
			            response.getRetornoXML();
						*/
			            //Envio do webservice
			            LoteNFeSoapProxy proxy = new LoteNFeSoapProxy();
						
						EnvioLoteRPSRequest request = new EnvioLoteRPSRequest();
			    		
			    		request.setVersaoSchema(1);
			    		request.setMensagemXML(envio.getArquivoEnvio());
			    		
			    		EnvioLoteRPSResponse response = proxy.envioLoteRPS(request);
			    		
			    		envio.setArquivoRetorno(response.getRetornoXML());
			    		//Envio do webservice

			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nSalvando retorno na base de dados.");
			    		
			    		//Atualizar banco de dados
			    		envioLoteDao.atualizarEnvioLote(envio);
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBase de dados atualizada.");
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
		            }else{
		            	principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nNão existe registro para ser enviado.");
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
		            }
				}else{
					principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBuscando registro na base de dados.");
					
					CancelamentoLoteDAO cancelamentoLoteDao = new CancelamentoLoteDAO(); 

		            ResultSet cancelamentoLoteResult = cancelamentoLoteDao.getCancelamentoLote();
		            
		            CancelamentoLote cancelamento = new CancelamentoLote();
		            
		            while(cancelamentoLoteResult.next()){
		            	cancelamento.setId(cancelamentoLoteResult.getInt("ID"));
		            	cancelamento.setArquivoEnvio(cancelamentoLoteResult.getString("ARQUIVO_ENVIO"));
		            	cancelamento.setNomeCertificado(cancelamentoLoteResult.getString("NOME_CERTIFICADO"));
		            	cancelamento.setSenhaCertificado(cancelamentoLoteResult.getString("SENHA_CERTIFICADO"));
		            	cancelamento.setSituacao(cancelamentoLoteResult.getString("SITUACAO"));
		            	cancelamento.setMunicipio(cancelamentoLoteResult.getInt("MUNICIPIO"));
		            }
		            
		            if(!cancelamento.getArquivoEnvio().equals(null) && !cancelamento.getArquivoEnvio().equals("")){
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
			            
			            //Envio do webservice
			            LoteNFeSoapProxy proxy = new LoteNFeSoapProxy();
			            
			            CancelamentoNFeRequest request = new CancelamentoNFeRequest();
			            
			            request.setVersaoSchema(1);
			            request.setMensagemXML(cancelamento.getArquivoEnvio());
			            
			            CancelamentoNFeResponse response = proxy.cancelamentoNFe(request);
			            
			            cancelamento.setArquivoRetorno(response.getRetornoXML());
			            //Envio do webservice

			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nSalvando retorno na base de dados.");
			    		
			    		//Atualizar banco de dados
			    		cancelamentoLoteDao.atualizarCancelamentoLote(cancelamento);
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nBase de dados atualizada.");
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
		            }else{
		            	principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nNão existe registro para ser enviado.");
			    		
			    		principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
		            }
				}

	    		Thread.sleep(6000);
			}catch(Exception e){
				e.printStackTrace();
				principal.getTextArea().setText(principal.getTextArea().getText() + "\r\n" + e.getMessage());
				principal.getTextArea().setText(principal.getTextArea().getText() + "\r\nAguardando proximo servico.");
				Thread.sleep(6000);
			}
			
			if(metodo == 2)
				metodo = 1;
			else
				metodo++;
		}
	}
}
