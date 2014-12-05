package br.com.snaperpnfedesktop.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class MainTeste {
	public static void main(String[] args) {	
		try{
			/*EnvioLoteDAO envioLoteDao = new EnvioLoteDAO();

            ResultSet envioLoteResult = envioLoteDao.getEnvioLote();
            
            EnvioLote envio = new EnvioLote();
        	
        	envio.setId(envioLoteResult.getInt("ID"));
            envio.setArquivoEnvio(envioLoteResult.getString("ARQUIVO_ENVIO"));
            envio.setNomeCertificado(envioLoteResult.getString("NOME_CERTIFICADO"));
            envio.setSenhaCertificado(envioLoteResult.getString("SENHA_CERTIFICADO"));
            envio.setSituacao(envioLoteResult.getString("SITUACAO"));
            envio.setMunicipio(envioLoteResult.getInt("MUNICIPIO"));

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
            
            //Envio do webservice
            LoteNFeSoapProxy proxy = new LoteNFeSoapProxy();
			
			EnvioLoteRPSRequest request = new EnvioLoteRPSRequest();
    		
    		request.setVersaoSchema(1);
    		request.setMensagemXML(envio.getArquivoEnvio());
    		
    		EnvioLoteRPSResponse response = proxy.envioLoteRPS(request);
    		
    		envio.setArquivoRetorno(response.getRetornoXML());
    		//Envio do webservice

    		//Atualizar banco de dados
    		envioLoteDao.atualizarEnvioLote(envio);*/
			
			SAXBuilder sb = new SAXBuilder();
			
			InputStream stream = new ByteArrayInputStream("<retEnviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>35</cUF><dhRecbto>2014-10-29T13:00:19</dhRecbto><infRec><nRec>351000084927760</nRec><tMed>1</tMed></infRec></retEnviNFe>".getBytes("UTF-8"));
            
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
            		   
            		   System.out.println(elementChild.getName());
            		   System.out.println(elementChild.getText());
            	   }
               }
               /*
               System.out.println("Códido:"+ element.getAttributeValue("id"));  
               System.out.println("Prioridade:"+ element.getAttributeValue("prioridade"));  
               System.out.println("Para:"+ element.getChildText("para"));  
               System.out.println("De:"+ element.getChildText("de"));  
               System.out.println("Corpo:"+ element.getChildText("corpo"));
               */  
            }
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
