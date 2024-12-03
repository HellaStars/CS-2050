import java.io.*;
import java.util.*;

public class program5 {
	static stack accountStack = new stack();
	static stack checkingStack = new stack();
	static stack savingsStack = new stack();

	public static void main(String[] args) throws Exception {
		//reads the account Numbers
		ArrayList<String>values = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("accountNumbers.txt"));;
		String bValues = br.readLine();
		String Month = "03";

		while (bValues != null) {
			values.add(bValues);
			bValues = br.readLine();
		}
		br.close();
		String[]accountNum = new String[values.size()];
		values.toArray(accountNum);
	//turns the numbers into a usable string array
		
	//populates the stack
		for (int i = 0; i != accountNum.length; i++) {
			System.out.println(accountNum.length);
			System.out.println(checkingStack.length());
			System.out.println(i);
			System.out.println();
			ACCOUNT account = new ACCOUNT();
			savingsAccount savings = new savingsAccount();
			checkingAccount checking = new checkingAccount();
			account.setAccount("41-"+accountNum[i]);
			savings.setSavingsAccount(Month);
			checking.setCheckingAccount();
			accountStack.push(account);
			checkingStack.push(checking);
			savingsStack.push(savings);
		}
	//write the files (generic write)
		write(accountStack, "accountStack.out");
		write(savingsStack, "savingsStack.out");
		write(checkingStack, "checkingStack.out");
	//a series of or statements to make sure they're ALL stacks are empty
		while (!accountStack.isEmpty() && !savingsStack.isEmpty() && !checkingStack.isEmpty()) {
			System.out.println(checkingStack.length());
			//intizaliaze the needed objects and String
			String allInfo;
			ACCOUNT account = new ACCOUNT();
			savingsAccount savings = new savingsAccount();
			checkingAccount checking = new checkingAccount();
			//populates the data (ie checking) with the values in the stack
			account = (ACCOUNT) accountStack.pop();
			checking = (checkingAccount) checkingStack.pop();
			savings = (savingsAccount) savingsStack.pop();
			//formats all the info
			allInfo = String.format("Your account number is: %s %nYour checking balance is: %.2f %nYour savings balance is: %.2f %n",
					account.getAccountNum(),checking.getMoney(), savings.getMoney());
			//prints the value
			System.out.println(allInfo);
		}
		
	} 
	
public static void write(Object obj, String fName) { //writes all the infomation
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fName))) { 
			oos.writeObject(obj);
		}catch (Exception e) {
		}
	}

}
