package com.matafe.jeewebapp.core.bussiness.ws.handler;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;

public class ServerHandler implements Handler<MessageContext> {

	public boolean handleMessage(MessageContext messageContext) {
		System.out.println("        ServerHandler handleMessage");
		return true;
	}

	public void close(MessageContext messageContext) {
		System.out.println("        ServerHandler close");
	}

	public boolean handleFault(MessageContext messageContext) {
		System.out.println("        ServerHandler handleFault");
		return true;
	}
}