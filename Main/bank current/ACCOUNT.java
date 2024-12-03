import java.io.*;

public class ACCOUNT implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String aNum; // account number
	protected String iNum; //identifier number
	protected String bNum; // department number - ze bank of pAsta shall use 41
	//protected accountLookup accountLookup = new accountLookup();
	//protected stack stack;
	//public int accountNumber = 0;
	protected int hashNum;
	//ArrayList<ACCOUNT> Array = new ArrayList<ACCOUNT>();

	ACCOUNT(){

	}

	public void setAccount(String Account_Num) throws Exception {
	    this.aNum = Account_Num;
	    //this.Array = new ArrayList<ACCOUNT>(ACCOUNT);
	    calcAccount();
	}
	
	private void calcAccount() {
		String[] AccountParts = aNum.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
	    bNum = AccountParts[0]; // bank num
	    iNum = AccountParts[2]; // 1 = - and 2 is the rest of the num
	    //accountNumber = Integer.parseInt(iNum); //makes it an int 
	}
	
	public String getAccountNum() {
		return(iNum);
	}
}

/*	public String getAccountInfo() throws Exception{
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
	*/

/*TODO
 * 1. Savings account method saves time, and calculates your monthly intrest payment 
 * 2. checking should be easy and bare bones. Only needs the ability to check money 
 * 3. make a file full of 4 constant socials
 * 4. account lookup file full of 998 accounts (999 possible numbers, -1 bc 000 should not be a real one)
 * NON_VITAL
 * 5.
 */