public class ACCOUNT {
	protected String aNum; // account number
	protected String iNum; //identifier number
	protected String dNum; // department number - ze bank of pAsta shall use 41
	
	//TODO make a object file with account numbers (001-025), has the social for each of those (random 4 digits).
	//another file obj file with account numbers used before and checking (and another for savings), account number determines what info to grab
	//It will have to parse out each value into seperate array lists to then parse that infomation into social, account, 

	protected accountLookup accountLookup = new accountLookup();
	protected checkingAccount checking;
	protected savingsAccount savings;

	ACCOUNT(){}

	public void setAccount(String Account_Num,checkingAccount checkingAcc, savingsAccount savingsAcc) throws Exception {
		this.aNum = Account_Num;
		this.checking = checkingAcc;
		this.savings = savingsAcc;
		
		String[] AccountParts = aNum.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		dNum = AccountParts[0];
		iNum = AccountParts[2];
		accountLookup.setAccount(iNum);
		parser();
	}
	
	private void parser() throws Exception {
		if (accountLookup.accountValid() == true) {
			checking.checkingAcc();
			savings.savingsAcc("03");
		}
	}

	public String getAccountInfo() throws Exception{
		String allInfo;
		if (accountLookup.accountValid() == true) {
		allInfo = String.format("Your account number is: %s %nYour checking balance is: %.2f %nYour savings balance is: %.2f %n",
		aNum,checking.getMoney(), savings.getMoney());
		return(allInfo);
		} else {
			allInfo = null;
			return(allInfo);
		}
	}
}

/*TODO
 * 1. Savings account method saves time, and calculates your monthly intrest payment 
 * 2. checking should be easy and bare bones. Only needs the ability to check money 
 * 3. make a file full of 4 constant socials
 * 4. account lookup file full of 998 accounts (999 possible numbers, -1 bc 000 should not be a real one)
 * NON_VITAL
 * 5.
 */