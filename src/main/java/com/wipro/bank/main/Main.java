
package com.wipro.bank.main;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.service.BankService;

public class Main {
    public static void main(String[] args) {

        BankService service = new BankService();

        TransferBean bean = new TransferBean();
        bean.setFromAccountNumber("1234567890");
        bean.setToAccountNumber("1234567893");
        bean.setAmount(10000);

        boolean status = service.transferMoney(bean);

        System.out.println(status ? "Transfer Success" : "Transfer Failed");
    }
}
