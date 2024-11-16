import java.io.*;
import java.util.ArrayList;

public class program10 { //Program 10 by Asta Walor-Scott. Reads dracula, takes out special characters,  
	public static void main(String[] args) { //takes out spaces, and splits it at each word. Addig to both an AVL tree, and a LinkedList
		ArrayList<String>dracula = new ArrayList<String>();
		ArrayList<String>temp = new ArrayList<String>();
		AVLtree tree = new AVLtree();
		linkList list = new linkList();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\dracula.txt"));
			String readLine;

			while ((readLine = br.readLine()) !=null) {
				readLine = readLine.toLowerCase();
				readLine = readLine.replaceAll("[[0-9]!@#%$^&*()_+=[]{}|;:\",./<>?~``]]", "");
				readLine = readLine.replaceAll("^[\n\r]", "");
				readLine = readLine.replaceAll("-", "");
				String []lineArray = readLine.split(" ");
				System.out.println(readLine);
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
		ArrayList <String> info = new ArrayList<String>();
		for (int i = 0; i<= dracula.size()-1; i++) {
		list = list.insert(list, dracula.get(i));
		}
		info = list.printFiltered('q',list);
		for (int i = 0; i <= info.size()- 1; i++) {
			System.out.println(info.get(i));
		}
		for (int i = 0; i<= dracula.size()-1; i++) { //AVL tree work in progress
			tree.root = tree.Insert(tree.root, dracula.get(i));

		}
		info.removeAll(info);
		System.out.println();
		info = tree.Search('q');
		for (int i = 0; i <= tree.height(tree.root); i++) {
			System.out.println(info.get(i));
		}
	tree.postOrder(tree.root);
		
	}
}