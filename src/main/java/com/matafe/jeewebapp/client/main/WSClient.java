package com.matafe.jeewebapp.client.main;

import java.io.PrintStream;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.matafe.jeewebapp.core.bussiness.HelloEjb;
import com.matafe.jeewebapp.core.bussiness.HelloPojo;

/**
 * Um Simples Cliente Web Services que acessa o serviço remoto (Um JAXWS_JSE e
 * um JAXWS_EJB3).
 * 
 * @author Mauricio Tavares Ferraz
 */
public class WSClient {

	public static void main(String[] args) throws Exception {

		PrintStream out = System.out;

		QName qNamePojo = new QName("http://matafe.com/wsdl",
				"HelloPojoService");
		Service helloPojoService = Service.create(new URL(
				"http://localhost:8080/jeewebapp/HelloPojoService?wsdl"),
				qNamePojo);
		HelloPojo helloPojo = helloPojoService.getPort(HelloPojo.class);
		out.println();
		out.println("Pojo Webservice");
		out.println("    helloPojo.hello(\"Mauricio\")="
				+ helloPojo.hello("Mauricio"));
		out.println("    helloPojo.hello(null)=" + helloPojo.hello(null));
		out.println();

		QName qNameEjb = new QName("http://matafe.com/wsdl",
				"HelloEjbService");
		Service helloEjbService = Service
				.create(new URL(
						"http://localhost:8080/jeewebapp/HelloEjbService/HelloEjbService?wsdl"),
						qNameEjb);
		HelloEjb helloEjb = helloEjbService.getPort(HelloEjb.class);
		out.println();
		out.println("EJB Webservice");
		out.println("    helloEjb.hello(\"MATAFE\")="
				+ helloEjb.hello("MATAFE"));
		out.println("    helloEjb.hello(null)=" + helloEjb.hello(null));
		out.println();

	}

}
