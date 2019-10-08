package edu.serviceimpl;

import edu.dao.AccountDao;
import edu.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    private TransactionTemplate  transactionTemplate;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void trasfer( final String outer, final String inner, final Integer money) {

                accountDao.in(inner,money);
                accountDao.out(outer,money);

    }

}
