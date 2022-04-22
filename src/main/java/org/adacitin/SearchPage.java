package org.adacitin;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseClass{
	
	public SearchPage() {
		PageFactory.initElements(driver,this);
	 }
	
	@FindBy(id="location")
	private WebElement tabLocation;
	
	@FindBy(id="hotels")
	private WebElement tabHotel;
	
	@FindBy(id="room_type")
	private WebElement tabRoomTyp;
	
	@FindBy(id="room_nos")
	private WebElement tabNoRooms;
	
	@FindBy(id="Submit")
	private WebElement btnSubmit;
	
	public WebElement getTabLocation() {
		return tabLocation;
	}
	public WebElement getTabHotel() {
		return tabHotel;
	}
	public WebElement getTabRoomTyp() {
		return tabRoomTyp;
	}
	public WebElement getTabNoRooms() {
		return tabNoRooms;
	}
	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public void search() {
		
		selectByValue(getTabLocation(),"Brisbane");
		selectByValue(getTabHotel(), "Hotel Cornice");
		selectByValue(getTabRoomTyp(), "Deluxe");
		selectByValue(getTabNoRooms(), "5");
		click(getBtnSubmit());
	}

}
