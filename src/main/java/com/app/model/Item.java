package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itab")
public class Item {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="icode")
	private String itemCode;
    @Column(name="dmns")
    private Double Dimensions;
    @Column(name="bcost")
    private String baseCost;
	@Column(name="bcurrency")
	private String baseCurrency;
	@Column(name="note")
	private String inote;
	public Item() {
		super();
	}
	public Item(Integer id, String itemCode, Double dimensions, String baseCost, String baseCurrency, String inote) {
		super();
		this.id = id;
		this.itemCode = itemCode;
		Dimensions = dimensions;
		this.baseCost = baseCost;
		this.baseCurrency = baseCurrency;
		this.inote = inote;
	}
	public Item(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Double getDimensions() {
		return Dimensions;
	}
	public void setDimensions(Double dimensions) {
		Dimensions = dimensions;
	}
	public String getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(String baseCost) {
		this.baseCost = baseCost;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getInote() {
		return inote;
	}
	public void setInote(String inote) {
		this.inote = inote;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemCode=" + itemCode + ", Dimensions=" + Dimensions + ", baseCost=" + baseCost
				+ ", baseCurrency=" + baseCurrency + ", inote=" + inote + "]";
	}
	 
	
}