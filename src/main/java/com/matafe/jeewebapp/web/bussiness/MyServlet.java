package com.matafe.jeewebapp.web.bussiness;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matafe.jeewebapp.core.bussiness.IMyFacadeBeanLocal;
import com.matafe.jeewebapp.core.bussiness.IMyFacadeBeanRemote;
import com.matafe.jeewebapp.core.bussiness.ejb.MyFacadeBean;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(description = "Meu Servlet", urlPatterns = { "/MyServlet" })
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IMyFacadeBeanLocal localEJB;

	@EJB
	private IMyFacadeBeanRemote remoteEJB;

	@EJB
	private MyFacadeBean localbeanEJB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
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

		out.println("LocalBean EJB");
		out.println("@EJB=" + localbeanEJB);
		if (localbeanEJB != null) {
			out.println("@EJB.getMessage()=" + localbeanEJB.getMessage("OLA LOCAL BEAN EJB"));
		}
		out.println("JNDI=" + lookupField("localbeanEJB"));
		out.println();

		out.println("Local EJB");
		out.println("@EJB=" + localEJB);
		if (localEJB != null) {
			out.println("@EJB.getMessage()=" + localEJB.getMessage("OLA LOCAL EJB"));
		}
		out.println("JNDI=" + lookupField("localEJB"));
		out.println();

		out.println("Remote EJB");
		out.println("@EJB=" + remoteEJB);
		if (localEJB != null) {
			out.println("@EJB.getMessage()=" + remoteEJB.getMessage("OLA LOCAL EJB"));
		}
		out.println("JNDI=" + lookupField("remoteEJB"));
		out.println();

	}

	private Object lookupField(String name) {
		try {
			return new InitialContext().lookup("java:comp/env/"
					+ getClass().getName() + "/" + name);
		} catch (NamingException e) {
			return null;
		}
	}
}
