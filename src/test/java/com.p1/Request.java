package com.p1;




import javax.xml.bind.annotation.*;
import javax.xml.bind.*;

import java.util.*;
import java.sql.Timestamp;

@XmlRootElement(name="request")
public class Request {
long Requestid;	
 String Requesttype;
 String Requestpriority;
 String Assettype;
 String Assetsubtype;
 String Reason; 
 String Remarks;
 Date Requesttime;
 String Status;
 int Quantity;
@XmlElement
public long getRequestid() {
	return Requestid;
}
public void setRequestid(long Requestid) {
	this.Requestid = Requestid;
}
@XmlElement
public String getRequesttype() {
	return Requesttype;
}
public void setRequesttype(String Requesttype) {
	this.Requesttype = Requesttype;
}
@XmlElement
public String getRequestpriority() {
	return Requestpriority;
}
public void setRequestpriority(String Requestpriority) {
	this.Requestpriority = Requestpriority;
}
@XmlElement
public String getAssettype() {
	return Assettype;
}
public void setAssettype(String Assettype) {
	this.Assettype = Assettype;
}
@XmlElement
public String getAssetsubtype() {
	return Assetsubtype;
}
public void setAssetsubtype(String Assetsubtype) {
	this.Assetsubtype = Assetsubtype;
}
@XmlElement
public String getReason() {
	return Reason;
}
public void setReason(String Reason) {
	this.Reason = Reason;
}
@XmlElement
public String getRemarks() {
	return Remarks;
}
public void setRemarks(String Remarks) {
	this.Remarks = Remarks;
}
@XmlElement
public Date getRequesttime() {
	return Requesttime;
}
public void setRequesttime(Date Requesttime) {
	this.Requesttime = Requesttime;
}
@XmlElement
public String getStatus() {
	return Status;
}
public void setStatus(String Status) {
	this.Status = Status;
}
@XmlElement
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int Quantity) {
	this.Quantity = Quantity;
}
public Request(long Requestid, String Requesttype, String Requestpriority,
		String Assettype, String Assetsubtype, String Reason, String Remarks,
		Date Requesttime, String Status, int Quantity) {
	super();
	this.Requestid = Requestid;
	this.Requesttype = Requesttype;
	this.Requestpriority = Requestpriority;
	this.Assettype = Assettype;
	this.Assetsubtype = Assetsubtype;
	this.Reason = Reason;
	this.Remarks = Remarks;
	this.Requesttime = Requesttime;
	this.Status = Status;
	this.Quantity = Quantity;
}

public Request() {
	super();
}

}
