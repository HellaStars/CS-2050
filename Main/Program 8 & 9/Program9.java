import java.io.*;
import java.util.ArrayList;

public class Program9 {

	public class Program8 { //big_m.txt sorter By Asta Walor-Scott
		static ArrayList<Long> timeMerge = new ArrayList<Long>(); //these honestly could be an array lol
		static ArrayList<Long> timeQuick = new ArrayList<Long>();
		static ArrayList<Long> timeShell = new ArrayList<Long>();

			public static void main(String[] args) {
				ArrayList<Double>values = new ArrayList<Double>();
				String filePoint;
				String fileWrite = "";

				for(int i = 1; i <= 1 && values.isEmpty(); i++){
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
					shellSort(values);
					quickSort(values, 0, values.size()-1);
					MergeSort(values, 0, values.size()-1);
					values.removeAll(values);
				}
				/*for (int i = 0; i <= timeBubble.size() -1; i++) { // bubble is not used for big5m
					
					fileWrite = fileWrite + "\n" + Long.toString(timeBubble.get(i));
					filePoint = "BubbleSortTime4.txt";
					if (i == timeBubble.size()-1){
						write(fileWrite, filePoint);
					}
				}
				fileWrite = "";
				for (int i = 0; i <= timeInsertion.size() -1; i++) {
					fileWrite = fileWrite + "\n" + Long.toString(timeInsertion.get(i));
					filePoint = "InsertionSortTime4.txt";
					if (i == timeInsertion.size()-1){
						write(fileWrite, filePoint);
					}
				}
				fileWrite = "";
				for (int i = 0; i <= timeSelection.size()-1; i++) {
					fileWrite = fileWrite + "\n" + Long.toString(timeSelection.get(i));
					filePoint = "SelectionSortTime4.txt";
					if (i == timeSelection.size()-1){
						write(fileWrite, filePoint);
					}*/
				}

			
			
			static void shellSort(ArrayList<Double>values) {
				long shellTime = timer();
				int length = values.size();
				
				for (int gap = length / 2; gap > 0; gap /= 2) {
					for (int i = gap; i < length; i++) {
						double valuesT = values.get(i); 
						System.out.println(values.get(i));
						int temp;
						 for (temp = i; temp >= gap && values.get(temp - gap) > valuesT; temp -= gap) {
							 values.set(temp, values.get(temp - gap));
							 System.out.println(values.get(temp));
							 values.set(temp, valuesT);
							 System.out.println(values.get(temp));
						 }
					}
				}
				shellTime = shellTime - timer();
				timeShell.add(shellTime);
			}
			static void quickSort(ArrayList<Double>values, int low, int	 high) {
				
			        double pivot = values.get(high); 
			        int i = (low-1);
			        for (int test = low; test < high; test++) {
			            if (values.get(test) <= pivot){
			                i++;

			                double temp = values.get(i);
			                values.set(i, values.get(test));
			                values.set(test, temp);
			            }
			        }
			        double temp = values.get(i - 1);
			        values.set(i + 1, values.get(high));
			        values.set(high, temp);
			        
			        if (low < high){

			            // Recursively sort elements before
			            // partition and after partition
			        	quickSort(values, low, high-1);
			        	quickSort(values, low - 1, high);
			        }
			}
		    static void MergeSort(ArrayList<Double>values, int low, int high){
		        if (low < high) {
		          
		            int merge = (low + high) / 2;

		            // Sort first and second halves
		            MergeSort(values, low, merge);
		            MergeSort(values, merge + 1, high);

		            // Merge the sorted halves
		            merge(values, low, merge, high);
		        }
		    }
			static void merge(ArrayList<Double>values, int low, int merge, int high){

		          int n1 = merge - low + 1;
		        int n2 = high - merge;

		        ArrayList<Double>bValues = new ArrayList<Double>();
		        ArrayList<Double>cValues = new ArrayList<Double>();
		        int L[] = new int[n1];
		        int R[] = new int[n2];

		        for (int i = 0; i < n1; ++i)
		        	bValues.add(i, values.get(low+i));

		          for (int j = 0; j < n2; ++j)
		        	  values.add(j, values.get(merge + 1 + j));

		        // Merge the temp arrays
		        // Initial indexes of first and second subarrays
		        int i = 0, j = 0;

		        int k = low;
		        while (i < n1 && j < n2) {
		            if (L[i] <= R[j]) {
		            	values.set(k, bValues.get(i));
		                i++;
		            }
		            else {
		            	values.set(k, cValues.get(j));
		                j++;
		            }
		            k++;
		        }

		        while (i < n1) {
		        	values.set(k, bValues.get(i));
		            i++;
		            k++;
		        }

		        while (j < n2) {
		        	values.set(k, cValues.get(j));
		            j++;
		            k++;
		        }
		    }
			
			
			static long timer() {
				long time = System.nanoTime();
				time = time/1000;
				
				return time;
			}
			static void write(String seconds, String fName) { //writes all the infomation
				try (PrintWriter out = new PrintWriter(fName);) { 
					out.write(seconds);
				}catch (Exception e) {
				}
			}
	}
}

