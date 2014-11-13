/**
 * ServiceMainLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.MingdaSoft;

public class ServiceMainLocator extends org.apache.axis.client.Service implements com.MingdaSoft.ServiceMain {

    public ServiceMainLocator() {
    }


    public ServiceMainLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceMainLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiceMainSoap
    private java.lang.String ServiceMainSoap_address = "http://10.10.10.2/ServiceMin.asmx";

    public java.lang.String getServiceMainSoapAddress() {
        return ServiceMainSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiceMainSoapWSDDServiceName = "ServiceMainSoap";

    public java.lang.String getServiceMainSoapWSDDServiceName() {
        return ServiceMainSoapWSDDServiceName;
    }

    public void setServiceMainSoapWSDDServiceName(java.lang.String name) {
        ServiceMainSoapWSDDServiceName = name;
    }

    public com.MingdaSoft.ServiceMainSoap getServiceMainSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiceMainSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiceMainSoap(endpoint);
    }

    public com.MingdaSoft.ServiceMainSoap getServiceMainSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.MingdaSoft.ServiceMainSoapStub _stub = new com.MingdaSoft.ServiceMainSoapStub(portAddress, this);
            _stub.setPortName(getServiceMainSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiceMainSoapEndpointAddress(java.lang.String address) {
        ServiceMainSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.MingdaSoft.ServiceMainSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.MingdaSoft.ServiceMainSoapStub _stub = new com.MingdaSoft.ServiceMainSoapStub(new java.net.URL(ServiceMainSoap_address), this);
                _stub.setPortName(getServiceMainSoapWSDDServiceName());
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
        if ("ServiceMainSoap".equals(inputPortName)) {
            return getServiceMainSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://MingdaSoft.com/", "ServiceMain");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://MingdaSoft.com/", "ServiceMainSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiceMainSoap".equals(portName)) {
            setServiceMainSoapEndpointAddress(address);
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
