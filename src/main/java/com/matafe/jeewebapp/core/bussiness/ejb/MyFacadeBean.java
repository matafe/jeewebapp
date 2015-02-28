package com.matafe.jeewebapp.core.bussiness.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.matafe.jeewebapp.core.bussiness.IMyFacadeBeanLocal;
import com.matafe.jeewebapp.core.bussiness.IMyFacadeBeanRemote;

/**
 * Session Bean implementation class MyFacadeBean
 */
@Stateless
@LocalBean
public class MyFacadeBean implements IMyFacadeBeanRemote, IMyFacadeBeanLocal {

	/**
	 * Default constructor.
	 */
	public MyFacadeBean() {
	}

	@Override
	public String getMessage(String message) {
		return String.format("Message from server %s", message);
	}

}
