package org.sambasoft.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FlatDtls implements Serializable {

	@Id
	@GeneratedValue
	long flatId;
	FlatDtls(){
		
	}
	public FlatDtls(String flatNo, String flatType, String ownerName, String possessionDate, long phno, String wing,
			String isParking, String parkingAmt, long maintenanceAmt) {
		super();
		this.flatNo = flatNo;
		this.flatType = flatType;
		this.ownerName = ownerName;
		this.possessionDate = possessionDate;
		this.phno = phno;
		this.wing = wing;
		IsParking = isParking;
		this.parkingAmt = parkingAmt;
		this.maintenanceAmt = maintenanceAmt;
	}
	String flatNo;
	String flatType;
	String ownerName;
	String possessionDate;
	long phno;
	String wing;
	String IsParking;
	String parkingAmt;
	long maintenanceAmt;
	
	public long getFlatId() {
		return flatId;
	}
	public void setFlatId(long flatId) {
		this.flatId = flatId;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getFlatType() {
		return flatType;
	}
	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getPossessionDate() {
		return possessionDate;
	}
	public void setPossessionDate(String possessionDate) {
		this.possessionDate = possessionDate;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public String getWing() {
		return wing;
	}
	public void setWing(String wing) {
		this.wing = wing;
	}
	public String getIsParking() {
		return IsParking;
	}
	public void setIsParking(String isParking) {
		IsParking = isParking;
	}
	public String getParkingAmt() {
		return parkingAmt;
	}
	public void setParkingAmt(String parkingAmt) {
		this.parkingAmt = parkingAmt;
	}
	public long getMaintenanceAmt() {
		return maintenanceAmt;
	}
	public void setMaintenanceAmt(long maintenanceAmt) {
		this.maintenanceAmt = maintenanceAmt;
	}
	
}
