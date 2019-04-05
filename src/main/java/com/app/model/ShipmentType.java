package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ShipmentTab")
public class ShipmentType {
    
	@Id
	@Column(name="sid")
	@GeneratedValue
	private Integer shipmentId;
    @Column(name="smode")
	private String shipmentMode;
	@Column(name="scode")
	private String shipmentCode;
	@Column(name="senabled")
	private String shipmentEnable;
    @Column(name="sgrades")
    private String shipmentGrade;
    @Column(name="snotes")
    private String snote;
	public ShipmentType() {
		super();
	}
	public ShipmentType(Integer shipmentId) {
		super();
		this.shipmentId = shipmentId;
	}
	public ShipmentType(Integer shipmentId, String shipmentMode, String shipmentCode, String shipmentEnable,
			String shipmentGrade, String snote) {
		super();
		this.shipmentId = shipmentId;
		this.shipmentMode = shipmentMode;
		this.shipmentCode = shipmentCode;
		this.shipmentEnable = shipmentEnable;
		this.shipmentGrade = shipmentGrade;
		this.snote = snote;
	}
	public Integer getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(Integer shipmentId) {
		this.shipmentId = shipmentId;
	}
	public String getShipmentMode() {
		return shipmentMode;
	}
	public void setShipmentMode(String shipmentMode) {
		this.shipmentMode = shipmentMode;
	}
	public String getShipmentCode() {
		return shipmentCode;
	}
	public void setShipmentCode(String shipmentCode) {
		this.shipmentCode = shipmentCode;
	}
	public String getShipmentEnable() {
		return shipmentEnable;
	}
	public void setShipmentEnable(String shipmentEnable) {
		this.shipmentEnable = shipmentEnable;
	}
	public String getShipmentGrade() {
		return shipmentGrade;
	}
	public void setShipmentGrade(String shipmentGrade) {
		this.shipmentGrade = shipmentGrade;
	}
	public String getSnote() {
		return snote;
	}
	public void setSnote(String snote) {
		this.snote = snote;
	}
	@Override
	public String toString() {
		return "ShipmentType [shipmentId=" + shipmentId + ", shipmentMode=" + shipmentMode + ", shipmentCode="
				+ shipmentCode + ", shipmentEnable=" + shipmentEnable + ", shipmentGrade=" + shipmentGrade + ", snote="
				+ snote + "]";
	}

    
  
}
