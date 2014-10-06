package br.com.serviceassinador.controller;


import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Enumeration;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.axis.encoding.Base64;
import org.w3c.dom.Document;

public class Assinador {
	
	private Certificate certificado; 

	public String assinarDocumento(String path,String arquivo, PrivateKey privateKey, PublicKey publicKey) {
		try {
			
			String nomeArquivo = "" + System.currentTimeMillis();
			
			File file = new File(path + "arquivo" + nomeArquivo +  ".xml");
	        BufferedWriter output = new BufferedWriter(new FileWriter(file));
	        output.write(arquivo);
	        output.close();
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
			dbf.setNamespaceAware(true); 
			DocumentBuilder builder = dbf.newDocumentBuilder();  
			Document doc = builder.parse(new FileInputStream(path + "arquivo" + nomeArquivo +  ".xml"));
			
			//Gera o Par de chaves - Não é utilizado
			/*KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(1024);
			KeyPair kp = kpg.generateKeyPair();*/
			
			//Cria um contexto de assinatura
			//DOMSignContext dsc = new DOMSignContext(kp.getPrivate(), doc.getDocumentElement());
			DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
			
			//Cria um XMLSignatureFactory. Utilizado para criar os objetos necessários na assinatura 
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM"); 
			
			//Cria a referencia da assinatura (<reference URI="">)
			Reference ref = fac.newReference
			("", fac.newDigestMethod(DigestMethod.SHA1, null),
					Collections.singletonList
					(fac.newTransform(Transform.ENVELOPED,
							(TransformParameterSpec) null)), null, null); 
			
			//Cria a Informação da assinatura - Usada para padronizar a formatação do xml (canonical)
			SignedInfo si = fac.newSignedInfo
			(fac.newCanonicalizationMethod
					(CanonicalizationMethod.INCLUSIVE,
							(C14NMethodParameterSpec) null),
							fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
							Collections.singletonList(ref));
			
			//Pega o certificado de acordo com o Alias ("lello")
			//X509Certificate certificado = (X509Certificate) keyStore.getCertificate(alias);
			X509Certificate certificado = (X509Certificate) getCertificado();
			
			//Cria as informações das chaves
			KeyInfoFactory kif = fac.getKeyInfoFactory();
			X509Data data = kif.newX509Data(Collections.singletonList(certificado));
			KeyInfo ki = kif.newKeyInfo(Collections.singletonList(data));
			
			//Cria a assinatura dentro do contexto de assinatura
			XMLSignature signature = fac.newXMLSignature(si, ki); 
			signature.sign(dsc);
			
			//Inicia o "transform"
			TransformerFactory tf = TransformerFactory.newInstance();  
			Transformer trans = tf.newTransformer();  
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			
			//Cria os arquivos de "resultado" (fisico e string de retorno)
			FileOutputStream f = new FileOutputStream(path + "arquivo2" + nomeArquivo +  ".xml");
			OutputStream os = new  ByteArrayOutputStream();
			
			//Assina os arquivos de acordo com os contextos de assinatura
			DOMSource dom = new DOMSource(doc);
			trans.transform(dom, new StreamResult(os));
			trans.transform(dom, new StreamResult(f));
			
			f.flush();
			f.close();
			
			String retorno = os.toString(); 
			
			os.close();
			
			//Deletando arquivos criados
			File f1 = new File(path + "arquivo" + nomeArquivo +  ".xml");
			
			f1.delete();
			
			File f2 = new File(path + "arquivo2" + nomeArquivo +  ".xml");
			
			f2.delete();
			//Deletando arquivos criados
			
			return retorno;
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			return e.getMessage();
		}catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	/**
     * Get the private key from a KeyStore in PKCS#12 format (*.PFX created
     * by Microsoft IE/OE and others)
     */
    public PrivateKey getPrivateKeyFromPFX(String keyStore, char[] password) {
        try {
            FileInputStream fis = new FileInputStream(keyStore);
            // supported KeyStore types (JDK1.4): PKCS12 and JKS (native Sun)
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(fis, password);
            for (Enumeration en=ks.aliases(); en.hasMoreElements(); ) {
                String alias = (String)en.nextElement();
                if (ks.isKeyEntry(alias)) {
                    return (PrivateKey)ks.getKey(alias, password);
                }
            }
        } catch (IOException ex) {
            //log.error(ex);
        } catch (Exception ex) {
            //log.error(ex);
        }
        return null;        
    }    
    
    /**
     * Get the public key from a KeyStore in PKCS#12 format (*.PFX created
     * by Microsoft IE/OE and others)
     */
    public PublicKey getPublicKeyFromPFX(String keyStore, char[] password) {
        try {
            FileInputStream fis = new FileInputStream(keyStore);
            // supported KeyStore types (JDK1.4): PKCS12 and JKS (native Sun)
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(fis, password);
            for (Enumeration en=ks.aliases(); en.hasMoreElements(); ) {
                String alias = (String)en.nextElement();
                if (ks.isKeyEntry(alias)) {
                	setCertificado(ks.getCertificate(alias));
                    return ks.getCertificate(alias).getPublicKey();
                }
            }
        } catch (IOException ex) {
            //log.error(ex);
        } catch (Exception ex) {
            //log.error(ex);
        }
        return null;        
    } 
    
    public String assinarString(byte[] textoParaAssinar, String certificadoFullName, String senha) {
        Signature signer = null;
        String hash = "";
        try{
        	signer = Signature.getInstance("SHA1withRSA");
            signer.initSign(getPrivateKeyFromPFX(certificadoFullName, senha.toCharArray()));
            signer.update(textoParaAssinar);
            hash = Base64.encode(signer.sign());
            //hash = Base64.encodeBase64String(signer.sign());
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return hash;
    }
    
    public Certificate getCertificado() {
		return certificado;
	}

	public void setCertificado(Certificate certificado) {
		this.certificado = certificado;
	}
}