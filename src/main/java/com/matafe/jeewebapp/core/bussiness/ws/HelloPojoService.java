package com.matafe.jeewebapp.core.bussiness.ws;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.matafe.jeewebapp.core.bussiness.HelloPojo;

@WebService(portName = "HelloPojoPort", serviceName = "HelloPojoService", targetNamespace = "http://matafe.com/wsdl", endpointInterface = "com.matafe.jeewebapp.core.bussiness.HelloPojo")
@HandlerChain(file = "/server-handlers.xml")
public class HelloPojoService implements HelloPojo {

	@Override
	public String hello(String name) {
		if (name == null) {
			name = "World";
		}
		return "Hello " + name + " from Pojo Webservice!";

	}

}
