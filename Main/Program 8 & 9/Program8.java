import java.io.*;
import java.util.ArrayList;

public class Program8 { //big_m.txt sorter By Asta Walor-Scott
	static ArrayList<Long> timeInsertion = new ArrayList<Long>(); //these honestly could be an array lol
	static ArrayList<Long> timeSelection = new ArrayList<Long>();
	static ArrayList<Long> timeBubble = new ArrayList<Long>();

	public static void main(String[] args) {
		ArrayList<Double>values = new ArrayList<Double>();
		String filePoint;
		String fileWrite = null;

		for(int i = 1; i <= 5; i++){
			filePoint = "big"+ Integer.toString(i) + "m.txt";
			try {
				BufferedReader br = new BufferedReader(new FileReader(filePoint));
				String hValues;

				while ((hValues = br.readLine()) !=null) {
					values.add(Double.parseDouble(hValues));
				}
				br.close();
			}
			catch (Exception e) {
				System.out.println(e);
			}
			if ( i == 5) {
				insertionSort(values);
				selectionSort(values);
			} else {
				insertionSort(values);
				selectionSort(values);
				bubbleSort(values);
			}
			values.removeAll(values);
		}
		for (int i = 0; i <= timeBubble.size(); i++) { // bubble is not used for big5m
			fileWrite = fileWrite + "\n" + Long.toString(timeBubble.get(i));
			filePoint = "BubbleSortTime.txt";
			if (i == timeBubble.size()){
				write(fileWrite, filePoint);
			}
		}
		for (int i = 0; i <= timeInsertion.size(); i++) {
			fileWrite = fileWrite + "\n" + Long.toString(timeInsertion.get(i));
			filePoint = "InsertionSortTime.txt";
			if (i == timeInsertion.size()){
				write(fileWrite, filePoint);
			}
		}
		for (int i = 0; i <= timeSelection.size(); i++) {
			fileWrite = fileWrite + "\n" + Long.toString(timeSelection.get(i));
			filePoint = "SelectionSortTime.txt";
			if (i == timeSelection.size()){
				write(fileWrite, filePoint);
			}
		}

	}
	static void insertionSort(ArrayList<Double>values) {
		long selectionTime = timer();
		int legnth = values.size();
		
		for (int i = 1; i < legnth; ++i) {
			Double temp = values.get(i);
			int temp1 = i - 1;
			
			while (temp1 >= 0 && values.get(temp1) > temp) {
				values.set(temp1 + 1, values.get(temp1));
				temp1 = temp1 - 1;
			}
			values.set(temp1 + 1, temp);
		}
		
		
		selectionTime = selectionTime - timer();
		timeInsertion.add(selectionTime);
	}
	
	static void selectionSort(ArrayList<Double>values) {
		long selectionTime = timer();
		for (int i = 0; i < values.size() - 1; i++) {
			int min = i;
				for (int d = i; d < values.size(); d++) {
					if (values.get(d) < values.get(min)) {
						min = i;
					}
				}
				if (min != i) {
					Double temp = values.get(i);
					values.set(i, values.get(min));
					values.set(min, temp);
				}
		}
		selectionTime = selectionTime - timer();
		timeSelection.add(selectionTime);
	}
	
	static void bubbleSort(ArrayList<Double>values) {
		long selectionTime = timer();
		int length = values.size();
		for (int i = 0; i < length - 1; i++) {
			for (int d = 0; d < length - i - 1; d++) {
				if (values.get(d) > values.get(d + 1)) {
					Double temp = values.get(i);
					values.set(d, values.get(d + 1));
					values.set(d + 1, temp);
				}
			}
		}
		
		selectionTime = selectionTime - timer();
		timeBubble.add(selectionTime);
		
	}
	static long timer() {
		long time = System.nanoTime();
		time = time/1000000000;
		
		return time;
	}
	static void write(String seconds, String fName) { //writes all the infomation
		try (PrintWriter out = new PrintWriter(fName);) { 
			out.write(seconds);
		}catch (Exception e) {
		}
	}
}
