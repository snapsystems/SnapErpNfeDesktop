package br.gov.sp.prefeitura.www.nfe;

public class LoteNFeSoapProxy implements br.gov.sp.prefeitura.www.nfe.LoteNFeSoap {
  private String _endpoint = null;
  private br.gov.sp.prefeitura.www.nfe.LoteNFeSoap loteNFeSoap = null;
  
  public LoteNFeSoapProxy() {
    _initLoteNFeSoapProxy();
  }
  
  public LoteNFeSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initLoteNFeSoapProxy();
  }
  
  private void _initLoteNFeSoapProxy() {
    try {
      loteNFeSoap = (new br.gov.sp.prefeitura.www.nfe.LoteNFeLocator()).getLoteNFeSoap();
      if (loteNFeSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)loteNFeSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)loteNFeSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (loteNFeSoap != null)
      ((javax.xml.rpc.Stub)loteNFeSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.gov.sp.prefeitura.www.nfe.LoteNFeSoap getLoteNFeSoap() {
    if (loteNFeSoap == null)
      _initLoteNFeSoapProxy();
    return loteNFeSoap;
  }
  
  public br.gov.sp.prefeitura.www.nfe.EnvioRPSResponse envioRPS(br.gov.sp.prefeitura.www.nfe.EnvioRPSRequest parameters) throws java.rmi.RemoteException{
    if (loteNFeSoap == null)
      _initLoteNFeSoapProxy();
    return loteNFeSoap.envioRPS(parameters);
  }
  
  public br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSResponse envioLoteRPS(br.gov.sp.prefeitura.www.nfe.EnvioLoteRPSRequest parameters) throws java.rmi.RemoteException{
    if (loteNFeSoap == null)
      _initLoteNFeSoapProxy();
    return loteNFeSoap.envioLoteRPS(parameters);
  }
  
  public br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSResponse testeEnvioLoteRPS(br.gov.sp.prefeitura.www.nfe.TesteEnvioLoteRPSRequest parameters) throws java.rmi.RemoteException{
    if (loteNFeSoap == null)
      _initLoteNFeSoapProxy();
    return loteNFeSoap.testeEnvioLoteRPS(parameters);
  }
  
  public br.gov.sp.prefeitura.www.nfe.CancelamentoNFeResponse cancelamentoNFe(br.gov.sp.prefeitura.www.nfe.CancelamentoNFeRequest parameters) throws java.rmi.RemoteException{
    if (loteNFeSoap == null)
      _initLoteNFeSoapProxy();
    return loteNFeSoap.cancelamentoNFe(parameters);
  }
  
  public br.gov.sp.prefeitura.www.nfe.ConsultaNFeResponse consultaNFe(br.gov.sp.prefeitura.www.nfe.ConsultaNFeRequest parameters) throws java.rmi.RemoteException{
    if (loteNFeSoap == null)
      _initLoteNFeSoapProxy();
    return loteNFeSoap.consultaNFe(parameters);
  }
  
  public br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasResponse consultaNFeRecebidas(br.gov.sp.prefeitura.www.nfe.ConsultaNFeRecebidasRequest parameters) throws java.rmi.RemoteException{
    if (loteNFeSoap == null)
      _initLoteNFeSoapProxy();
    return loteNFeSoap.consultaNFeRecebidas(parameters);
  }
  
  public br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasResponse consultaNFeEmitidas(br.gov.sp.prefeitura.www.nfe.ConsultaNFeEmitidasRequest parameters) throws java.rmi.RemoteException{
    if (loteNFeSoap == null)
      _initLoteNFeSoapProxy();
    return loteNFeSoap.consultaNFeEmitidas(parameters);
  }
  
  public br.gov.sp.prefeitura.www.nfe.ConsultaLoteResponse consultaLote(br.gov.sp.prefeitura.www.nfe.ConsultaLoteRequest parameters) throws java.rmi.RemoteException{
    if (loteNFeSoap == null)
      _initLoteNFeSoapProxy();
    return loteNFeSoap.consultaLote(parameters);
  }
  
  public br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteResponse consultaInformacoesLote(br.gov.sp.prefeitura.www.nfe.ConsultaInformacoesLoteRequest parameters) throws java.rmi.RemoteException{
    if (loteNFeSoap == null)
      _initLoteNFeSoapProxy();
    return loteNFeSoap.consultaInformacoesLote(parameters);
  }
  
  public br.gov.sp.prefeitura.www.nfe.ConsultaCNPJResponse consultaCNPJ(br.gov.sp.prefeitura.www.nfe.ConsultaCNPJRequest parameters) throws java.rmi.RemoteException{
    if (loteNFeSoap == null)
      _initLoteNFeSoapProxy();
    return loteNFeSoap.consultaCNPJ(parameters);
  }
  
  
}