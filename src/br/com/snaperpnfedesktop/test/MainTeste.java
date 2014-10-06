package br.com.snaperpnfedesktop.test;

import java.sql.ResultSet;

import br.com.snaperpnfedesktop.bean.EnvioLote;
import br.com.snaperpnfedesktop.dao.EnvioLoteDAO;
import br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSRequest;
import br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSResponse;
import br.gov.sp.prefeitura.www.nfe.LoteNFeSoapProxy;

public class MainTeste {
	public static void main(String[] args) {	
		try{
			EnvioLoteDAO envioLoteDao = new EnvioLoteDAO();

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
    		envioLoteDao.atualizarEnvioLote(envio);			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
