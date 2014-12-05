package br.com.snaperpnfedesktop.controller;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;

import br.com.ginfes.producao.ServiceGinfesImplProxy;
import br.com.snaperpnfedesktop.dao.EnvioLoteDAO;
import br.gov.sp.prefeitura.www.nfe.CancelamentoNFeRequest;
import br.gov.sp.prefeitura.www.nfe.ConsultaLoteRequest;

public class Executar {
	private static Executar INSTANCE = new Executar();

    private Executar() {
    }

    public static Executar getInstance(){
    	return INSTANCE;
    }
    
    public synchronized String executarMetodo(String nomeCertificado, String senha, String arquivo, int metodo, String municipio, List<String> assinaturasSP){
    	try{
    		Assinador assinador = new Assinador();
    		
    		String path = "C:\\ServiceAssinador\\certificados\\";
    		
    		System.out.println("#### certificado - " + path + nomeCertificado);
    		System.out.println("#### senha - " + senha);
    		
    		PublicKey chavePublica = assinador.getPublicKeyFromPFX(path + nomeCertificado, senha.toCharArray());
    		PrivateKey chavePrivada = assinador.getPrivateKeyFromPFX(path + nomeCertificado, senha.toCharArray());
    		
    		System.clearProperty("java.protocol.handler.pkgs");
    		System.clearProperty("javax.net.ssl.keyStoreType");
            System.clearProperty("javax.net.ssl.keyStore");
            System.clearProperty("javax.net.ssl.keyStorePassword");
    		
    		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            // Keystore com o certificado do cliente
            System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
            System.setProperty("javax.net.ssl.keyStore", path + nomeCertificado);
            System.setProperty("javax.net.ssl.keyStorePassword", senha);
        	
        	if(municipio.equals(Constantes.MUNICIPIO_SAO_BERNARDO_DO_CAMPO)){
        		if(metodo == Constantes.METODO_ENVIAR_LOTE_RPS){
        			String retorno = assinador.assinarDocumento(path, arquivo, chavePrivada, chavePublica);

        			ServiceGinfesImplProxy proxy = new ServiceGinfesImplProxy();
        			
        			System.out.println("#### " + retorno);
        			
        			return proxy.recepcionarLoteRpsV3("<ns2:cabecalho versao=\"3\" xmlns:ns2=\"http://www.ginfes.com.br/cabecalho_v03.xsd\"><versaoDados>3</versaoDados></ns2:cabecalho>", retorno);
        		}else if(metodo == Constantes.METODO_CONSULTAR_LOTE_RPS){
        			String retorno = assinador.assinarDocumento(path, arquivo, chavePrivada, chavePublica);

        			ServiceGinfesImplProxy proxy = new ServiceGinfesImplProxy();
        			
        			System.out.println("#### " + retorno);
        			
        			return proxy.consultarLoteRpsV3("<ns2:cabecalho versao=\"3\" xmlns:ns2=\"http://www.ginfes.com.br/cabecalho_v03.xsd\"><versaoDados>3</versaoDados></ns2:cabecalho>", retorno);
        		}else if(metodo == Constantes.METODO_CANCELAR_RPS){
        			String retorno = assinador.assinarDocumento(path, arquivo, chavePrivada, chavePublica);
        			
        			ServiceGinfesImplProxy proxy = new ServiceGinfesImplProxy();
        			
        			System.out.println("#### " + retorno);
        			
        			return proxy.cancelarNfse(retorno);
        		}else{
        			return "Método Não Implementado";
        		}
        		
        	}else if(municipio.equals(Constantes.MUNICIPIO_SAO_PAULO)){
        		if(metodo == Constantes.METODO_ENVIAR_LOTE_RPS){
        			for(String assinatura : assinaturasSP){
        				String numeroRPS = assinatura.split("-")[0];
        				String ass = assinatura.split("-")[1];
        				
        				String stringAssinada = assinador.assinarString(ass.getBytes(), path + nomeCertificado, senha);
        				
        				arquivo = arquivo.replace("[ASSINATURA-" + numeroRPS + "]", stringAssinada);
        			}
        			
        			String retorno = assinador.assinarDocumento(path, arquivo, chavePrivada, chavePublica);

        			System.out.println("#### " + retorno);
        			
        			EnvioLoteDAO envioDao = new EnvioLoteDAO();
        			
        			envioDao.inserirEnvioLote(nomeCertificado, senha, retorno, municipio);
        			
        			/*
        			
        			LoteNFeSoapProxy proxy = new LoteNFeSoapProxy();
        			
        			EnvioLoteRPSRequest request = new EnvioLoteRPSRequest();
            		
            		request.setVersaoSchema(1);
            		request.setMensagemXML(retorno);
            		
            		EnvioLoteRPSResponse response = proxy.envioLoteRPS(request);
            		
            		return response.getRetornoXML();
            		*/
            		return "Arquivo Enviado com Sucesso";
        		}else if(metodo == Constantes.METODO_CONSULTAR_LOTE_RPS){
        			String retorno = assinador.assinarDocumento(path, arquivo, chavePrivada, chavePublica);
        			
        			ConsultaLoteRequest request = new ConsultaLoteRequest();
        			
        			request.setVersaoSchema(1);
        			request.setMensagemXML(retorno);
        			
//        			ConsultaLoteResponse response = stub.consultaLote(request);
        			
  //      			return response.getRetornoXML();
        			return "";
        		}else if(metodo == Constantes.METODO_CANCELAR_RPS){
        			String retorno = assinador.assinarDocumento(path, arquivo, chavePrivada, chavePublica);
        			
        			CancelamentoNFeRequest request = new CancelamentoNFeRequest();
        			
        			request.setVersaoSchema(1);
        			request.setMensagemXML(retorno);
        			
    //    			CancelamentoNFeResponse response = stub.cancelamentoNFe(request);
        			
      //  			return response.getRetornoXML();
        			return "";
        		}else{
        			return "Método Não Implementado";
        		}
        	}else{
        		return "Município não implementado.";
        	}
    	}catch(Exception e){
    		e.printStackTrace();
    		return e.getMessage();
    	}
    }
}
