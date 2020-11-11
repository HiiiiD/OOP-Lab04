package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount {
	
	
	public ClassicBankAccount(int userID, double balance) {
		super(userID, balance);
	}

	@Override
	protected double computeFees() {
		return MANAGEMENT_FEE;
	}


	@Override
	protected boolean isWithdrawAllowed(double amount) {
		return true;
	}

}
