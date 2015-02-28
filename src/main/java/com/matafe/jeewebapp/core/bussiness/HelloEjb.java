package com.matafe.jeewebapp.core.bussiness;

import javax.jws.WebService;

/**
 * Interface de contrato de um simples Webservice JAXWS
 * 
 * @author Mauricio Tavares Ferraz
 */
@WebService(targetNamespace = "http://matafe.com/wsdl")
public interface HelloEjb {
	String hello(String name);
}
