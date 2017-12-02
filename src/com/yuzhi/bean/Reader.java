package com.yuzhi.bean;

public class Reader {
	private String rNo;
	private String rName;
	private String rSex;
	private String rAge;

	@Override
	public String toString() {
		return "Reader [rNo=" + rNo + ", rName=" + rName + ", rSex=" + rSex + ", rAge=" + rAge + ", rClass=" + rClass
				+ ", rSort=" + rSort + ", rPhoneNum=" + rPhoneNum + ", passWord=" + passWord + ", lendNum=" + lendNum
				+ ", canLendNum=" + canLendNum + "]";
	}

	private String rClass;
	private String rSort;
	private String rPhoneNum;
	private String passWord;
	private int lendNum;
	private int canLendNum;

	public String getrNo() {
		return rNo;
	}

	public void setrNo(String rNo) {
		this.rNo = rNo;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public String getrSex() {
		return rSex;
	}

	public void setrSex(String rSex) {
		this.rSex = rSex;
	}

	public String getrAge() {
		return rAge;
	}

	public void setrAge(String rAge) {
		this.rAge = rAge;
	}

	public String getrClass() {
		return rClass;
	}

	public void setrClass(String rClass) {
		this.rClass = rClass;
	}

	public String getrSort() {
		return rSort;
	}

	public void setrSort(String rSort) {
		this.rSort = rSort;
	}

	public String getrPhoneNum() {
		return rPhoneNum;
	}

	public void setrPhoneNum(String rPhoneNum) {
		this.rPhoneNum = rPhoneNum;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getLendNum() {
		return lendNum;
	}

	public void setLendNum(int lendNum) {
		this.lendNum = lendNum;
	}

	public int getCanLendNum() {
		return canLendNum;
	}

	public void setCanLendNum(int canLendNum) {
		this.canLendNum = canLendNum;
	}

}
