import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class accountLookup {
	accountLookup(){}
	// will use stack (array list)
	protected boolean validAccount = false;

	public void setAccount(String accountNum) throws Exception {
		accountCheck(accountNum);
	}
	private void accountCheck(String accountNum) throws IOException{
		List<String>values = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("accountNumbers.txt"));;
		String bValues = br.readLine();

		while (bValues != null) {
			values.add(bValues);
			bValues = br.readLine();
		}
		br.close();
			Object []cValues = values.toArray();
			
			int i = 0;
		while (i < cValues.length) {
			if (cValues[i].equals(accountNum)) {
				validAccount = true;
			} 
			i++;
		}
	}
	
	public boolean accountValid() {
		return(validAccount);
	}
}
