package ie.atu.transaction_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class Transaction_Controller {

    @RestController
    public class Transaction_Service {

        private final Transaction_Service transactionService;

        @Autowired
        public TransactionController(Transaction_Service transactionService) {
            this.transactionService = transactionService;
        }

        @PostMapping("/deposit")
        public ResponseEntity<String> deposit(@RequestParam long accountId, @RequestParam long amount) {
            transactionService.deposit(accountId, amount);
            return ResponseEntity.ok("Deposit completed successfully");
        }

        @PostMapping("/withdraw")
        public ResponseEntity<String> withdraw(@RequestParam long accountId, @RequestParam long amount) {
            transactionService.withdraw(accountId, amount);
            return ResponseEntity.ok("Withdrawal completed successfully");
        }
    }


}
