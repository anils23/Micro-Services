package com.tyss.response;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6568726203999776289L;

	private String message;
	
	private Object data;

}
