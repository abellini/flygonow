package br.com.flygonow.dao.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

	@Autowired
	private MessageService services;
	
	public void printMessage() {
		System.out.println(this.services.getMessage());
	}

}
