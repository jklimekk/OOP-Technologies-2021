package command;

import model.Account;
import model.Transaction;

public class RemoveTransactionsCommand implements Command {

    private final Transaction transactionToRemove;
    private final Account account;

    public RemoveTransactionsCommand(Transaction transactionToRemove, Account account) {
        this.transactionToRemove = transactionToRemove;
        this.account = account;
    }

    @Override
    public void execute() {
        account.removeTransaction(transactionToRemove);
    }

    @Override
    public String getName() {
        return "Deleted transaction: " + transactionToRemove.toString();
    }
}
