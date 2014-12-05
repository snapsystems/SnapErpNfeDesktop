package br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2;

import java.io.StringReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import br.inf.portalfiscal.www.nfe.wsdl.nferetrecepcao2.NfeRetRecepcao2Stub;

public class MainTeste {
	public static void main(String[] args) {
		try{
			
			/*
			 * Consulta de Lote
			 * 
			 */ 
			 
			
			String caminhoDoCertificadoDoCliente = "/Users/brunosoaresbarros/Documents/Desenvolvimento/ProjetoNFe/TestesCertificados/Certificado_A1_Snap_NF.pfx";  
            String senhaDoCertificadoDoCliente = "snap2004";  
            String arquivoCacertsGeradoParaCadaEstado = "/Users/brunosoaresbarros/Documents/Desenvolvimento/ProjetoNFe/TestesCertificados/NFeCacerts";
            
            System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");  
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
  
            System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");  
  
            System.clearProperty("javax.net.ssl.keyStore");  
            System.clearProperty("javax.net.ssl.keyStorePassword");  
            System.clearProperty("javax.net.ssl.trustStore");  
  
            System.setProperty("javax.net.ssl.keyStore", caminhoDoCertificadoDoCliente);  
            System.setProperty("javax.net.ssl.keyStorePassword", senhaDoCertificadoDoCliente);  
  
            System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
            System.setProperty("javax.net.ssl.trustStore", arquivoCacertsGeradoParaCadaEstado); 
			
			String msg =  
	                  "<nfeDadosMsg xmlns:ns1=\"http://www.portalfiscal.inf.br/nfe/wsdl/NfeRetRecepcao2\">"  
	                + "<consReciNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\">"  
	                + "<tpAmb>2</tpAmb>"  
	                + "<nRec>351000084812733</nRec>"  
	                + "</consReciNFe>"  
	                + "</nfeDadosMsg>"; 
			
			NfeRetRecepcao2Stub stub = new NfeRetRecepcao2Stub();  
            NfeRetRecepcao2Stub.NfeCabecMsg nfeCabec = new NfeRetRecepcao2Stub.NfeCabecMsg();  
            nfeCabec.setCUF("35");  
            nfeCabec.setVersaoDados("2.00");  
  
            NfeRetRecepcao2Stub.NfeCabecMsgE cabecMsgE = new NfeRetRecepcao2Stub.NfeCabecMsgE();  
            cabecMsgE.setNfeCabecMsg(nfeCabec);  
  
  
              
            XMLStreamReader dadosXML = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(msg));  
            NfeRetRecepcao2Stub.NfeDadosMsg nfeDadosMsg = NfeRetRecepcao2Stub.NfeDadosMsg.Factory.parse(dadosXML);  
  
              
            String respStatus = stub.nfeRetRecepcao2(nfeDadosMsg, cabecMsgE).getExtraElement().toString();
            
            System.out.println("#### " + respStatus);
			
            /*
             * Retorno - <retConsReciNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><nRec>351000084756115</nRec><cStat>225</cStat><xMotivo>Rejeição: Falha no Schema XML do lote de NFe</xMotivo><cUF>35</cUF></retConsReciNFe>
             * Retorno Correto de acordo com o xml do Fabio - <retConsReciNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><nRec>351000084793444</nRec><cStat>104</cStat><xMotivo>Lote processado</xMotivo><cUF>35</cUF><protNFe versao="2.00"><infProt><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><chNFe>35140205533480000170550010000000021080090204</chNFe><dhRecbto>2014-10-21T16:21:15</dhRecbto><cStat>213</cStat><xMotivo>Rejeição: CNPJ-Base do Emitente difere do CNPJ-Base do Certificado Digital</xMotivo></infProt></protNFe></retConsReciNFe>
             * <retConsReciNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><nRec>351000084799001</nRec><cStat>104</cStat><xMotivo>Lote processado</xMotivo><cUF>35</cUF><protNFe versao="2.00"><infProt><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><chNFe>35140205533480000170550010000000021080090204</chNFe><dhRecbto>2014-10-22T02:58:31</dhRecbto><cStat>502</cStat><xMotivo>Rejeição: Erro na Chave de Acesso - Campo Id não corresponde à concatenação dos campos correspondentes</xMotivo></infProt></protNFe></retConsReciNFe>
             * <retConsReciNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><nRec>351000084810433</nRec><cStat>225</cStat><xMotivo>Rejeição: Falha no Schema XML do lote de NFe</xMotivo><cUF>35</cUF></retConsReciNFe>
             * <retConsReciNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><nRec>351000084810841</nRec><cStat>225</cStat><xMotivo>Rejeição: Falha no Schema XML do lote de NFe</xMotivo><cUF>35</cUF></retConsReciNFe>
             * <retConsReciNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><nRec>351000084811643</nRec><cStat>225</cStat><xMotivo>Rejeição: Falha no Schema XML do lote de NFe</xMotivo><cUF>35</cUF></retConsReciNFe>
             * <retConsReciNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><nRec>351000084812733</nRec><cStat>104</cStat><xMotivo>Lote processado</xMotivo><cUF>35</cUF><protNFe versao="2.00"><infProt><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><chNFe>35141007343014000157550010000021941911220364</chNFe><dhRecbto>2014-10-22T17:31:24</dhRecbto><cStat>209</cStat><xMotivo>Rejeição: IE do emitente inválida</xMotivo></infProt></protNFe></retConsReciNFe> 
             */
			
			
            /*
             * Envio de Lote 
            * / 
			
			 
             // 1) codigoDoEstado = Código do Estado conforme tabela IBGE. 
             // 
             // 2) url = Endereço do WebService para cada Estado. 
             //       Ver relação dos endereços em: 
             //       Para Homologação: http://hom.nfe.fazenda.gov.br/PORTAL/WebServices.aspx 
             //       Para Produção: http://www.nfe.fazenda.gov.br/portal/WebServices.aspx 
             // 
             // 3) caminhoDoCertificadoDoCliente = Caminho do Certificado do Cliente (A1). 
             // 
             // 4) senhaDoCertificadoDoCliente = Senha do Certificado A1 do Cliente. 
             //
             // 5) arquivoCacertsGeradoParaCadaEstado = Arquivo com os Certificados necessarios para 
             // acessar o WebService. Pode ser gerado com a Classe NFeBuildCacerts. 
               
            String codigoDoEstado = "35";  
  
             
             // Enderecos de Homoloção do Sefaz Virtual RS 
             // para cada WebService existe um endereco Diferente. 
              
            //URL url = new URL("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx");  
            //URL url = new URL("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/nferecepcao/NfeRecepcao2.asmx");
            URL url = new URL("https://homologacao.nfe.fazenda.sp.gov.br/nfeweb/services/NfeRecepcao2.asmx"); 
            //URL url = new URL("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/nferetrecepcao/NfeRetRecepcao2.asmx");  
            //URL url = new URL("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/nfecancelamento/NfeCancelamento2.asmx");  
            //URL url = new URL("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/nfeinutilizacao/NfeInutilizacao2.asmx");  
            //URL url = new URL("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/nfeconsulta/NfeConsulta2.asmx");  
            //URL url = new URL("https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/nfestatusservico/NfeStatusServico2.asmx");  
              
            String caminhoDoCertificadoDoCliente = "/Users/brunosoaresbarros/Documents/Desenvolvimento/ProjetoNFe/TestesCertificados/Certificado_A1_Snap_NF.pfx";  
            String senhaDoCertificadoDoCliente = "snap2004";  
            String arquivoCacertsGeradoParaCadaEstado = "/Users/brunosoaresbarros/Documents/Desenvolvimento/ProjetoNFe/TestesCertificados/NFeCacerts";  
  
             
             // Informações do Certificado Digital. 
              
            System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");  
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
  
            System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");  
  
            System.clearProperty("javax.net.ssl.keyStore");  
            System.clearProperty("javax.net.ssl.keyStorePassword");  
            System.clearProperty("javax.net.ssl.trustStore");  
  
            System.setProperty("javax.net.ssl.keyStore", caminhoDoCertificadoDoCliente);  
            System.setProperty("javax.net.ssl.keyStorePassword", senhaDoCertificadoDoCliente);  
  
            System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
            System.setProperty("javax.net.ssl.trustStore", arquivoCacertsGeradoParaCadaEstado);  
  
             
             // IMPORTANTE: O XML já deve ser assinado antes do envio. 
             // Lendo o Xml de um arquivo Gerado. 
               
            
            //StringBuilder xml = new StringBuilder();  
            //String linha = null;  
            //String caminhoArquivo = "C:/JavaC/NF-e/xml-teste.xml";  
            //BufferedReader in = new BufferedReader(new InputStreamReader(  
            //        new FileInputStream(caminhoArquivo), "ISO-8859-1"));  
            //while ((linha = in.readLine()) != null) {  
            //    xml.append(linha);  
            //}  
            //in.close();  
  
            //String xmlEnvNFe = xml.toString();
            
            /*
            String xmlEnvNFe = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><idLote>420</idLote><NFe><infNFe Id=\"NFe35140205533480000170550010000000021080090204\" versao=\"2.00\"><ide><cUF>35</cUF><cNF>08009020</cNF><natOp>Venda de producao</natOp><indPag>1</indPag><mod>55</mod><serie>1</serie><nNF>2</nNF><dEmi>2014-02-27</dEmi><tpNF>1</tpNF><cMunFG>3544608</cMunFG><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>4</cDV><tpAmb>1</tpAmb><finNFe>1</finNFe><procEmi>3</procEmi><verProc>2.2.21</verProc></ide><emit><CNPJ>05533480000170</CNPJ><xNome>Agropecuaria Macuquinho Ltda</xNome><xFant>Macuquinho</xFant><enderEmit><xLgr>Estrada municipal Sabino Bacuriti</xLgr><nro>Km.25</nro><xBairro>Tangara</xBairro><cMun>3544608</cMun><xMun>Sabino</xMun><UF>SP</UF><CEP>16440000</CEP><cPais>1058</cPais><xPais>BRASIL</xPais><fone>1130811106</fone></enderEmit><IE>594053428117</IE><CRT>1</CRT></emit><dest><CNPJ>05098402000194</CNPJ><xNome>N B Noroeste Borracha Industria e Comércio Ltda</xNome><enderDest><xLgr>Rod. Roberto Mario Perosa - SP 379</xLgr><nro>Km 21</nro><xBairro>Bacurizinho</xBairro><cMun>3556008</cMun><xMun>Urupes</xMun><UF>SP</UF><CEP>15850000</CEP><cPais>1058</cPais><xPais>BRASIL</xPais><fone>1735222222</fone></enderDest><IE>707062434114</IE><email>agnaldo@noroesteborracha.com.br</email></dest><det nItem=\"1\"><prod><cProd>100</cProd><cEAN/><xProd>Coagulo de borracha natural</xProd><NCM>40011000</NCM><CFOP>5102</CFOP><uCom>kg</uCom><qCom>684.0000</qCom><vUnCom>3.2300000000</vUnCom><vProd>2209.32</vProd><cEANTrib/><uTrib>kg</uTrib><qTrib>684.0000</qTrib><vUnTrib>3.2300000000</vUnTrib><indTot>1</indTot></prod><imposto><ICMS><ICMSSN102><orig>0</orig><CSOSN>400</CSOSN></ICMSSN102></ICMS><IPI><cEnq>99</cEnq><IPITrib><CST>99</CST><qUnid>0.0000</qUnid><vUnid>0.0000</vUnid><vIPI>0.00</vIPI></IPITrib></IPI><PIS><PISOutr><CST>99</CST><qBCProd>0.0000</qBCProd><vAliqProd>0.0000</vAliqProd><vPIS>0.00</vPIS></PISOutr></PIS><COFINS><COFINSOutr><CST>99</CST><qBCProd>0.0000</qBCProd><vAliqProd>0.0000</vAliqProd><vCOFINS>0.00</vCOFINS></COFINSOutr></COFINS></imposto></det><total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vBCST>0.00</vBCST><vST>0.00</vST><vProd>2209.32</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>2209.32</vNF></ICMSTot></total><transp><modFrete>1</modFrete></transp><cobr><fat><nFat>1</nFat><vOrig>2209.32</vOrig><vLiq>2209.32</vLiq></fat><dup><nDup>1</nDup><dVenc>2014-03-15</dVenc><vDup>2209.32</vDup></dup></cobr><infAdic><infAdFisco>ICMS-DIFERIMENTO CONF. ART.350 INCISO XI DO RICMS/SP/2000 (BORRACHA)</infAdFisco></infAdic></infNFe><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#NFe35140205533480000170550010000000021080090204\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>n9GwaMFT0nFBiJ08ctDIcXadYXA=</DigestValue></Reference></SignedInfo><SignatureValue>hKjH4Wa/i/QFVUvR59FY8HgzPXaZhfJST1t17NychGKfv/4Ke75vILP3ktdm4YtfIn7HPDorCUtN" + 
            		"oM0blPu5YXM1uFT2s4jgFKYA3VomdDAVUesNG4VmLskAtcL8xC7+nl48knLt6r3h8HtvZKWg6kCi" +
            		"JHEitdGn+pgS5BHAkwYY2pyWIcKKeI8FEkONz4Lgsf3RUMkc5jyg9naErPRVrWdpAsUzO4dQQS3E" +
            		"Kdw+IMgadVwws+7wE4OVDuCyBZZWXnHlThen0gHLroG3Bm3aCjQnddwOmBX2BIPKV3aBoTmsy5mS" +
            		"LLY1ge77qjPFX9kmTAxQVgaNwQjiQypE5RvzYg==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIIIATCCBemgAwIBAgIIC27X/OkKvBMwDQYJKoZIhvcNAQELBQAwdTELMAkGA1UEBhMCQlIxEzAR" +
            		"BgNVBAoTCklDUC1CcmFzaWwxNjA0BgNVBAsTLVNlY3JldGFyaWEgZGEgUmVjZWl0YSBGZWRlcmFs" +
            		"IGRvIEJyYXNpbCAtIFJGQjEZMBcGA1UEAxMQQUMgU0VSQVNBIFJGQiB2MjAeFw0xNDA1MjcxNDA4" +
            		"MDBaFw0xNTA1MjcxNDA4MDBaMIHpMQswCQYDVQQGEwJCUjELMAkGA1UECBMCU1AxEjAQBgNVBAcT" +
            		"CVNBTyBQQVVMTzETMBEGA1UEChMKSUNQLUJyYXNpbDE2MDQGA1UECxMtU2VjcmV0YXJpYSBkYSBS" +
            		"ZWNlaXRhIEZlZGVyYWwgZG8gQnJhc2lsIC0gUkZCMRYwFAYDVQQLEw1SRkIgZS1DTlBKIEExMRIw" +
            		"EAYDVQQLEwlBUiBTRVJBU0ExQDA+BgNVBAMTN1NOQVBTWVNURU1TIFBST0pFVE8gREUgU09GVFdB" +
            		"UkUgTFREQSBFUFA6MDczNDMwMTQwMDAxNTcwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIB" +
            		"AQCjOGPiOh6I/ql0KMhxhWf9BxsB6LdiyqrtSMChuBpRtx+Q1wfXTsuTw4tgYkymeDQSLMAxNzr6" +
            		"FGTauDXS+Srgv33r0NOXNahQPHGvCI9bpZINWsrrHxFnNA97yrUZlPhU0xtR3ReFd1ehJg+aGKIF" +
            		"nz116YzhsZpvwNnL9jR/I1wDX9n9VvaSo5VVAKm7ZAkvGDx1GJllIupN6KReqPVKj3EhoOFh9vXn" +
            		"3ykayCLxJ5I72CSOfcwO7VhsnnxdkLtPuBZxbbY5JrYJ++o6TBH3RsY19XtO6Jx2E9rUqFY5FgIb" +
            		"sUKvKx2uIVidMgMtR5PKw1ngqCTeED77tnWcIIMDAgMBAAGjggMeMIIDGjCBmQYIKwYBBQUHAQEE" +
            		"gYwwgYkwSAYIKwYBBQUHMAKGPGh0dHA6Ly93d3cuY2VydGlmaWNhZG9kaWdpdGFsLmNvbS5ici9j" +
            		"YWRlaWFzL3NlcmFzYXJmYnYyLnA3YjA9BggrBgEFBQcwAYYxaHR0cDovL29jc3AuY2VydGlmaWNh" +
            		"ZG9kaWdpdGFsLmNvbS5ici9zZXJhc2FyZmJ2MjAJBgNVHRMEAjAAMB8GA1UdIwQYMBaAFLKgxD1G" +
            		"nnzIhWwIHhAylGVGcEFzMHEGA1UdIARqMGgwZgYGYEwBAgENMFwwWgYIKwYBBQUHAgEWTmh0dHA6" +
            		"Ly9wdWJsaWNhY2FvLmNlcnRpZmljYWRvZGlnaXRhbC5jb20uYnIvcmVwb3NpdG9yaW8vZHBjL2Rl" +
            		"Y2xhcmFjYW8tcmZiLnBkZjCB8wYDVR0fBIHrMIHoMEqgSKBGhkRodHRwOi8vd3d3LmNlcnRpZmlj" +
            		"YWRvZGlnaXRhbC5jb20uYnIvcmVwb3NpdG9yaW8vbGNyL3NlcmFzYXJmYnYyLmNybDBEoEKgQIY+" +
            		"aHR0cDovL2xjci5jZXJ0aWZpY2Fkb3MuY29tLmJyL3JlcG9zaXRvcmlvL2xjci9zZXJhc2FyZmJ2" +
            		"Mi5jcmwwVKBSoFCGTmh0dHA6Ly9yZXBvc2l0b3Jpby5pY3BicmFzaWwuZ292LmJyL2xjci9TZXJh" +
            		"c2EvcmVwb3NpdG9yaW8vbGNyL3NlcmFzYXJmYnYyLmNybDAOBgNVHQ8BAf8EBAMCBeAwHQYDVR0l" +
            		"BBYwFAYIKwYBBQUHAwIGCCsGAQUFBwMEMIG3BgNVHREEga8wgayBGEZBQklPQFNOQVBTWVNURU1T" +
            		"LkNPTS5CUqAdBgVgTAEDAqAUExJGQUJJTyBVQ0hPQSBaQVJWT1OgGQYFYEwBAwOgEBMOMDczNDMw" +
            		"MTQwMDAxNTegPQYFYEwBAwSgNBMyMTgwMzE5NjgxNDgxMTc1MTgxNzAwMDAwMDAwMDAwMDAwMDAw" +
            		"MTIxNjQ0Nzg5U1NQU1CgFwYFYEwBAwegDhMMMDAwMDAwMDAwMDAwMA0GCSqGSIb3DQEBCwUAA4IC" +
            		"AQAi+VifT8JKFpBqgXdmHcoP18hgcP/ROCjMGXUN/daoo1CiTnBAUDW2JLG1qulih+eCXQhTRcb6" +
            		"+cYyhnEwdd1s2hKEA31HM+Vl4XAO+DFYSylrdEQK6S525LjZOvcMWnUVHpkO4Vz7MyHje5rrIcIy" +
            		"JUiKxVpvr4bmIhjZkYEc9Amf321OXKnoFVI8tQjBBeFd2ePCjlxFpP8M92uyyVm89ae0vilMopq6" +
            		"q5JBvdnURw3O+cRL1ZgObAo2PC+nZuXzBPIVziAhxIm/UJHJoF0hf3sJV+3b7x24r/9bo1ZZulRk" +
            		"7bCxv949C+7rZj9hQgl5nmfrAxzypkBgLsoQLTBFkEPVDFcx2WScShfA6xDsCAiD8wBRaa0Ih0wj" +
            		"0YWmpv3rkZlw3u7dFE8SioJinDto31+R0gH+a9xRM5AqkZA9IcYEoIGPWyqIwUCZYPu8QVDt/m2L" +
            		"2nVlfss+Vb22/cI0E4ebrDe3b2rs52GLeft7Df88Jyee6escHQkYJxe5xZ4Ii2nniyh02QelqzBI" +
            		"cxqgASWi45uCZGg1livTbZ6mIEnxP3SCC+/thQwPpMNl4D6jLC/rw/kbvWyLt02M8rYPK66k2p0W" +
            		"eF/8vkHTjQj/wx5+u6oe3TwSDn5ywglaeN+/NQIPAG/TifcEhhcdn3YGMOT9TZ6ZoE+AvPnku9lM" +
            		"Bg==</X509Certificate></X509Data></KeyInfo></Signature></NFe></enviNFe>";*/
            /*
            String xmlEnvNFe = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><idLote>419</idLote><NFe><infNFe Id=\"NFe35141007343014000157550000000009971000000019\" versao=\"2.00\"><ide><cUF>35</cUF><cNF>1</cNF><natOp>Venda de mercadoria</natOp><indPag>0</indPag><mod>55</mod><serie>000</serie><nNF>997</nNF><dEmi>2014-10-16</dEmi><dSaiEnt/><hSaiEnt/><tpNF>1</tpNF><cMunFG>3550308</cMunFG><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>9</cDV><tpAmb>2</tpAmb><finNFe>1</finNFe><procEmi>3</procEmi><verProc>1.0</verProc></ide><emit><CNPJ>07343014000157</CNPJ><xNome>SnapSystems Projeto de Software Ltda.</xNome><xFant>SnapSystems</xFant><enderEmit><xLgr>Avenida Brigadeiro Faria Lima</xLgr><nro>2.594</nro><xCpl>Cj.52</xCpl><xBairro>Itaim Bibi</xBairro><cMun>3550308</cMun><xMun>Sao Paulo</xMun><UF>SP</UF><CEP>01451-000</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone/></enderEmit><IE>34007920</IE><CRT>1</CRT></emit><dest><CPF>35090133875</CPF><xNome>Diogo Munhos Idalgo Netto</xNome><enderDest><xLgr>Rua Paula Ney</xLgr><nro/><xCpl/><xBairro>Vila Mariana</xBairro><cMun>3550308</cMun><xMun>Sao Paulo</xMun><UF>SP</UF><CEP>04107021</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone/></enderDest><IE/><email>diogomunhos@gmail.com</email></dest><det nItem=\"1\"><prod><cProd>02658</cProd><cEAN/><xProd/><NCM/><CFOP/><uCom/><qCom>10.0000</qCom><vUnCom>10.0000</vUnCom><vProd>10.0000</vProd><cEANTrib/><uTrib/><qTrib>1.0000</qTrib><vUnTrib>10.0000</vUnTrib><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.0</vDesc><vOutro>0.0</vOutro><indTot/></prod><imposto><COFINS><COFINSNT><CST>04</CST></COFINSNT></COFINS><ICMS><ICMSSN102><orig>0</orig><CSOSN>102</CSOSN></ICMSSN102></ICMS><PIS><PISNT><CST>04</CST></PISNT></PIS></imposto></det><total><ICMSTot><vBC>100.00</vBC><vICMS>0.00</vICMS><vBCST>100.00</vBCST><vST>0.00</vST><vProd>100.00</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>100.00</vNF></ICMSTot><ISSQNtot><vServ>0.00</vServ><vBC>0.00</vBC><vISS>0.00</vISS><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS></ISSQNtot><retTrib><vRetPIS>0.00</vRetPIS><vRetCOFINS>0.00</vRetCOFINS><vRetCSLL>0.00</vRetCSLL><vBCIRRF>0.00</vBCIRRF><vIRRF>0.00</vIRRF><vBCRetPrev>0.00</vBCRetPrev><vRetPrev>0.00</vRetPrev></retTrib></total><transp><modFrete>1</modFrete></transp></infNFe><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>8D4jhgZ6ONL/AGtIoFYlxG5bBEM=</DigestValue></Reference></SignedInfo><SignatureValue>hHzr4t1yqaFt6g6VJGA6BX3MCL+q2UW/wzS71UdACIHFrIQlaLK5CgxZmrQDPe9xxDeJ9Wd1p5K2" + 
								"5xALjU2bMkMregPxSYAEbRUQXFDLeRfkPjWb/zdxJEtYynIsW8anu5sgICd9cGs+Uem4qkgUYcVz" +
								"RrMZaRHrFg53fWX6+H6Ods33PabpYUR3LInc3MkRJZEm/v4bwkmB1MxKA9XlIqcIwgtmbAGYHxJ2" +
								"r5G7cx++2eLx7UzMWh/3N61QS7UgN5hEryoQLbzujeAK55hDldBhbU6XHlWJPYkqtDjuJnW1GZWq" +
								"KBgQ2aA0RYaPbmadVOFY447dUsNnze9jdF1yyg==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIIIATCCBemgAwIBAgIIC27X/OkKvBMwDQYJKoZIhvcNAQELBQAwdTELMAkGA1UEBhMCQlIxEzAR" +
								"BgNVBAoTCklDUC1CcmFzaWwxNjA0BgNVBAsTLVNlY3JldGFyaWEgZGEgUmVjZWl0YSBGZWRlcmFs" +
								"IGRvIEJyYXNpbCAtIFJGQjEZMBcGA1UEAxMQQUMgU0VSQVNBIFJGQiB2MjAeFw0xNDA1MjcxNDA4" +
								"MDBaFw0xNTA1MjcxNDA4MDBaMIHpMQswCQYDVQQGEwJCUjELMAkGA1UECBMCU1AxEjAQBgNVBAcT" +
								"CVNBTyBQQVVMTzETMBEGA1UEChMKSUNQLUJyYXNpbDE2MDQGA1UECxMtU2VjcmV0YXJpYSBkYSBS" +
								"ZWNlaXRhIEZlZGVyYWwgZG8gQnJhc2lsIC0gUkZCMRYwFAYDVQQLEw1SRkIgZS1DTlBKIEExMRIw" +
								"EAYDVQQLEwlBUiBTRVJBU0ExQDA+BgNVBAMTN1NOQVBTWVNURU1TIFBST0pFVE8gREUgU09GVFdB" +
								"UkUgTFREQSBFUFA6MDczNDMwMTQwMDAxNTcwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIB" +
								"AQCjOGPiOh6I/ql0KMhxhWf9BxsB6LdiyqrtSMChuBpRtx+Q1wfXTsuTw4tgYkymeDQSLMAxNzr6" +
								"FGTauDXS+Srgv33r0NOXNahQPHGvCI9bpZINWsrrHxFnNA97yrUZlPhU0xtR3ReFd1ehJg+aGKIF" +
								"nz116YzhsZpvwNnL9jR/I1wDX9n9VvaSo5VVAKm7ZAkvGDx1GJllIupN6KReqPVKj3EhoOFh9vXn" +
								"3ykayCLxJ5I72CSOfcwO7VhsnnxdkLtPuBZxbbY5JrYJ++o6TBH3RsY19XtO6Jx2E9rUqFY5FgIb" +
								"sUKvKx2uIVidMgMtR5PKw1ngqCTeED77tnWcIIMDAgMBAAGjggMeMIIDGjCBmQYIKwYBBQUHAQEE" +
								"gYwwgYkwSAYIKwYBBQUHMAKGPGh0dHA6Ly93d3cuY2VydGlmaWNhZG9kaWdpdGFsLmNvbS5ici9j" +
								"YWRlaWFzL3NlcmFzYXJmYnYyLnA3YjA9BggrBgEFBQcwAYYxaHR0cDovL29jc3AuY2VydGlmaWNh" +
								"ZG9kaWdpdGFsLmNvbS5ici9zZXJhc2FyZmJ2MjAJBgNVHRMEAjAAMB8GA1UdIwQYMBaAFLKgxD1G" +
								"nnzIhWwIHhAylGVGcEFzMHEGA1UdIARqMGgwZgYGYEwBAgENMFwwWgYIKwYBBQUHAgEWTmh0dHA6" +
								"Ly9wdWJsaWNhY2FvLmNlcnRpZmljYWRvZGlnaXRhbC5jb20uYnIvcmVwb3NpdG9yaW8vZHBjL2Rl" +
								"Y2xhcmFjYW8tcmZiLnBkZjCB8wYDVR0fBIHrMIHoMEqgSKBGhkRodHRwOi8vd3d3LmNlcnRpZmlj" +
								"YWRvZGlnaXRhbC5jb20uYnIvcmVwb3NpdG9yaW8vbGNyL3NlcmFzYXJmYnYyLmNybDBEoEKgQIY+" +
								"aHR0cDovL2xjci5jZXJ0aWZpY2Fkb3MuY29tLmJyL3JlcG9zaXRvcmlvL2xjci9zZXJhc2FyZmJ2" +
								"Mi5jcmwwVKBSoFCGTmh0dHA6Ly9yZXBvc2l0b3Jpby5pY3BicmFzaWwuZ292LmJyL2xjci9TZXJh" +
								"c2EvcmVwb3NpdG9yaW8vbGNyL3NlcmFzYXJmYnYyLmNybDAOBgNVHQ8BAf8EBAMCBeAwHQYDVR0l" +
								"BBYwFAYIKwYBBQUHAwIGCCsGAQUFBwMEMIG3BgNVHREEga8wgayBGEZBQklPQFNOQVBTWVNURU1T" +
								"LkNPTS5CUqAdBgVgTAEDAqAUExJGQUJJTyBVQ0hPQSBaQVJWT1OgGQYFYEwBAwOgEBMOMDczNDMw" +
								"MTQwMDAxNTegPQYFYEwBAwSgNBMyMTgwMzE5NjgxNDgxMTc1MTgxNzAwMDAwMDAwMDAwMDAwMDAw" +
								"MTIxNjQ0Nzg5U1NQU1CgFwYFYEwBAwegDhMMMDAwMDAwMDAwMDAwMA0GCSqGSIb3DQEBCwUAA4IC" +
								"AQAi+VifT8JKFpBqgXdmHcoP18hgcP/ROCjMGXUN/daoo1CiTnBAUDW2JLG1qulih+eCXQhTRcb6" +
								"+cYyhnEwdd1s2hKEA31HM+Vl4XAO+DFYSylrdEQK6S525LjZOvcMWnUVHpkO4Vz7MyHje5rrIcIy" +
								"JUiKxVpvr4bmIhjZkYEc9Amf321OXKnoFVI8tQjBBeFd2ePCjlxFpP8M92uyyVm89ae0vilMopq6" +
								"q5JBvdnURw3O+cRL1ZgObAo2PC+nZuXzBPIVziAhxIm/UJHJoF0hf3sJV+3b7x24r/9bo1ZZulRk" +
								"7bCxv949C+7rZj9hQgl5nmfrAxzypkBgLsoQLTBFkEPVDFcx2WScShfA6xDsCAiD8wBRaa0Ih0wj" +
								"0YWmpv3rkZlw3u7dFE8SioJinDto31+R0gH+a9xRM5AqkZA9IcYEoIGPWyqIwUCZYPu8QVDt/m2L" +
								"2nVlfss+Vb22/cI0E4ebrDe3b2rs52GLeft7Df88Jyee6escHQkYJxe5xZ4Ii2nniyh02QelqzBI" +
								"cxqgASWi45uCZGg1livTbZ6mIEnxP3SCC+/thQwPpMNl4D6jLC/rw/kbvWyLt02M8rYPK66k2p0W" +
								"eF/8vkHTjQj/wx5+u6oe3TwSDn5ywglaeN+/NQIPAG/TifcEhhcdn3YGMOT9TZ6ZoE+AvPnku9lM" +
								"Bg==</X509Certificate></X509Data></KeyInfo></Signature></NFe></enviNFe>";
								
			String xmlEnvNFe = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><idLote>419</idLote><NFe><infNFe Id=\"NFe35140205533480000170550010000000021080090204\" versao=\"2.00\"><ide><cUF>35</cUF><cNF>08009020</cNF><natOp>Venda de producao</natOp><indPag>1</indPag><mod>55</mod><serie>1</serie><nNF>2</nNF><dEmi>2014-02-27</dEmi><tpNF>1</tpNF><cMunFG>3544608</cMunFG><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>4</cDV><tpAmb>2</tpAmb><finNFe>1</finNFe><procEmi>3</procEmi><verProc>2.2.21</verProc></ide><emit><CNPJ>07343014000157</CNPJ><xNome>SnapSystems Projeto de Software Ltda.</xNome><xFant>SnapSystems</xFant><enderEmit><xLgr>Avenida Brigadeiro Faria Lima</xLgr><nro>2594</nro><xBairro>Itaim Bibi</xBairro><cMun>3550308</cMun><xMun>Sao Paulo</xMun><UF>SP</UF><CEP>01451000</CEP><cPais>1058</cPais><xPais>BRASIL</xPais><fone>1130811106</fone></enderEmit><IE>594053428117</IE><CRT>1</CRT></emit><dest><CNPJ>05098402000194</CNPJ><xNome>N B Noroeste Borracha Industria e Comércio Ltda</xNome><enderDest><xLgr>Rod. Roberto Mario Perosa - SP 379</xLgr><nro>Km 21</nro><xBairro>Bacurizinho</xBairro><cMun>3556008</cMun><xMun>Urupes</xMun><UF>SP</UF><CEP>15850000</CEP><cPais>1058</cPais><xPais>BRASIL</xPais><fone>1735222222</fone></enderDest><IE>707062434114</IE><email>agnaldo@noroesteborracha.com.br</email></dest><det nItem=\"1\"><prod><cProd>100</cProd><cEAN/><xProd>Coagulo de borracha natural</xProd><NCM>40011000</NCM><CFOP>5102</CFOP><uCom>kg</uCom><qCom>684.0000</qCom><vUnCom>3.2300000000</vUnCom><vProd>2209.32</vProd><cEANTrib/><uTrib>kg</uTrib><qTrib>684.0000</qTrib><vUnTrib>3.2300000000</vUnTrib><indTot>1</indTot></prod><imposto><ICMS><ICMSSN102><orig>0</orig><CSOSN>400</CSOSN></ICMSSN102></ICMS><IPI><cEnq>99</cEnq><IPITrib><CST>99</CST><qUnid>0.0000</qUnid><vUnid>0.0000</vUnid><vIPI>0.00</vIPI></IPITrib></IPI><PIS><PISOutr><CST>99</CST><qBCProd>0.0000</qBCProd><vAliqProd>0.0000</vAliqProd><vPIS>0.00</vPIS></PISOutr></PIS><COFINS><COFINSOutr><CST>99</CST><qBCProd>0.0000</qBCProd><vAliqProd>0.0000</vAliqProd><vCOFINS>0.00</vCOFINS></COFINSOutr></COFINS></imposto></det><total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vBCST>0.00</vBCST><vST>0.00</vST><vProd>2209.32</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>2209.32</vNF></ICMSTot></total><transp><modFrete>1</modFrete></transp><cobr><fat><nFat>1</nFat><vOrig>2209.32</vOrig><vLiq>2209.32</vLiq></fat><dup><nDup>1</nDup><dVenc>2014-03-15</dVenc><vDup>2209.32</vDup></dup></cobr><infAdic><infAdFisco>ICMS-DIFERIMENTO CONF. ART.350 INCISO XI DO RICMS/SP/2000 (BORRACHA)</infAdFisco></infAdic></infNFe><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#NFe35140205533480000170550010000000021080090204\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>aVmXuUi3OsrNCvIxdkTjONMm/tk=</DigestValue></Reference></SignedInfo><SignatureValue>RTEUAxHUmaKvovre9EGjjXH3K1jcfLeMIZmSnPDzBJxjBghW8L1yEl7C+1DIyIU9RdoLe8pA2qmc" +
								"gtww9ddI91WM7p/36gqXSmnLNJ5WJ8+ETeciZJecqlr175t+ScaAUW9ZOtONQVOEltSJz8h4SULu" +
								"7273o9LScvkwsQJRxguqoXyJzSLUXIWhUviPXJUKDcaJbG0LZDY8sIADJbhtJsiQq84CrrOeAEjt" +
								"S/YgfnL2QZDwRkrSpCeMveJVS+ZV5572Z3ozuOmrnZnGrV0RZt1PFma7MREhYxhGHjwC2vi286HN" +
								"RCJSlP5Mz7UMEoTC7Q44EUKWQoIZJQAcTlUsqw==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIIIATCCBemgAwIBAgIIC27X/OkKvBMwDQYJKoZIhvcNAQELBQAwdTELMAkGA1UEBhMCQlIxEzAR" +
								"BgNVBAoTCklDUC1CcmFzaWwxNjA0BgNVBAsTLVNlY3JldGFyaWEgZGEgUmVjZWl0YSBGZWRlcmFs" +
								"IGRvIEJyYXNpbCAtIFJGQjEZMBcGA1UEAxMQQUMgU0VSQVNBIFJGQiB2MjAeFw0xNDA1MjcxNDA4" +
								"MDBaFw0xNTA1MjcxNDA4MDBaMIHpMQswCQYDVQQGEwJCUjELMAkGA1UECBMCU1AxEjAQBgNVBAcT" +
								"CVNBTyBQQVVMTzETMBEGA1UEChMKSUNQLUJyYXNpbDE2MDQGA1UECxMtU2VjcmV0YXJpYSBkYSBS" +
								"ZWNlaXRhIEZlZGVyYWwgZG8gQnJhc2lsIC0gUkZCMRYwFAYDVQQLEw1SRkIgZS1DTlBKIEExMRIw" +
								"EAYDVQQLEwlBUiBTRVJBU0ExQDA+BgNVBAMTN1NOQVBTWVNURU1TIFBST0pFVE8gREUgU09GVFdB" +
								"UkUgTFREQSBFUFA6MDczNDMwMTQwMDAxNTcwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIB" +
								"AQCjOGPiOh6I/ql0KMhxhWf9BxsB6LdiyqrtSMChuBpRtx+Q1wfXTsuTw4tgYkymeDQSLMAxNzr6" +
								"FGTauDXS+Srgv33r0NOXNahQPHGvCI9bpZINWsrrHxFnNA97yrUZlPhU0xtR3ReFd1ehJg+aGKIF" +
								"nz116YzhsZpvwNnL9jR/I1wDX9n9VvaSo5VVAKm7ZAkvGDx1GJllIupN6KReqPVKj3EhoOFh9vXn" +
								"3ykayCLxJ5I72CSOfcwO7VhsnnxdkLtPuBZxbbY5JrYJ++o6TBH3RsY19XtO6Jx2E9rUqFY5FgIb" +
								"sUKvKx2uIVidMgMtR5PKw1ngqCTeED77tnWcIIMDAgMBAAGjggMeMIIDGjCBmQYIKwYBBQUHAQEE" +
								"gYwwgYkwSAYIKwYBBQUHMAKGPGh0dHA6Ly93d3cuY2VydGlmaWNhZG9kaWdpdGFsLmNvbS5ici9j" +
								"YWRlaWFzL3NlcmFzYXJmYnYyLnA3YjA9BggrBgEFBQcwAYYxaHR0cDovL29jc3AuY2VydGlmaWNh" +
								"ZG9kaWdpdGFsLmNvbS5ici9zZXJhc2FyZmJ2MjAJBgNVHRMEAjAAMB8GA1UdIwQYMBaAFLKgxD1G" +
								"nnzIhWwIHhAylGVGcEFzMHEGA1UdIARqMGgwZgYGYEwBAgENMFwwWgYIKwYBBQUHAgEWTmh0dHA6" +
								"Ly9wdWJsaWNhY2FvLmNlcnRpZmljYWRvZGlnaXRhbC5jb20uYnIvcmVwb3NpdG9yaW8vZHBjL2Rl" +
								"Y2xhcmFjYW8tcmZiLnBkZjCB8wYDVR0fBIHrMIHoMEqgSKBGhkRodHRwOi8vd3d3LmNlcnRpZmlj" +
								"YWRvZGlnaXRhbC5jb20uYnIvcmVwb3NpdG9yaW8vbGNyL3NlcmFzYXJmYnYyLmNybDBEoEKgQIY+" +
								"aHR0cDovL2xjci5jZXJ0aWZpY2Fkb3MuY29tLmJyL3JlcG9zaXRvcmlvL2xjci9zZXJhc2FyZmJ2" +
								"Mi5jcmwwVKBSoFCGTmh0dHA6Ly9yZXBvc2l0b3Jpby5pY3BicmFzaWwuZ292LmJyL2xjci9TZXJh" +
								"c2EvcmVwb3NpdG9yaW8vbGNyL3NlcmFzYXJmYnYyLmNybDAOBgNVHQ8BAf8EBAMCBeAwHQYDVR0l" +
								"BBYwFAYIKwYBBQUHAwIGCCsGAQUFBwMEMIG3BgNVHREEga8wgayBGEZBQklPQFNOQVBTWVNURU1T" +
								"LkNPTS5CUqAdBgVgTAEDAqAUExJGQUJJTyBVQ0hPQSBaQVJWT1OgGQYFYEwBAwOgEBMOMDczNDMw" +
								"MTQwMDAxNTegPQYFYEwBAwSgNBMyMTgwMzE5NjgxNDgxMTc1MTgxNzAwMDAwMDAwMDAwMDAwMDAw" +
								"MTIxNjQ0Nzg5U1NQU1CgFwYFYEwBAwegDhMMMDAwMDAwMDAwMDAwMA0GCSqGSIb3DQEBCwUAA4IC" +
								"AQAi+VifT8JKFpBqgXdmHcoP18hgcP/ROCjMGXUN/daoo1CiTnBAUDW2JLG1qulih+eCXQhTRcb6" +
								"+cYyhnEwdd1s2hKEA31HM+Vl4XAO+DFYSylrdEQK6S525LjZOvcMWnUVHpkO4Vz7MyHje5rrIcIy" +
								"JUiKxVpvr4bmIhjZkYEc9Amf321OXKnoFVI8tQjBBeFd2ePCjlxFpP8M92uyyVm89ae0vilMopq6" +
								"q5JBvdnURw3O+cRL1ZgObAo2PC+nZuXzBPIVziAhxIm/UJHJoF0hf3sJV+3b7x24r/9bo1ZZulRk" +
								"7bCxv949C+7rZj9hQgl5nmfrAxzypkBgLsoQLTBFkEPVDFcx2WScShfA6xDsCAiD8wBRaa0Ih0wj" +
								"0YWmpv3rkZlw3u7dFE8SioJinDto31+R0gH+a9xRM5AqkZA9IcYEoIGPWyqIwUCZYPu8QVDt/m2L" +
								"2nVlfss+Vb22/cI0E4ebrDe3b2rs52GLeft7Df88Jyee6escHQkYJxe5xZ4Ii2nniyh02QelqzBI" +
								"cxqgASWi45uCZGg1livTbZ6mIEnxP3SCC+/thQwPpMNl4D6jLC/rw/kbvWyLt02M8rYPK66k2p0W" +
								"eF/8vkHTjQj/wx5+u6oe3TwSDn5ywglaeN+/NQIPAG/TifcEhhcdn3YGMOT9TZ6ZoE+AvPnku9lM" +
								"Bg==</X509Certificate></X509Data></KeyInfo></Signature></NFe></enviNFe>";* / 
								
			String xmlEnvNFe = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><enviNFe xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"><idLote>420</idLote><NFe><infNFe Id=\"NFe35141007343014000157550010000021941911220364\" versao=\"2.00\"><ide><cUF>35</cUF><cNF>91122036</cNF><natOp>Venda de producao</natOp><indPag>0</indPag><mod>55</mod><serie>1</serie><nNF>2194</nNF><dEmi>2014-10-21</dEmi><tpNF>1</tpNF><cMunFG>3550308</cMunFG><tpImp>1</tpImp><tpEmis>1</tpEmis><cDV>4</cDV><tpAmb>2</tpAmb><finNFe>1</finNFe><procEmi>3</procEmi><verProc>2.0</verProc></ide><emit><CNPJ>07343014000157</CNPJ><xNome>SnapSystems Projeto de Software Ltda.</xNome><xFant>SnapSystems</xFant><enderEmit><xLgr>Avenida Brigadeiro Faria Lima</xLgr><nro>2594</nro><xBairro>Itaim Bibi</xBairro><cMun>3550308</cMun><xMun>Sao Paulo</xMun><UF>SP</UF><CEP>01451000</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone>1735222222</fone></enderEmit><IE>34007920</IE><CRT>1</CRT></emit><dest><CPF>35090133875</CPF><xNome>Diogo Munhos Idalgo Netto</xNome><enderDest><xLgr>Rua Paula Ney</xLgr><nro>300</nro><xBairro>Vila Mariana</xBairro><cMun>3550308</cMun><xMun>Sao Paulo</xMun><UF>SP</UF><CEP>04107021</CEP><cPais>1058</cPais><xPais>Brasil</xPais><fone>1735222222</fone></enderDest><IE>ISENTO</IE><email>diogomunhos@gmail.com</email></dest><det nItem=\"1\"><prod><cProd>100</cProd><cEAN/><xProd>Coagulo de borracha natural</xProd><NCM>40011000</NCM><CFOP>5102</CFOP><uCom>kg</uCom><qCom>10.0000</qCom><vUnCom>3.2300000000</vUnCom><vProd>32.30</vProd><cEANTrib/><uTrib>kg</uTrib><qTrib>10.0000</qTrib><vUnTrib>3.2300000000</vUnTrib><indTot>1</indTot></prod><imposto><ICMS><ICMSSN102><orig>0</orig><CSOSN>400</CSOSN></ICMSSN102></ICMS><IPI><cEnq>99</cEnq><IPITrib><CST>99</CST><qUnid>0.0000</qUnid><vUnid>0.0000</vUnid><vIPI>0.00</vIPI></IPITrib></IPI><PIS><PISOutr><CST>99</CST><qBCProd>0.0000</qBCProd><vAliqProd>0.0000</vAliqProd><vPIS>0.00</vPIS></PISOutr></PIS><COFINS><COFINSOutr><CST>99</CST><qBCProd>0.0000</qBCProd><vAliqProd>0.0000</vAliqProd><vCOFINS>0.00</vCOFINS></COFINSOutr></COFINS></imposto></det><total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vBCST>0.00</vBCST><vST>0.00</vST><vProd>32.30</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>32.30</vNF></ICMSTot></total><transp><modFrete>1</modFrete></transp></infNFe><Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#NFe35141007343014000157550010000021941911220364\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/><Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>6VlV3Y8HO9pabp/CHlIxXsq2J5k=</DigestValue></Reference></SignedInfo><SignatureValue>NE33GDviA189qFopQH4cqKookKtnWdns3ENPwYUBz42+TkfVMipyuHXIwtSQgUKWgEb/GCVqmQ/J" + 
								"64tvvn4goHgDlYPfZjFHUUNBgYZYoWrwkhq07GkL6snm0IVh5sT2g4wUvbLlKyX+Uno5w+TMAsr9" +
								"+g3lRRfD+HL9Z4K0NeRymc08P8mZ2bSQ6z6UYDDiguq2FszNW25VJ8z3V29fxrWRbXzJjOfLrfB8" +
								"qvp3s5YJplgUtTclSnmmMJxk0BGLpNLPmDv9dd3vR60qS5lPZPTAxzHaBqThxL6kRSXdSssfhFXj" +
								"K3L/QulXCvfJpV208ObwOb0/f6X+muX+7AuIFQ==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIIIATCCBemgAwIBAgIIC27X/OkKvBMwDQYJKoZIhvcNAQELBQAwdTELMAkGA1UEBhMCQlIxEzAR" +
								"BgNVBAoTCklDUC1CcmFzaWwxNjA0BgNVBAsTLVNlY3JldGFyaWEgZGEgUmVjZWl0YSBGZWRlcmFs" +
								"IGRvIEJyYXNpbCAtIFJGQjEZMBcGA1UEAxMQQUMgU0VSQVNBIFJGQiB2MjAeFw0xNDA1MjcxNDA4" +
								"MDBaFw0xNTA1MjcxNDA4MDBaMIHpMQswCQYDVQQGEwJCUjELMAkGA1UECBMCU1AxEjAQBgNVBAcT" +
								"CVNBTyBQQVVMTzETMBEGA1UEChMKSUNQLUJyYXNpbDE2MDQGA1UECxMtU2VjcmV0YXJpYSBkYSBS" +
								"ZWNlaXRhIEZlZGVyYWwgZG8gQnJhc2lsIC0gUkZCMRYwFAYDVQQLEw1SRkIgZS1DTlBKIEExMRIw" +
								"EAYDVQQLEwlBUiBTRVJBU0ExQDA+BgNVBAMTN1NOQVBTWVNURU1TIFBST0pFVE8gREUgU09GVFdB" +
								"UkUgTFREQSBFUFA6MDczNDMwMTQwMDAxNTcwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIB" +
								"AQCjOGPiOh6I/ql0KMhxhWf9BxsB6LdiyqrtSMChuBpRtx+Q1wfXTsuTw4tgYkymeDQSLMAxNzr6" +
								"FGTauDXS+Srgv33r0NOXNahQPHGvCI9bpZINWsrrHxFnNA97yrUZlPhU0xtR3ReFd1ehJg+aGKIF" +
								"nz116YzhsZpvwNnL9jR/I1wDX9n9VvaSo5VVAKm7ZAkvGDx1GJllIupN6KReqPVKj3EhoOFh9vXn" +
								"3ykayCLxJ5I72CSOfcwO7VhsnnxdkLtPuBZxbbY5JrYJ++o6TBH3RsY19XtO6Jx2E9rUqFY5FgIb" +
								"sUKvKx2uIVidMgMtR5PKw1ngqCTeED77tnWcIIMDAgMBAAGjggMeMIIDGjCBmQYIKwYBBQUHAQEE" +
								"gYwwgYkwSAYIKwYBBQUHMAKGPGh0dHA6Ly93d3cuY2VydGlmaWNhZG9kaWdpdGFsLmNvbS5ici9j" +
								"YWRlaWFzL3NlcmFzYXJmYnYyLnA3YjA9BggrBgEFBQcwAYYxaHR0cDovL29jc3AuY2VydGlmaWNh" +
								"ZG9kaWdpdGFsLmNvbS5ici9zZXJhc2FyZmJ2MjAJBgNVHRMEAjAAMB8GA1UdIwQYMBaAFLKgxD1G" +
								"nnzIhWwIHhAylGVGcEFzMHEGA1UdIARqMGgwZgYGYEwBAgENMFwwWgYIKwYBBQUHAgEWTmh0dHA6" +
								"Ly9wdWJsaWNhY2FvLmNlcnRpZmljYWRvZGlnaXRhbC5jb20uYnIvcmVwb3NpdG9yaW8vZHBjL2Rl" +
								"Y2xhcmFjYW8tcmZiLnBkZjCB8wYDVR0fBIHrMIHoMEqgSKBGhkRodHRwOi8vd3d3LmNlcnRpZmlj" +
								"YWRvZGlnaXRhbC5jb20uYnIvcmVwb3NpdG9yaW8vbGNyL3NlcmFzYXJmYnYyLmNybDBEoEKgQIY+" +
								"aHR0cDovL2xjci5jZXJ0aWZpY2Fkb3MuY29tLmJyL3JlcG9zaXRvcmlvL2xjci9zZXJhc2FyZmJ2" +
								"Mi5jcmwwVKBSoFCGTmh0dHA6Ly9yZXBvc2l0b3Jpby5pY3BicmFzaWwuZ292LmJyL2xjci9TZXJh" +
								"c2EvcmVwb3NpdG9yaW8vbGNyL3NlcmFzYXJmYnYyLmNybDAOBgNVHQ8BAf8EBAMCBeAwHQYDVR0l" +
								"BBYwFAYIKwYBBQUHAwIGCCsGAQUFBwMEMIG3BgNVHREEga8wgayBGEZBQklPQFNOQVBTWVNURU1T" +
								"LkNPTS5CUqAdBgVgTAEDAqAUExJGQUJJTyBVQ0hPQSBaQVJWT1OgGQYFYEwBAwOgEBMOMDczNDMw" +
								"MTQwMDAxNTegPQYFYEwBAwSgNBMyMTgwMzE5NjgxNDgxMTc1MTgxNzAwMDAwMDAwMDAwMDAwMDAw" +
								"MTIxNjQ0Nzg5U1NQU1CgFwYFYEwBAwegDhMMMDAwMDAwMDAwMDAwMA0GCSqGSIb3DQEBCwUAA4IC" +
								"AQAi+VifT8JKFpBqgXdmHcoP18hgcP/ROCjMGXUN/daoo1CiTnBAUDW2JLG1qulih+eCXQhTRcb6" +
								"+cYyhnEwdd1s2hKEA31HM+Vl4XAO+DFYSylrdEQK6S525LjZOvcMWnUVHpkO4Vz7MyHje5rrIcIy" +
								"JUiKxVpvr4bmIhjZkYEc9Amf321OXKnoFVI8tQjBBeFd2ePCjlxFpP8M92uyyVm89ae0vilMopq6" +
								"q5JBvdnURw3O+cRL1ZgObAo2PC+nZuXzBPIVziAhxIm/UJHJoF0hf3sJV+3b7x24r/9bo1ZZulRk" +
								"7bCxv949C+7rZj9hQgl5nmfrAxzypkBgLsoQLTBFkEPVDFcx2WScShfA6xDsCAiD8wBRaa0Ih0wj" +
								"0YWmpv3rkZlw3u7dFE8SioJinDto31+R0gH+a9xRM5AqkZA9IcYEoIGPWyqIwUCZYPu8QVDt/m2L" +
								"2nVlfss+Vb22/cI0E4ebrDe3b2rs52GLeft7Df88Jyee6escHQkYJxe5xZ4Ii2nniyh02QelqzBI" +
								"cxqgASWi45uCZGg1livTbZ6mIEnxP3SCC+/thQwPpMNl4D6jLC/rw/kbvWyLt02M8rYPK66k2p0W" +
								"eF/8vkHTjQj/wx5+u6oe3TwSDn5ywglaeN+/NQIPAG/TifcEhhcdn3YGMOT9TZ6ZoE+AvPnku9lM" +
								"Bg==</X509Certificate></X509Data></KeyInfo></Signature></NFe></enviNFe>";					
								
            OMElement ome = AXIOMUtil.stringToOM(xmlEnvNFe);  
  
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
             
             // Código do Estado. 
               
            nfeCabecMsg.setCUF(codigoDoEstado);  
  
             
             // Versao do XML 
               
            nfeCabecMsg.setVersaoDados("2.00");  
  
            NfeRecepcao2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeRecepcao2Stub.NfeCabecMsgE();  
            nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);  
  
            NfeRecepcao2Stub stub = new NfeRecepcao2Stub(url.toString());  
            NfeRecepcao2Stub.NfeRecepcaoLote2Result result = stub.nfeRecepcaoLote2(dadosMsg, nfeCabecMsgE);  
  
            System.out.println(result.getExtraElement().toString());
            
            /*
             * Retorno envio NFe
             * <retEnviNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>35</cUF><dhRecbto>2014-10-20T13:18:32</dhRecbto><infRec><nRec>351000084746410</nRec><tMed>1</tMed></infRec></retEnviNFe>
             * <retEnviNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>35</cUF><dhRecbto>2014-10-20T18:12:46</dhRecbto><infRec><nRec>351000084756115</nRec><tMed>1</tMed></infRec></retEnviNFe>
             * <retEnviNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>35</cUF><dhRecbto>2014-10-21T16:21:15</dhRecbto><infRec><nRec>351000084793444</nRec><tMed>1</tMed></infRec></retEnviNFe>
             * <retEnviNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>35</cUF><dhRecbto>2014-10-22T02:58:31</dhRecbto><infRec><nRec>351000084799001</nRec><tMed>2</tMed></infRec></retEnviNFe>
             * <retEnviNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>35</cUF><dhRecbto>2014-10-22T16:29:34</dhRecbto><infRec><nRec>351000084810433</nRec><tMed>1</tMed></infRec></retEnviNFe>
             * <retEnviNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>35</cUF><dhRecbto>2014-10-22T16:38:19</dhRecbto><infRec><nRec>351000084810841</nRec><tMed>1</tMed></infRec></retEnviNFe>
             * <retEnviNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>35</cUF><dhRecbto>2014-10-22T17:03:17</dhRecbto><infRec><nRec>351000084811643</nRec><tMed>1</tMed></infRec></retEnviNFe>
             * <retEnviNFe xmlns="http://www.portalfiscal.inf.br/nfe" versao="2.00"><tpAmb>2</tpAmb><verAplic>SP_NFE_PL_006q</verAplic><cStat>103</cStat><xMotivo>Lote recebido com sucesso</xMotivo><cUF>35</cUF><dhRecbto>2014-10-22T17:31:24</dhRecbto><infRec><nRec>351000084812733</nRec><tMed>1</tMed></infRec></retEnviNFe>
             */
            
			
			/*
			 * 
			 * Consulta de Status
			 * 
			System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
	        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	        // Keystore com o certificado do cliente
	        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
	        System.setProperty("javax.net.ssl.keyStore", "/Users/brunosoaresbarros/Documents/Desenvolvimento/ProjetoNFe/TestesCertificados/Certificado_A1_Snap_NF.pfx");
	        //System.setProperty("javax.net.ssl.keyStore", "C:\\ServiceAssinador\\certificados\\Certificado_A1_Snap_NF.pfx");
	        System.setProperty("javax.net.ssl.keyStorePassword", "snap2004");
	        System.setProperty("javax.net.ssl.trustStoreType", "JKS");  
	        System.setProperty("javax.net.ssl.trustStore", "/Users/brunosoaresbarros/Documents/Desenvolvimento/ProjetoNFe/TestesCertificados/NFeCacerts");//Aqui vem o arquivo criado através do comando keytool no passo 3  
	        //System.setProperty("javax.net.ssl.trustStore", "C:\\ServiceAssinador\\certificados\\NFeCacerts");//Aqui vem o arquivo criado através do comando keytool no passo 3
	        
			NfeStatusServico2Stub stub = new NfeStatusServico2Stub("https://nfe.fazenda.sp.gov.br/nfeweb/services/NfeStatusServico2.asmx");  
			NfeStatusServico2Stub.NfeDadosMsg dados = new NfeStatusServico2Stub.NfeDadosMsg();  
			  
			String s = "<consStatServ versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">"+  
			            "<tpAmb>1</tpAmb>"+  
			            "<cUF>35</cUF>"+  
			            "<xServ>STATUS</xServ>"+  
			            "</consStatServ>"; 
			
			Assinador assinador = new Assinador();
			
			PublicKey chavePublica = assinador.getPublicKeyFromPFX("/Users/brunosoaresbarros/Documents/Desenvolvimento/ProjetoNFe/TestesCertificados/Certificado_A1_Snap_NF.pfx", "snap2004".toCharArray());
    		PrivateKey chavePrivada = assinador.getPrivateKeyFromPFX("/Users/brunosoaresbarros/Documents/Desenvolvimento/ProjetoNFe/TestesCertificados/Certificado_A1_Snap_NF.pfx", "snap2004".toCharArray());
			
			String retorno = assinador.assinarDocumento("/Users/brunosoaresbarros/Documents/Desenvolvimento/ProjetoNFe/TestesCertificados/", s, chavePrivada, chavePublica);
			  
			OMElement el = AXIOMUtil.stringToOM(s);  
			dados.setExtraElement(el);  
			  
			NfeStatusServico2Stub.NfeCabecMsg cab = new NfeStatusServico2Stub.NfeCabecMsg();  
			cab.setVersaoDados("2.00");  
			cab.setCUF("35");  
			NfeStatusServico2Stub.NfeCabecMsgE cabE = new NfeStatusServico2Stub.NfeCabecMsgE();  
			cabE.setNfeCabecMsg(cab);  
			  
			System.out.println(stub.nfeStatusServicoNF2(dados , cabE).getExtraElement());
			*/	        
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
