package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;
import it.unibo.oop.lab04.bank.SimpleBankAccount;

public abstract class AbstractBankAccount implements BankAccount {
	
	public static final double ATM_TRANSACTION_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;
	
	private double balance;
	private int nTransactions;
	private final int userID;
	
	protected AbstractBankAccount(final int userID, final double balance) {
        this.userID = userID;
        this.balance = balance;
        this.nTransactions = 0;
    }

	/**
	 * Check if the userID the same as the the userID of this istance
	 * @param id id of the user for the operation
	 * @return true if it's the same, false otherwise
	 */
	protected boolean checkUser(final int id) {
        return this.userID == id;
    }

	/**
	 * Compute the fees
	 * @return fees to pay
	 */
    protected abstract double computeFees();

    /**
     * Compute the management fees
     * @param userID userID to compute the management fees for
     */
    public final void computeManagementFees(final int userID) {
        final double feeAmount = computeFees();
        if (checkUser(userID) && isWithdrawAllowed(feeAmount)) {
            balance -= feeAmount;
            resetTransactions();
        }
    }

    /**
     * Deposit an amount to the userID bank account
     * @param userID userID of the bank account
     * @param amount amount to deposit
     */
    public final void deposit(final int userID, final double amount) {
        this.transactionOp(userID, amount);
    }

    /**
     * Deposit an amount to the userID bank account but from the ATM
     * @param userID userID of the bank account
     * @param amount amount to deposit
     */
    public final void depositFromATM(final int userID, final double amount) {
        this.deposit(userID, amount - SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

    /**
     * Get the current balance
     */
    public final double getBalance() {
        return this.balance;
    }

    /**
     * Get the current number of transactions
     */
    public final int getNTransactions() {
        return this.nTransactions;
    }

    /**
     * Increment the number of transactions
     */
    protected final void incTransactions() {
        this.nTransactions++;
    }

    /**
     * Check if withdraw is allowed
     * @param amount amount to withdraw
     * @return true if withdraw is allowed, false otherwise
     */
    protected abstract boolean isWithdrawAllowed(double amount);

    /**
     * Reset the number of transactions
     */
    protected final void resetTransactions() {
        this.nTransactions = 0;
    }

    /**
     * Set the balance to a <code>amount</code>
     * @param amount new current balance
     */
    protected final void setBalance(final double amount) {
        this.balance = amount;
    }

    /**
     * Execute an operation
     * @param userID userID used to perform the operation
     * @param amount amount used for the operation
     */
    private void transactionOp(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
            this.incTransactions();
        }
    }

    /**
     * Withdraw from <code>userID</code> bank account <code>amount</code>
     * @param userID userID of the bank account
     * @param amount amount to withdraw
     */
    public final void withdraw(final int userID, final double amount) {
        if (isWithdrawAllowed(amount)) {
            this.transactionOp(userID, -amount);
        }
    }

    /**
     * Withdraw from <code>userID</code> bank account <code>amount</code>, but from the ATM
     * @param userID userID of the bank account
     * @param amount amount to withdraw
     */
    public final void withdrawFromATM(final int userID, final double amount) {
        this.withdraw(userID, amount + SimpleBankAccount.ATM_TRANSACTION_FEE);
    }

}
