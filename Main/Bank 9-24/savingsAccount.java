import java.time.*; // this is gonna suck
import java.time.format.DateTimeFormatter;
public class savingsAccount extends ACCOUNT {
	
	protected double money = Math.pow((Math.random()* 10), (Math.random()* 10));

	savingsAccount(){}

	public void savingsAcc(String lMonth) throws Exception {
		savingsCalc(lMonth);
	}


	private void savingsCalc(String lastMonth) { 
		// for right now due to wanitng the money to be saved in a .obj the money will just be randomized each time.
		//also until I can write the month to an object file (soon >:3)

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


