public class checkingAccount extends ACCOUNT   {
	private static final long serialVersionUID = 1L;
	protected boolean valid = false;
	protected double randomPow;
	protected double money;
	protected int position;
	//ArrayList<checkingAccount> Array;

	checkingAccount(){}

	public void setCheckingAccount() throws Exception {
		//this.Array = checking;
		calcMoney();
	}

	private void calcMoney(){ // for right now due to wanitng the money to be saved in a .obj the money will just be randomized each time.

			randomPow =(Math.random()* 10);
			money = (Math.random()* 10);
			money = Math.pow(randomPow, money);
	}
	public double getMoney() {
		return(money);
	}
}
