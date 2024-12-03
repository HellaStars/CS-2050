import java.io.Serializable;

public class customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private ACCOUNT account = new ACCOUNT();
	private String Name;
	
	customer(){
		
	}
	
	public void setCustomer(String na, String AccountNum) throws Exception {
		this.Name = na;
		account.setAccount("41-"+AccountNum);
	}
	
	public String CustomerID() {
		return account.getAccountNum();
	}
	public String getName() {
		return Name;
	}
	
}
