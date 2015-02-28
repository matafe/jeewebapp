package com.matafe.jeewebapp.core.bussiness.ejb.ws;

import javax.ejb.Stateless;
import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.matafe.jeewebapp.core.bussiness.HelloEjb;

@WebService(portName = "HelloEjbPort", serviceName = "HelloEjbService", targetNamespace = "http://matafe.com/wsdl", endpointInterface = "com.matafe.jeewebapp.core.bussiness.HelloEjb")
@HandlerChain(file = "/server-handlers.xml")
@Stateless
public class HelloEjbService implements HelloEjb {

	@Override
	public String hello(String name) {
		if (name == null) {
			name = "World";
		}
		return "Hello " + name + " from EJB Webservice!";
	}

}
