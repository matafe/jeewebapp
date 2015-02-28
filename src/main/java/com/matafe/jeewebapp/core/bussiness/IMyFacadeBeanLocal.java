package com.matafe.jeewebapp.core.bussiness;

import javax.ejb.Local;

@Local
public interface IMyFacadeBeanLocal {
	String getMessage(String message);
}
