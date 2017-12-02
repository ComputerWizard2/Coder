package com.yuzhi.bean;

public class Books {
	private String barCode;// 编码
	private String bName;// 书名
	private String Writer;// 作者
	private String press;// 出版社
	private String presstime;// 出版时间
	private double price;// 价格
	private String sort;// 种类
	private int pageNum;// 页码
	private int lengNum;// 借出数量
	private String state;// 目前的状态
	private String borrower;// 借阅者

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getPresstime() {
		return presstime;
	}

	public void setPresstime(String presstime) {
		this.presstime = presstime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getLengNum() {
		return lengNum;
	}

	public void setLengNum(int lengNum) {
		this.lengNum = lengNum;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

}
