/**
 * LoteNFeSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.gov.sp.prefeitura.www.nfe;

public interface LoteNFeSoap extends java.rmi.Remote {
    public br.gov.sp.prefeitura.www.nfe.EnvioRPSResponse envioRPS(br.gov.sp.prefeitura.www.nfe.EnvioRPSRequest parameters) throws java.rmi.RemoteException;
    public br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSResponse envioLoteRPS(br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSRequest parameters) throws java.rmi.RemoteException;
    public br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSResponse testeEnvioLoteRPS(br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSRequest parameters) throws java.rmi.RemoteException;
    public br.gov.sp.prefeitura.www.nfe.CancelamentoNFeResponse cancelamentoNFe(br.gov.sp.prefeitura.www.nfe.CancelamentoNFeRequest parameters) throws java.rmi.RemoteException;
    public br.gov.sp.prefeitura.www.nfe.ConsultaNFeResponse consultaNFe(br.gov.sp.prefeitura.www.nfe.ConsultaNFeRequest parameters) throws java.rmi.RemoteException;
    public br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasResponse consultaNFeRecebidas(br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasRequest parameters) throws java.rmi.RemoteException;
    public br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasResponse consultaNFeEmitidas(br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasRequest parameters) throws java.rmi.RemoteException;
    public br.gov.sp.prefeitura.www.nfe.ConsultaLoteResponse consultaLote(br.gov.sp.prefeitura.www.nfe.ConsultaLoteRequest parameters) throws java.rmi.RemoteException;
    public br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteResponse consultaInformacoesLote(br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteRequest parameters) throws java.rmi.RemoteException;
    public br.gov.sp.prefeitura.www.nfe.ConsultaCNPJResponse consultaCNPJ(br.gov.sp.prefeitura.www.nfe.ConsultaCNPJRequest parameters) throws java.rmi.RemoteException;
}
