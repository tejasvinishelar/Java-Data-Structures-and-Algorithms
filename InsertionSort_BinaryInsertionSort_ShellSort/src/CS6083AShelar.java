import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CS6083AShelar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		myInfo();
		int i,j=0;
		List<Integer> unsortedInputList;
		
		unsortedInputList = readUnsortedListFromFile();
		
		//Convert List to array
		int[] unsortedList = new int[unsortedInputList.size()];
		for(i=0;i<unsortedInputList.size();i++) {
			unsortedList[i] = unsortedInputList.get(i);
		}
		
        for (i = 1; i<unsortedList.length; i++) 
        { 
            int keyInt = unsortedList[i]; 
            j = i-1; 
           
            while ( j >= 0 && unsortedList[j] > keyInt) 
            { 
            	unsortedList[j+1] = unsortedList[j]; 
                j = j-1; 
                
            } 
            unsortedList[j+1] = keyInt; 

        } 
        
		System.out.print("\n\nElements of Sorted List A[10] A[25] A[50] A[70] A[90] by Straight Insertion Sort : ");
		
		System.out.print(unsortedList[10]+" "+unsortedList[25]+" "+unsortedList[50]+" "+unsortedList[70]+" "+unsortedList[90]);

		//**** Sorting using sort() function on unsorted list
		Collections.sort(unsortedInputList); 	
		System.out.print("\n\nElements of Sorted List A[10] A[25] A[50] A[70] A[90] by sort() function : ");
		
		System.out.print(unsortedInputList.get(10)+" "+unsortedInputList.get(25)+" "+unsortedInputList.get(50)+" "+unsortedInputList.get(70)+" "+unsortedInputList.get(90));
		
	}

	private static void myInfo() {
		// TODO Auto-generated method stub
		Date today = new Date();
		System.out.println("Name : Tejasvini Shelar");
		System.out.println("Course Number : CS608 ");
		System.out.println("Date : "+today.toString());
	}

	//**** read file of integers and return list of unsorted elements
	static List<Integer> readUnsortedListFromFile() {
		List<Integer> unsortedList = new ArrayList<>();
		try {

			FileInputStream istream = new FileInputStream("C:\\Users\\TejasviniAditya\\Documents\\Java\\Assignment3\\src\\inputData3A.txt");
			Scanner input = new Scanner(istream);
			while(input.hasNextInt()) {
				unsortedList.add(input.nextInt());	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return unsortedList;
	}

}
