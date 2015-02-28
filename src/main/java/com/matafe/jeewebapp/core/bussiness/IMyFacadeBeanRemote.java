package com.matafe.jeewebapp.core.bussiness;

import javax.ejb.Remote;

@Remote
public interface IMyFacadeBeanRemote {
	
	String getMessage(String message);

}
