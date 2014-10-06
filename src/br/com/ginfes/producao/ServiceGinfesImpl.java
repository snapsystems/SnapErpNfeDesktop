/**
 * ServiceGinfesImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.ginfes.producao;

public interface ServiceGinfesImpl extends java.rmi.Remote {
    public java.lang.String cancelarNfse(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String cancelarNfseV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String consultarLoteRps(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String consultarLoteRpsV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String consultarNfse(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String consultarNfsePorRps(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String consultarNfsePorRpsV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String consultarNfseV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String consultarSituacaoLoteRps(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String consultarSituacaoLoteRpsV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String recepcionarLoteRps(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String recepcionarLoteRpsV3(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
