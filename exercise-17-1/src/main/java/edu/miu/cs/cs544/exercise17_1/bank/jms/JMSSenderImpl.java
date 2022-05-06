package edu.miu.cs.cs544.exercise17_1.bank.jms;

import org.springframework.stereotype.Component;

@Component
public class JMSSenderImpl implements JMSSender{
	
	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
	}

}
