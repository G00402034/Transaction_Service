package ie.atu.transaction_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class Transaction_Service {

    private final AccountService accountService;

    @Autowired
    public TransactionService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void deposit(long accountId, long amount) {
        long currentBalance = accountService.getBalance(accountId);
        long newBalance = currentBalance.add(amount);
        accountService.updateBalance(accountId, newBalance);
    }

    public void withdraw(long accountId, long amount) {
        long currentBalance = accountService.getBalance(accountId);
        if (currentBalance.compareTo(amount) >= 0) {
            long newBalance = currentBalance.subtract(amount);
            accountService.updateBalance(accountId, newBalance);
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
    }
}



