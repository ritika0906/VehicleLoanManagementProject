package com.vechileloanapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Duplicate loan application ")
public class DuplicateRecordException  extends Exception
{
	
	private static final long serialVersionUID = 1L;

	
	public DuplicateRecordException(String msg) {
		super(msg);
	}
}
