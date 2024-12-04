import java.io.*;
import java.util.ArrayList;
public class Program11 {
	
	//Program 10 by Asta Walor-Scott. Reads dracula, takes out special characters,  
		public static void main(String[] args) { //takes out spaces, and splits it at each word. Adding to both to a seperate hashes
			ArrayList<String>dracula = new ArrayList<String>();
			ArrayList<String>temp = new ArrayList<String>();
			ArrayList<String> info = new ArrayList<String>();
			ArrayList<Integer> infoInt = new ArrayList<Integer>();
			moduloHash modulo = new moduloHash();
			String file = "";
			linkList list = new linkList();

			try {
				BufferedReader br = new BufferedReader(new FileReader("dracula.txt"));
				String readLine;

				while ((readLine = br.readLine()) !=null) {
					readLine = readLine.toLowerCase();
					readLine = readLine.replaceAll("[[0-9]!@#%$^&*()_+=[]{}|;:\",./<>?~``]]", " ");
					readLine = readLine.replaceAll("^[\n\r]", " ");
					readLine = readLine.replaceAll("-", " ");
					String []lineArray = readLine.split(" ");
					//System.out.println(readLine);
					for (int i = 0; i <= lineArray.length - 1; i++) {
						if (lineArray[i].compareTo(" ") == 0) {}//if it results in a space just does nothing
						else {
							dracula.add(lineArray[i]);
						}
					}
				}
				br.close();
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
			for (String line : dracula){ 
				if (!line.trim().equals("")) temp.add(line);
			}
			dracula = temp;
			
			for (int i = 0; i < dracula.size(); i++) { //make the list
				list = list.insert(list, dracula.get(i));
			}
			info = list.printList(list);
			infoInt = list.intFilter(infoInt, list);
			String[] Strings = new String[info.size()];
			Integer[] Keys = new Integer[info.size()];
			for (int i = 0; i < info.size(); i++) {
				//System.out.println(info.size() + " " + infoInt.size());
			modulo.setHash(info.get(i), infoInt.get(i));
			}
			System.out.println(modulo.getTable());
			System.out.println(modulo.getClash());
			System.out.println(modulo.getLoadFactor());
		}
}
