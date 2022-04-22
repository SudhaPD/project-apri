package org.adacitin;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage extends BaseClass{
	
	public BookPage() {
		PageFactory.initElements(driver,this);
	 } 

	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(id="first_name")
	private WebElement txtFirstname;
	
	@FindBy(id="last_name")
	private WebElement txtLastname;
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(id="cc_num")
	private WebElement ccNum;
	
	@FindBy(id="cc_type")
	private WebElement ccType;
	
	@FindBy(id="cc_exp_month")
	private WebElement ccMonth;

	@FindBy(id="cc_exp_year")
	private WebElement ccExpYear;
		
	@FindBy(id="cc_cvv")
	private WebElement ccCvv;
			
	@FindBy(id="book_now")
	private WebElement btnBookNow;
	
	@FindBy(id="order_no")
	private WebElement orderNo;

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getTxtFirstname() {
		return txtFirstname;
	}

	public WebElement getTxtLastname() {
		return txtLastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCcNum() {
		return ccNum;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public WebElement getCcMonth() {
		return ccMonth;
	}

	public WebElement getCcExpYear() {
		return ccExpYear;
	}

	public WebElement getCcCvv() {
		return ccCvv;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public WebElement getOrderNo() {
		return orderNo;
	}
	
    public void order(String first,String last,String address,String ccnum,String cvv) throws InterruptedException {
		click(getBtnRadio());
		click(getBtnContinue());
		sendkeys(getTxtFirstname(), first);
		sendkeys(getTxtLastname(), last);
		sendkeys(getAddress(),address);
		sendkeys(getCcNum(), ccnum);
		selectByValue(getCcType(), "AMEX");
		selectByValue(getCcMonth(),"3");
		selectByValue(getCcExpYear(), "2022");
		sendkeys(getCcCvv(), cvv);
		click(getBtnBookNow());
		Thread.sleep(2000);
		System.out.println("Order No."+getOrderNo().getAttribute("value"));
	}
	
}
