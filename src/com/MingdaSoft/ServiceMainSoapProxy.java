package com.MingdaSoft;

public class ServiceMainSoapProxy implements com.MingdaSoft.ServiceMainSoap {
  private String _endpoint = null;
  private com.MingdaSoft.ServiceMainSoap serviceMainSoap = null;
  
  public ServiceMainSoapProxy() {
    _initServiceMainSoapProxy();
  }
  
  public ServiceMainSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceMainSoapProxy();
  }
  
  private void _initServiceMainSoapProxy() {
    try {
      serviceMainSoap = (new com.MingdaSoft.ServiceMainLocator()).getServiceMainSoap();
      if (serviceMainSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceMainSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceMainSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceMainSoap != null)
      ((javax.xml.rpc.Stub)serviceMainSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.MingdaSoft.ServiceMainSoap getServiceMainSoap() {
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap;
  }
  
  public java.lang.String idCheck(java.lang.String hospital_ID, java.lang.String family_No, java.lang.String name, java.lang.String photoFileName) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.idCheck(hospital_ID, family_No, name, photoFileName);
  }
  
  public java.lang.String checkSSN(java.lang.String hospital_ID, java.lang.String SSN, java.lang.String photoFileName) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.checkSSN(hospital_ID, SSN, photoFileName);
  }
  
  public java.lang.String setAssistFlag(java.lang.String bizID) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.setAssistFlag(bizID);
  }
  
  public java.lang.String setPhotoPath(java.lang.String bizID, java.lang.String confirm_id, java.lang.String photoPath) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.setPhotoPath(bizID, confirm_id, photoPath);
  }
  
  public java.lang.String setPhotoPath2(java.lang.String bizID, java.lang.String photoPath) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.setPhotoPath2(bizID, photoPath);
  }
  
  public java.lang.String calculateCharge(java.lang.String BIZ_ID) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.calculateCharge(BIZ_ID);
  }
  
  public java.lang.String getConfirmFlag(java.lang.String BIZID) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.getConfirmFlag(BIZID);
  }
  
  public java.lang.String getConfirm_ID(java.lang.String SSN) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.getConfirm_ID(SSN);
  }
  
  public java.lang.String chargeCancel(java.lang.String BIZ_ID) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.chargeCancel(BIZ_ID);
  }
  
  public java.lang.String bizInfoQue(java.lang.String hospitalID, java.lang.String SSN, java.lang.String operUID, java.lang.String operTimeBeg, java.lang.String operTimeEnd, java.lang.String chargeType, java.lang.String patientType) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.bizInfoQue(hospitalID, SSN, operUID, operTimeBeg, operTimeEnd, chargeType, patientType);
  }
  
  public java.lang.String bizInfoQuePrintList(java.lang.String hospitalID, java.lang.String SSN, java.lang.String operUID, java.lang.String operTimeBeg, java.lang.String operTimeEnd, java.lang.String patientType) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.bizInfoQuePrintList(hospitalID, SSN, operUID, operTimeBeg, operTimeEnd, patientType);
  }
  
  public java.lang.String bizInfoQueV1(java.lang.String hospitalID, java.lang.String SSN, java.lang.String operUID, java.lang.String operTimeBeg, java.lang.String operTimeEnd, java.lang.String chargeType, java.lang.String patientType) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.bizInfoQueV1(hospitalID, SSN, operUID, operTimeBeg, operTimeEnd, chargeType, patientType);
  }
  
  public java.lang.String checkOutFlag(java.lang.String hospitalID, java.lang.String SSN, java.lang.String begDT, java.lang.String endDT) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.checkOutFlag(hospitalID, SSN, begDT, endDT);
  }
  
  public java.lang.String checkOutFlagInfo(java.lang.String hospitalID, java.lang.String SSN, java.lang.String begDT, java.lang.String endDT, java.lang.String illType) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.checkOutFlagInfo(hospitalID, SSN, begDT, endDT, illType);
  }
  
  public java.lang.String checkFeeBatchOutFlag(java.lang.String SERIAL_NO) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.checkFeeBatchOutFlag(SERIAL_NO);
  }
  
  public java.lang.String getAlreadyGet(java.lang.String BIZID) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.getAlreadyGet(BIZID);
  }
  
  public java.lang.String setAlreadyGet(java.lang.String BIZID) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.setAlreadyGet(BIZID);
  }
  
  public java.lang.String getOutFlag(java.lang.String SSN, java.lang.String serialNO, java.lang.String feeBatch) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.getOutFlag(SSN, serialNO, feeBatch);
  }
  
  public java.lang.String BIZDataInsert(java.lang.String BIZSQL, java.lang.String payListSQL, java.lang.String feeInfoSQL, java.lang.String feeListSQL) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.BIZDataInsert(BIZSQL, payListSQL, feeInfoSQL, feeListSQL);
  }
  
  public java.lang.String BIZExcSQL(java.lang.String BIZSQL) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.BIZExcSQL(BIZSQL);
  }
  
  public java.lang.String BIZExcSQLEX(java.lang.String BIZSQL) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.BIZExcSQLEX(BIZSQL);
  }
  
  public java.lang.String savePic(java.lang.String base64Image, java.lang.String bizid, java.lang.String extfn) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.savePic(base64Image, bizid, extfn);
  }
  
  public java.lang.String execFunEx(java.lang.String xml) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.execFunEx(xml);
  }
  
  public java.lang.String getBizINList(java.lang.String hospital_id, java.lang.String ssn, java.lang.String begtime, java.lang.String endtime) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.getBizINList(hospital_id, ssn, begtime, endtime);
  }
  
  public java.lang.String delBizRecord(java.lang.String bizid) throws java.rmi.RemoteException{
    if (serviceMainSoap == null)
      _initServiceMainSoapProxy();
    return serviceMainSoap.delBizRecord(bizid);
  }
  
  
}