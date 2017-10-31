package com.honeywell.wanda.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthCookie {
	@JsonProperty("Value")
	private String cookieValue;
	@JsonProperty("exp")
	private String expDate;

	public String getCookieValue() {
		return cookieValue;
	}

	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

}
