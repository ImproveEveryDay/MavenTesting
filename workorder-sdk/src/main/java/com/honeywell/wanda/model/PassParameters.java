package com.honeywell.wanda.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PassParameters {
	@JsonProperty("STATUS")
    public String STATUS;
	
	@JsonProperty("WONUM")
    public String WONUM;
	
	@JsonProperty("LYRWBH")
    public String LYRWBH;
	
	@JsonProperty("SITEID")
    public String SITEID;
	
	@JsonProperty("DESCRIPTION")
    public String DESCRIPTION;
	
	@JsonProperty("TSTIME")
    public String TSTIME;
	
	@JsonProperty("LY")
    public String LY;
	
	@JsonProperty("LEAD")
    public String LEAD;
	
	@JsonProperty("URL")
	public String URL;
	
	public PassParameters(){
	}
    public PassParameters(String sTATUS, String wONUM, String lYRWBH, String sITEID, String dESCRIPTION, String tSTIME,
			String lY, String lEAD, String uRL) {
		super();
		STATUS = sTATUS;
		WONUM = wONUM;
		LYRWBH = lYRWBH;
		SITEID = sITEID;
		DESCRIPTION = dESCRIPTION;
		TSTIME = tSTIME;
		LY = lY;
		LEAD = lEAD;
		URL = uRL;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getWONUM() {
		return WONUM;
	}
	public void setWONUM(String wONUM) {
		WONUM = wONUM;
	}
	public String getLYRWBH() {
		return LYRWBH;
	}
	public void setLYRWBH(String lYRWBH) {
		LYRWBH = lYRWBH;
	}
	public String getSITEID() {
		return SITEID;
	}
	public void setSITEID(String sITEID) {
		SITEID = sITEID;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getTSTIME() {
		return TSTIME;
	}
	public void setTSTIME(String tSTIME) {
		TSTIME = tSTIME;
	}
	public String getLY() {
		return LY;
	}
	public void setLY(String lY) {
		LY = lY;
	}
	public String getLEAD() {
		return LEAD;
	}
	public void setLEAD(String lEAD) {
		LEAD = lEAD;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
}
