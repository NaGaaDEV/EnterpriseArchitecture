package edu.miu.cs.cs544.exercise13_1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

import java.util.Date;

@Aspect
public class InterceptEmailSenderAdvice {
    @After("execution(* edu.miu.cs.cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email, message)")
    public void interceptAfterSendEmail(JoinPoint joinPoint, String email, String message) {
        System.out.print(new Date());
        System.out.print(", method = " + joinPoint.getSignature().getName());
        System.out.print(", address = " + email);
        System.out.println(", message = " + message);
        IEmailSender emailSender = (IEmailSender) joinPoint.getTarget();
        System.out.println("outgoing mail server = " + emailSender.getOutgoingMailServer());
    }

    @Around("execution(* edu.miu.cs.cs544.exercise13_1.EmailSender.sendEmail(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totalTime = sw.getLastTaskTimeMillis();
        System.out.printf("Time to execute save = %d ms\n", totalTime);

        return retVal;
    }
}
