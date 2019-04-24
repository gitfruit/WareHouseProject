package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whusertab")
public class WHUserType {

	@Id
	@Column(name="uid")
	@GeneratedValue
	private Integer userId;
	@Column(name="utype")
	private String userType;
	@Column(name="ucode")
	private String userCode;
	@Column(name="ufor")
	private String userFor;
	@Column(name="uemail")
	private String userEmail;
	@Column(name="ucontact")
	private Integer userContact;
	@Column(name="uidtype")
	private String userIDType;
	@Column(name="idnumber")
	private String idNumber;
	public WHUserType() {
		super();
	}
	public WHUserType(Integer userId) {
		super();
		this.userId = userId;
	}
	public WHUserType(Integer userId, String userType, String userCode, String userFor, String userEmail,
			Integer userContact, String userIDType, String idNumber) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.userCode = userCode;
		this.userFor = userFor;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userIDType = userIDType;
		this.idNumber = idNumber;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserFor() {
		return userFor;
	}
	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Integer getUserContact() {
		return userContact;
	}
	public void setUserContact(Integer userContact) {
		this.userContact = userContact;
	}
	public String getUserIDType() {
		return userIDType;
	}
	public void setUserIDType(String userIDType) {
		this.userIDType = userIDType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Override
	public String toString() {
		return "WHUserType [userId=" + userId + ", userType=" + userType + ", userCode=" + userCode + ", userFor="
				+ userFor + ", userEmail=" + userEmail + ", userContact=" + userContact + ", userIDType=" + userIDType
				+ ", idNumber=" + idNumber + "]";
	}
	
}
