package it.unibo.oop.lab04.bank;

public class ExtendedStrictBankAccount extends SimpleBankAccount {

	private static final double TRANSACTION_FEE = 0.1;
	
	
	public ExtendedStrictBankAccount(final int usrID, final double balance) {
		super(usrID, balance);
	}
	
	@Override
	public void computeManagementFees(final int userID) {
		final double feeAmount = MANAGEMENT_FEE + (this.getNTransactions() * TRANSACTION_FEE);
		if (checkUser(userID) && isWithdrawAllowed(feeAmount)) {
			this.setBalance(this.getBalance() - feeAmount);
            this.resetTransactions();
        }
	}
	
	private boolean isWithdrawAllowed(final double amount) {
        return this.getBalance() >= amount;
    }
	
	@Override
	public void withdraw(final int userID, final double amount) {
		if (isWithdrawAllowed(amount)) {
			super.withdraw(userID, amount);
		}
	}
	
}
