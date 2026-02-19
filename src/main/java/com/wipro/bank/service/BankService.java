
package com.wipro.bank.service;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.dao.BankDAO;

public class BankService {

    private BankDAO dao = new BankDAO();

    public boolean transferMoney(TransferBean bean) {
        if (!dao.validateAccount(bean.getFromAccountNumber()) ||
            !dao.validateAccount(bean.getToAccountNumber()))
            return false;

        double balance = dao.findBalance(bean.getFromAccountNumber());

        if (balance < bean.getAmount())
            return false;

        return dao.transferMoney(bean);
    }
}
