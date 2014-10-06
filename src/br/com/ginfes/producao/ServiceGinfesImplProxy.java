package br.com.ginfes.producao;

public class ServiceGinfesImplProxy implements br.com.ginfes.producao.ServiceGinfesImpl {
  private String _endpoint = null;
  private br.com.ginfes.producao.ServiceGinfesImpl serviceGinfesImpl = null;
  
  public ServiceGinfesImplProxy() {
    _initServiceGinfesImplProxy();
  }
  
  public ServiceGinfesImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceGinfesImplProxy();
  }
  
  private void _initServiceGinfesImplProxy() {
    try {
      serviceGinfesImpl = (new br.com.ginfes.producao.ServiceGinfesImplServiceLocator()).getServiceGinfesImplPort();
      if (serviceGinfesImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceGinfesImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceGinfesImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceGinfesImpl != null)
      ((javax.xml.rpc.Stub)serviceGinfesImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.ginfes.producao.ServiceGinfesImpl getServiceGinfesImpl() {
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl;
  }
  
  public java.lang.String cancelarNfse(java.lang.String arg0) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.cancelarNfse(arg0);
  }
  
  public java.lang.String cancelarNfseV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.cancelarNfseV3(arg0, arg1);
  }
  
  public java.lang.String consultarLoteRps(java.lang.String arg0) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.consultarLoteRps(arg0);
  }
  
  public java.lang.String consultarLoteRpsV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.consultarLoteRpsV3(arg0, arg1);
  }
  
  public java.lang.String consultarNfse(java.lang.String arg0) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.consultarNfse(arg0);
  }
  
  public java.lang.String consultarNfsePorRps(java.lang.String arg0) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.consultarNfsePorRps(arg0);
  }
  
  public java.lang.String consultarNfsePorRpsV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.consultarNfsePorRpsV3(arg0, arg1);
  }
  
  public java.lang.String consultarNfseV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.consultarNfseV3(arg0, arg1);
  }
  
  public java.lang.String consultarSituacaoLoteRps(java.lang.String arg0) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.consultarSituacaoLoteRps(arg0);
  }
  
  public java.lang.String consultarSituacaoLoteRpsV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.consultarSituacaoLoteRpsV3(arg0, arg1);
  }
  
  public java.lang.String recepcionarLoteRps(java.lang.String arg0) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.recepcionarLoteRps(arg0);
  }
  
  public java.lang.String recepcionarLoteRpsV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (serviceGinfesImpl == null)
      _initServiceGinfesImplProxy();
    return serviceGinfesImpl.recepcionarLoteRpsV3(arg0, arg1);
  }
  
  
}