package com.matafe.jeewebapp.core.bussiness;

import javax.jws.WebService;

@WebService(targetNamespace = "http://matafe.com/wsdl")
public interface HelloPojo {
	String hello(String name);
}
