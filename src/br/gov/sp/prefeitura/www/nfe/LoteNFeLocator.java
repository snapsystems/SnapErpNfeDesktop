/**
 * LoteNFeLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.gov.sp.prefeitura.www.nfe;

public class LoteNFeLocator extends org.apache.axis.client.Service implements br.gov.sp.prefeitura.www.nfe.LoteNFe {

    public LoteNFeLocator() {
    }


    public LoteNFeLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LoteNFeLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LoteNFeSoap
    private java.lang.String LoteNFeSoap_address = "https://nfe.prefeitura.sp.gov.br/ws/lotenfe.asmx";

    public java.lang.String getLoteNFeSoapAddress() {
        return LoteNFeSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LoteNFeSoapWSDDServiceName = "LoteNFeSoap";

    public java.lang.String getLoteNFeSoapWSDDServiceName() {
        return LoteNFeSoapWSDDServiceName;
    }

    public void setLoteNFeSoapWSDDServiceName(java.lang.String name) {
        LoteNFeSoapWSDDServiceName = name;
    }

    public br.gov.sp.prefeitura.www.nfe.LoteNFeSoap getLoteNFeSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LoteNFeSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLoteNFeSoap(endpoint);
    }

    public br.gov.sp.prefeitura.www.nfe.LoteNFeSoap getLoteNFeSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.gov.sp.prefeitura.www.nfe.LoteNFeSoapStub _stub = new br.gov.sp.prefeitura.www.nfe.LoteNFeSoapStub(portAddress, this);
            _stub.setPortName(getLoteNFeSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLoteNFeSoapEndpointAddress(java.lang.String address) {
        LoteNFeSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.gov.sp.prefeitura.www.nfe.LoteNFeSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                br.gov.sp.prefeitura.www.nfe.LoteNFeSoapStub _stub = new br.gov.sp.prefeitura.www.nfe.LoteNFeSoapStub(new java.net.URL(LoteNFeSoap_address), this);
                _stub.setPortName(getLoteNFeSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LoteNFeSoap".equals(inputPortName)) {
            return getLoteNFeSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "LoteNFe");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.prefeitura.sp.gov.br/nfe", "LoteNFeSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LoteNFeSoap".equals(portName)) {
            setLoteNFeSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
