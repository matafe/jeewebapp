package com.matafe.jeewebapp.web.bussiness.handler;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

import com.matafe.jeewebapp.web.bussiness.MyWSServlet;

public class ClientHandler implements Handler<MessageContext> {
	public boolean handleMessage(MessageContext messageContext) {
		MyWSServlet.write("    ClientHandler handleMessage");
		return true;
	}

	public void close(MessageContext messageContext) {
		MyWSServlet.write("    ClientHandler close");
	}

	public boolean handleFault(MessageContext messageContext) {
		MyWSServlet.write("    ClientHandler handleFault");
		return true;
	}
}