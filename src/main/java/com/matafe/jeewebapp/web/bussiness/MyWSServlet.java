package com.matafe.jeewebapp.web.bussiness;

import java.io.IOException;

import javax.jws.HandlerChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import com.matafe.jeewebapp.core.bussiness.HelloEjb;
import com.matafe.jeewebapp.core.bussiness.HelloPojo;

/**
 * Servlet implementation class MyWSServlet
 */
@WebServlet(description = "Servlet com WebServices", urlPatterns = { "/MyWSServlet" })
public class MyWSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static ServletOutputStream OUT;

	@WebServiceRef
	//@HandlerChain(file = "client-handlers.xml")
	private HelloPojo helloPojo;

	@WebServiceRef
	//@HandlerChain(file = "client-handlers.xml")
	private HelloEjb helloEjb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyWSServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		ServletOutputStream out = response.getOutputStream();

		OUT = out;
		try {
			out.println("Pojo Webservice");
			out.println("    helloPojo.hello(\"Bob\")="
					+ helloPojo.hello("Bob"));
			out.println();
			out.println("    helloPojo.hello(null)=" + helloPojo.hello(null));
			out.println();
			out.println("EJB Webservice");
			out.println("    helloEjb.hello(\"Mauricio\")="
					+ helloEjb.hello("Mauricio"));
			out.println();
			out.println("    helloEjb.hello(null)=" + helloEjb.hello(null));
			out.println();
		} finally {
			OUT = out;
		}
	}

	public static void write(String message) {
		try {
			ServletOutputStream out = OUT;
			out.println(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
