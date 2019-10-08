package edu.testApp;

import edu.dao.AccountDao;
import edu.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testapp {
    @Test
    public void test1(){
        String xmlPath="edu/applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(xmlPath);
        AccountService proxyAccountService = (AccountService) applicationContext.getBean("accountService");
        proxyAccountService.trasfer("jack","simon",100);
    }
}
