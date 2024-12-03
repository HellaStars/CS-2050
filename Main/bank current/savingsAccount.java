
import java.time.*; // this is gonna suck
import java.time.format.DateTimeFormatter;
public class savingsAccount extends ACCOUNT {
	private static final long serialVersionUID = 1L;
	
	protected double money = Math.pow((Math.random()* 10), (Math.random()* 10));
//	ArrayList<savingsAccount> Array;
	
	//make the stack for the savings (will take the hash to properly position??)

	savingsAccount(){}


	public void setSavingsAccount(String lastMonth) throws Exception {
		//this.Array = savings;
		savingsCalc(lastMonth);
	}

//bal, let account verify. 
	private void savingsCalc(String lastMonth) { 

		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter Format = DateTimeFormatter.ofPattern("mm");

		String todayMonth = date.format(Format);

		if (!todayMonth.equals(lastMonth)) {
			int tMonth =(Integer.parseInt(todayMonth));
			for (int i = Integer.parseInt(lastMonth); i<tMonth && i != 12; i++) {
				money = money / .45;
				
			}
		}
	}
	public double getMoney() {
		return(money);
	}
}


