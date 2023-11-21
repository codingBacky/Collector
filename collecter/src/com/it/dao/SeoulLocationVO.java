package com.it.dao;
/*
 *  NO      NOT NULL NUMBER         
	TITLE   NOT NULL VARCHAR2(200)  
	POSTER  NOT NULL VARCHAR2(500)  
	MSG     NOT NULL VARCHAR2(4000) 
	ADDRESS NOT NULL VARCHAR2(300)       
 
 */
public class SeoulLocationVO {
    private int sale, itemNum;
    private String itemName, mainImg;
    
    
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getMainImg() {
		return mainImg;
	}
	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}
    

}
