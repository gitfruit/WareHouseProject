package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="omtab")
public class OrderMethod {

	@Id
	@Column(name="omid")
	@GeneratedValue
	private Integer orderId;
    @Column(name="ommode")
    private String orderMode;
    @Column(name="omcode")
    private String orderCode;
    @Column(name="omextype")
    private String exeType;
    @Column(name="omnote")
    private String note;
    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="omacpttab",joinColumns=@JoinColumn(name="omid"))
    @OrderColumn(name="pos")
    @Column(name="data")
    private List<String> orderAccepts;
	public OrderMethod(Integer orderId, String orderMode, String orderCode, String exeType, String note,
			List<String> orderAccepts) {
		super();
		this.orderId = orderId;
		this.orderMode = orderMode;
		this.orderCode = orderCode;
		this.exeType = exeType;
		this.note = note;
		this.orderAccepts = orderAccepts;
	}
	public OrderMethod() {
		super();
	}
	public OrderMethod(Integer orderId) {
		super();
		this.orderId = orderId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getExeType() {
		return exeType;
	}
	public void setExeType(String exeType) {
		this.exeType = exeType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<String> getOrderAccepts() {
		return orderAccepts;
	}
	public void setOrderAccepts(List<String> orderAccepts) {
		this.orderAccepts = orderAccepts;
	}
	@Override
	public String toString() {
		return "OrderMethod [orderId=" + orderId + ", orderMode=" + orderMode + ", orderCode=" + orderCode
				+ ", exeType=" + exeType + ", note=" + note + ", orderAccepts=" + orderAccepts + "]";
	}
	
    
}
