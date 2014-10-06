/**
 * ServiceGinfesImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.ginfes.producao;

public class ServiceGinfesImplServiceLocator extends org.apache.axis.client.Service implements br.com.ginfes.producao.ServiceGinfesImplService {

    public ServiceGinfesImplServiceLocator() {
    }


    public ServiceGinfesImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceGinfesImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiceGinfesImplPort
    private java.lang.String ServiceGinfesImplPort_address = "https://producao.ginfes.com.br//ServiceGinfesImpl";

    public java.lang.String getServiceGinfesImplPortAddress() {
        return ServiceGinfesImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiceGinfesImplPortWSDDServiceName = "ServiceGinfesImplPort";

    public java.lang.String getServiceGinfesImplPortWSDDServiceName() {
        return ServiceGinfesImplPortWSDDServiceName;
    }

    public void setServiceGinfesImplPortWSDDServiceName(java.lang.String name) {
        ServiceGinfesImplPortWSDDServiceName = name;
    }

    public br.com.ginfes.producao.ServiceGinfesImpl getServiceGinfesImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiceGinfesImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiceGinfesImplPort(endpoint);
    }

    public br.com.ginfes.producao.ServiceGinfesImpl getServiceGinfesImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.ginfes.producao.ServiceGinfesImplBindingStub _stub = new br.com.ginfes.producao.ServiceGinfesImplBindingStub(portAddress, this);
            _stub.setPortName(getServiceGinfesImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiceGinfesImplPortEndpointAddress(java.lang.String address) {
        ServiceGinfesImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.ginfes.producao.ServiceGinfesImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.ginfes.producao.ServiceGinfesImplBindingStub _stub = new br.com.ginfes.producao.ServiceGinfesImplBindingStub(new java.net.URL(ServiceGinfesImplPort_address), this);
                _stub.setPortName(getServiceGinfesImplPortWSDDServiceName());
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
        if ("ServiceGinfesImplPort".equals(inputPortName)) {
            return getServiceGinfesImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://producao.ginfes.com.br", "ServiceGinfesImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://producao.ginfes.com.br", "ServiceGinfesImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiceGinfesImplPort".equals(portName)) {
            setServiceGinfesImplPortEndpointAddress(address);
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
