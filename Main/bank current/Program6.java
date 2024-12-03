import java.io.*; // by Asta Walor-Scott bank customer program using a circular queue
import java.util.*;

public class Program6 {
	static stack checkingStack = new stack();
	static stack savingsStack = new stack();

	public static void main(String[] args) throws Exception {
		//reads the account Numbers
		ArrayList<String>values = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("accountNumbers.txt"));;
		String bValues = br.readLine();
		String names[] = new String[25];//ommmgggg 
		names = Names(); 
		
		String Month = "03";

		while (bValues != null) {
			values.add(bValues);
			bValues = br.readLine();
		}
		br.close();
		String[]accountNum = new String[values.size()];
		values.toArray(accountNum);
		queue queue = new queue(accountNum.length);
	//turns the numbers into a usable string array
		
	//populates the stack
		for (int i = 0; i != accountNum.length;) {
			customer customer = new customer();
			System.out.println(names.length);
			System.out.println(i);
			System.out.println(accountNum.length);
			customer.setCustomer(names[i], accountNum[i]);
			savingsAccount savings = new savingsAccount();
			checkingAccount checking = new checkingAccount();
			queue.enQueue(customer);
			savings.setSavingsAccount(Month);
			checking.setCheckingAccount();
			checkingStack.push(checking);
			savingsStack.push(savings);
			i++;
		}
	//write the files (generic write)
		write(queue, "queue.out");
		write(savingsStack, "savingsStack.out");
		write(checkingStack, "checkingStack.out");
	//a series of or statements to make sure they're ALL stacks are empty
		for (int i=0; !queue.ISempty(); i++) {
			//intizaliaze the needed objects and String
			customer customer = new customer();
			customer = (customer) queue.deQueue();
			System.out.println(customer.CustomerID());
			System.out.println(" "+customer.getName());	
			
		}
		
	} 
	
static void write(Object obj, String fName) { //writes all the infomation
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fName))) { 
			oos.writeObject(obj);
		}catch (Exception e) {
		}
	}
static String[] Names(){
	String[] names = { "John Doe", "Milton stewart", "is This thing working?", "it appears to be caught", "Ash Ketchum", "Asta Walor-Scott",
			"Kilo Ren", "Spock don't know his last name", "John fortnite", "sussy baka", "Baha Blast", "Gucci", "How many 'names' do I need? 25", "I was sitting on the bench", 
			"benji", "Lucifer", "Java", "sam", "bobbert", "gumball", "3.14159", "are you smarter than a 5th grader", "I am wirting a name",
			"Almost done","DONE!"};
	
	
		return(names);
	}
}
