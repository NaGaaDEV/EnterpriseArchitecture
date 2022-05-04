package edu.miu.cs.cs544.exercise12_1.bank;

import edu.miu.cs.cs544.exercise12_1.bank.dao.AccountDAO;
import edu.miu.cs.cs544.exercise12_1.bank.jms.JMSSender;
import edu.miu.cs.cs544.exercise12_1.bank.logging.Logger;
import edu.miu.cs.cs544.exercise12_1.bank.service.AccountService;
import edu.miu.cs.cs544.exercise12_1.bank.service.CurrencyConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {
    @Bean
    @Lazy(value = true)
    public AccountService accountService() {
       return new AccountService();
    }

    @Bean
    public AccountDAO AccountDAO() {
        return new AccountDAO();
    }
    @Bean
    public CurrencyConverter CurrencyConverter() {
        return new CurrencyConverter();
    }
    @Bean
    public JMSSender JMSSender() {
        return new JMSSender();
    }
    @Bean
    public Logger Logger() {
        return new Logger();
    }
}
