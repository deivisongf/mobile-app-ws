package com.r4s.app.sw.mobileappws.ui.model.response;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorMessage {
	
	private Date timestamp;
	private String message;
	
	public ErrorMessage() {}
	
	public ErrorMessage(Date timesDate, String message) {
		this.timestamp = timesDate;
		this.message = message;
	}
}
