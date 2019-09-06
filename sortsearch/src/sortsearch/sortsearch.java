package sortsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class sortsearch {

	//=======
	//SEACHES
	//=======
	public static boolean binSearch(String[] Data, String Target) {
		int cut = Data.length / 2;
				
		if(Data.length==0) {
			return false;
		}
		
		if(Data[cut]==Target) {
			return true;
		}
				
		String[][] newData = split(Data, cut);

		if(Data[cut].compareTo(Target) > 0) {        //Data[cut] > Target
			return binSearch(newData[0], Target);
		} else { //Data[cut] < Target 
			return binSearch(newData[1], Target);
		}
	}
	
	public static int linearSearch(String[] Data, String Target) {
		int index = -1;
		for(int i=0; i<Data.length; i++) {
			if (Data[i]==Target) {
				index = i;
				break;
			}
		}
		return index;	
	}

	//=======
	//  MSIC
	//=======

	private static String[] swap(int indexA, int indexB, String[] Data) {
		String temp = Data[indexA];
		Data[indexA] = Data[indexB];
		Data[indexB] = temp;
		return Data;
	}
	
	private static String[][] split(String[] Data, int index) {
		int a = 0;
		String[] one = new String[index];
		String[] two = new String[Data.length - index - 1]; // index is removed
		for(int i = 0; i<Data.length; i++) {
			if(i<index) {
				one[i] = Data[i];
			} else {
				if(i>index) {
					two[a] = Data[i];					
					a++;
				}
			}			
		}
		String[][] output = new String[2][];
		output[0]=one;
		output[1]=two;
		return output;
	}
		
	public static String[] randomAlphaString(int n) {
		String[] alpha = "abcdefghijklmnopqrstuvwxyz".split("");
		Random rand = new Random();
		String[] out = new String[n];
		for(int i = 0; i < n; i++) {
			out[i] = alpha[Math.abs(rand.nextInt()%26)] + 
					 alpha[Math.abs(rand.nextInt()%26)] +
					 alpha[Math.abs(rand.nextInt()%26)] +
					 alpha[Math.abs(rand.nextInt()%26)] +
					 alpha[Math.abs(rand.nextInt()%26)];
			
		}
		return out;
	}
		
	private static String[] listToArray(List<String> list) {
		String[] Data = new String[list.size()];
		int i = 0;
		
		for(String temp : list) {
			Data[i] = temp;
			i++;
		}
		return Data;
	}
	
	private static List<String> arrayToList(String[] array) {
		List<String> Data = new ArrayList<String>();
		
		for(String temp : array) {
			Data.add(temp);
		}
		return Data;
	}
	
	private static String[] shuffleArray(String[] Data, int location) {
		String[] output = new String[Data.length];
		
		for(int i = 0; i< location; i++) {
			output[i] = Data[i];
		}

		for(int i = location; i< Data.length - 1; i++) {
			output[i+1] = Data[i];
		}
		
		
		return output;
	}
	
	//=======
	// SORTS
	//=======
	
	//ascending order
	public static String[] bubbleSort(String[] Data) {
		boolean finished = false;
		while(!finished) {
			finished = true;
			for(int i = 0; i<Data.length ; i++) {
				for(int j = 0;j<Data.length; j++) {
					if(Data[i].compareTo(Data[j]) >= 0 && i < j) {
						Data = swap(i, j, Data);
						finished = false;
					}
				}
			}
		}
		return Data;
	}

	//ascending order
	public static String[] insertionSort(String[] Data) {
		String[] output = new String[Data.length];
		
		output[0] = Data[0]; //need an item to compare to.
		
		for(int i = 1; i< Data.length; i++) {
			for(int j = 0; j<i ;j++) {
				if(Data[i].compareTo(output[j])<=0) {
					output = shuffleArray(output, i);
					output[i] = Data[i];
					break;
				}
				if(j+1==i) {
					output[j+1]=Data[i];
				}
			}
		}
		
		return output;
	}
	
	//ascending order
	public static List<String> quickSort(List<String> Data) {
		List<String> a = new ArrayList<String>();
		List<String> b = new ArrayList<String>();
		int Pivot = Data.size() / 2;
		
		if(Data.size() <= 1) {
			return Data;
		}	
		
		for(int i = 0; i<Data.size(); i++) {			
			if(i!=Pivot) {
				if(Data.get(i).compareTo(Data.get(Pivot))<0) {
					a.add(Data.get(i));
				} else {
					b.add(Data.get(i));
				}
			} 
		}
		
		a = quickSort(a);		
		b = quickSort(b);
		
		//merge
		a.add(Data.get(Pivot));
		a.addAll(b);	
	
		return a;
	}
	
	//======
	// MAIN
	//======
	
	public static void main(String[] args) {	
		long tempTime;		
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File (System.currentTimeMillis()+".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("|	n |	Bubble Sort Time (ms)	| Insertion Sort Time (ms)	| Quick Sort Time (ms)	|\n");
		
		pw.println("|	n  |	Bubble Sort Time (ms)	| Insertion Sort Time (ms)	| Quick Sort Time (ms)	|\n");
		
		
		long quickSortTime;
		long insertionSortTime;
		long bubbleSortTime;	
		for(int n = 250; n<=1000000 ; n+=250) {
			String[] strs = new String[n];
			strs = randomAlphaString(n);
			
			System.out.print("|	"+n+"| ");
			
			//bubble sort
			tempTime = System.currentTimeMillis();
			bubbleSort(strs);
			bubbleSortTime = System.currentTimeMillis() - tempTime;
			System.out.print("		 	"+bubbleSortTime+"	| ");
			pw.print("		 	"+bubbleSortTime+"	| ");
			//insertion sort
			tempTime = System.currentTimeMillis();
			insertionSort(strs);
			insertionSortTime = System.currentTimeMillis() - tempTime;
			System.out.print("		 	"+insertionSortTime+"	| ");
			pw.print(" 	"+insertionSortTime+"	| ");
			//quick sort
			tempTime = System.currentTimeMillis();
			quickSort(arrayToList(strs));
			quickSortTime = System.currentTimeMillis() - tempTime;
			System.out.print("	 	"+quickSortTime+"	|\n");
			pw.print("		 	"+quickSortTime+"	|\n");
			
		}
		
		pw.close();
	}
	
}
