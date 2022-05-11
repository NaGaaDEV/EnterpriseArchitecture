package edu.miu.cs.cs544.exercise17_1.bank.logging;

import org.springframework.stereotype.Component;

@Component
public class LoggerImpl implements Logger{

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}

}
