
public class checkingAccount extends ACCOUNT {
	protected boolean valid = false;
	
	//will take the account number (25 values), throws that into a list, 
	
	checkingAccount(){}
	
	public void checkingAcc() throws Exception { //I only need 
		calcMoney();
	}
	
	private double calcMoney(){ // for right now due to wanitng the money to be saved in a .obj the money will just be randomized each time.
		double randomPow =(Math.random()* 10);
		double money = (Math.random()* 10);
		money = Math.pow(randomPow, money);
		return(money);
	}
	
	public double getMoney() {
		
		return (calcMoney());
	}
	

}
