/**
 * IService1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface IService1 extends java.rmi.Remote {
    public java.lang.String getData(java.lang.Integer value) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.WcfMedExchange.CompositeType getDataUsingDataContract(org.datacontract.schemas._2004._07.WcfMedExchange.CompositeType composite) throws java.rmi.RemoteException;
    public java.lang.String setAssistStatusBatch(java.lang.Long bizNo, java.lang.String orgCode) throws java.rmi.RemoteException;
    public java.lang.String setAssistStatusSingle(java.lang.String IDNumber, java.lang.String memberName, java.lang.String familyNo, java.lang.String assistType, java.lang.String stsTime) throws java.rmi.RemoteException;
}
