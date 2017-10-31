package com.honeywell.wanda.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessWorkOrderResponse {

	@JsonProperty("RETCODE")
	private String RETCODE;
	@JsonProperty("DESCRIPTION")
	private String DESCRIPTION;
	public ProcessWorkOrderResponse(String rETCODE, String dESCRIPTION) {
		super();
		RETCODE = rETCODE;
		DESCRIPTION = dESCRIPTION;
	}
	public String getRETCODE() {
		return RETCODE;
	}
	public void setRETCODE(String rETCODE) {
		RETCODE = rETCODE;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
}
