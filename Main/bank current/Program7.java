import java.io.*; // by Asta Walor-Scott bank program-program 7
import java.util.*;

public class Program7 {
	static stack checkingStack = new stack();
	static stack savingsStack = new stack();

	public static void main(String[] args) throws Exception {
		String Month = "03";
		int check = 0;
		//files for stack and queue
		stack savingsStack;
		stack checkingStack;
		queue queue;
		Scanner scanner = new Scanner(System.in);
		ArrayList<savingsAccount> savings = new ArrayList<savingsAccount>();
		ArrayList<checkingAccount> checking = new ArrayList<checkingAccount>();

		//grab the object files for checking, customer, and savings FileInputReader
		//customer/ queue
		FileInputStream fileStream = new FileInputStream("queue.out");
		try (ObjectInputStream objStream = new ObjectInputStream(fileStream)) {
			queue = (queue) objStream.readObject();
		}
		//checking/ stack
		FileInputStream fileStreamB = new FileInputStream("checkingStack.out");
		try (ObjectInputStream objStreamB = new ObjectInputStream(fileStreamB)) {
			checkingStack = (stack) objStreamB.readObject();
		}
		//savings/ stack
		FileInputStream fileStreamC = new FileInputStream("savingsStack.out");
		try (ObjectInputStream objStreamC = new ObjectInputStream(fileStreamC)) {
			savingsStack = (stack) objStreamC.readObject();
		}

		while(queue.Size() != 30) { // if the queue size is not 30 will ask for your name, and populate customer with said name, and a random number (that is turned into a String)
			String Number = randAccountNum();
			customer cus = new customer();

			while (check == queue.Size()) { //sets the name, makes a new customer
				System.out.println("You don't have an account with us, please input a name and we will assign the next nearest account number:\n");
				String name = scanner.nextLine();
				
				customer CUSTOMER = new customer();
				CUSTOMER.setCustomer(name, Number);
				queue.enQueue(CUSTOMER);
				check = 0;
				System.out.println(queue.Size());
				System.out.println();
			}
			while (check != queue.Size()) {
					check++;
					cus = (customer) queue.deQueue();
					System.out.println(queue.Size());
					System.out.println();
				while (Number.equals(cus.CustomerID())){
					Number = randAccountNum();
					check = 0;
				}
			}

		}
		
		for (int i = 0; savingsStack.length() != queue.Size()+2 && checkingStack.length() != queue.Size()+2 && i != queue.Size() +2; i++) {
// for whatever reason I need too add 2 to each one to ensure it works right. 
			if(!savingsStack.isEmpty() && !checkingStack.isEmpty()) { // unpacks the stack into an arrayList
				savings.add(i, (savingsAccount) savingsStack.pop());
				checking.add(i, (checkingAccount) checkingStack.pop());
			}else { // if the stack is empty starts makes a new customer until it hits the treshhold
				savingsAccount SA = new savingsAccount();
				checkingAccount CA = new checkingAccount();
				SA.setSavingsAccount(Month);
				CA.setCheckingAccount();
				savings.add(i, SA);
				checking.add(i, CA);
				}

		}
			for (int d = savings.size()-1; d>= 0; d--) { // restacks
				checkingStack.push(checking.get(d));
				savingsStack.push(savings.get(d));
				
			}

		write (savingsStack, "savingsStack.out");
		write (checkingStack, "checkingStack.out");
		write(queue, "queue.out");
		

		for (int i = 0; i <= queue.Size(); i++) { // prints out all the info
			customer customer = new customer();//intizaliaze the needed objects and String
			String allInfo;
			savingsAccount SA = new savingsAccount();
			checkingAccount CA = new checkingAccount();
			SA = (savingsAccount) savingsStack.pop();
			CA = (checkingAccount) checkingStack.pop();
			customer = (customer) queue.deQueue();
			
			allInfo = String.format("Your account number is: %s %nYour checking balance is: %.2f %nYour savings balance is: %.2f %n",
					customer.CustomerID(),CA.getMoney(), SA.getMoney());
			System.out.println("HELLO! " + customer.getName());
			System.out.println(allInfo);

		}


		//gets user input - max 30 spots
		//generates the customer ID
		//checks if customer has an account
		//if the customer does find the account in Stack
		//if the customer doesn't generates the money and add it too the stack
		//add/ subtract the money from checking and savings each round

		/*
		 * write(queue, "queue.out");
		 * write(savingsStack, "savingsStack.out");
		 * write(checkingStack, "checkingStack.out");
		 */

	} 

	static void write(Object obj, String fName) { //writes all the infomation
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fName))) { 
			oos.writeObject(obj);
		}catch (Exception e) {
		}
	}
	static String randAccountNum() {
		String Num;
		int a = (int)(Math.random()*10 -1);
		int b = (int)(Math.random()*10 -1);
		int c = (int)(Math.random()*10 -1);
		Num = Integer.toString(a)+ Integer.toString(b) + Integer.toString(c);

		return Num;

	}
}
