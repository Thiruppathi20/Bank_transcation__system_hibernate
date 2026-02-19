package com.wipro.bank.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.entity.Account;
import com.wipro.bank.entity.Transfer;
import com.wipro.bank.util.HibernateUtil;

import java.math.BigDecimal;
import java.util.Date;

public class BankDAO {

    public boolean validateAccount(String accountNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Account.class, accountNumber) != null;
        }
    }

    public double findBalance(String accountNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Account account = session.get(Account.class, accountNumber);
            return account != null ? account.getBalance().doubleValue() : -1;
        }
    }

    public boolean transferMoney(TransferBean transferBean) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            Account fromAcc = session.get(Account.class, transferBean.getFromAccountNumber());
            Account toAcc = session.get(Account.class, transferBean.getToAccountNumber());

            if (fromAcc == null || toAcc == null)
                throw new RuntimeException("Invalid account");

            double amount = transferBean.getAmount();

            if (fromAcc.getBalance().doubleValue() < amount)
                throw new RuntimeException("Insufficient balance");

            fromAcc.setBalance(fromAcc.getBalance().subtract(BigDecimal.valueOf(amount)));
            toAcc.setBalance(toAcc.getBalance().add(BigDecimal.valueOf(amount)));

            Transfer transfer = new Transfer();
            transfer.setAccount(fromAcc);
            transfer.setBeneficiaryAccountNumber(transferBean.getToAccountNumber());
            transfer.setAmount(BigDecimal.valueOf(amount));
            transfer.setTransactionDate(new Date());

            session.persist(transfer);

            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return false;
    }
}