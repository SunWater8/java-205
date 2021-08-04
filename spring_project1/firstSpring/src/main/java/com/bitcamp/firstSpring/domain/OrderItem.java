package com.bitcamp.firstSpring.domain;

public class OrderItem {

	private String itemId;
	private int number;
	private String remark;
	

//	mvc가 객체를 만들어 줄 것이기 대문에 생성자는 기본으로 한다.
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", number=" + number + ", remark=" + remark + "]";
	}
	
	
}
