package com.yuzhi.bean;

public class LendBooks {
	private int id;
	private String rNo;
	private String lendBook;
	private String barCode;
	private String borrower;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getrNo() {
		return rNo;
	}

	public void setrNo(String rNo) {
		this.rNo = rNo;
	}

	public String getLendBook() {
		return lendBook;
	}

	public void setLendBook(String lendBook) {
		this.lendBook = lendBook;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

}