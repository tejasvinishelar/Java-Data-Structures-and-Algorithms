import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CS6083BShelar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length;

		int[] primeNumbers;
		int[] hibbardSeq;
		int[] powerOfTwo;

		myInfo();

		List<Integer> unsortedInputList;
		long startTime,endTime;

		//Read Elements from file
		unsortedInputList = readUnsortedListFromFile();
		length = unsortedInputList.size();

		int[] primeNumberSortArray = new int[1000];
		int[] hibbardSeqSortArray = new int[1000];
		int[] powerOfTwoSortArray = new int[1000];
		int[] sortedList = new int[1000];

		//Convert List to array
		Integer[] arrayClass = new Integer[unsortedInputList.size()]; 
		arrayClass = unsortedInputList.toArray(arrayClass);
		int[] seqArray = Arrays.stream(arrayClass).mapToInt(Integer::intValue).toArray();
		primeNumberSortArray = seqArray.clone();
		hibbardSeqSortArray = seqArray.clone();
		powerOfTwoSortArray = seqArray.clone();


		//Get Gap Sequence
		primeNumbers = getPrimeSeries();
		hibbardSeq = getHibbardSeq(); 
		powerOfTwo = getPowerOfTwoSeq();

		//**** Sorting using PrimeSeries
		startTime = System.nanoTime();
		primeNumberSortArray=shellSort(primeNumberSortArray,primeNumbers);
		endTime = System.nanoTime();
		System.out.println("\nTime taken for Prime Number Sequence Shell Sort : "+(endTime-startTime));

		//**** Sorting using HibbardSeq
		startTime = System.nanoTime();
		sortedList=shellSort(hibbardSeqSortArray,hibbardSeq);
		endTime = System.nanoTime();
		System.out.println("\nTime taken for Hibbard Sequence Shell Sort : "+(endTime-startTime));


		//**** Sorting using Power of Two
		startTime = System.nanoTime();
		sortedList=shellSort(powerOfTwoSortArray,powerOfTwo);
		endTime = System.nanoTime();
		System.out.println("\nTime taken for Power of Two Sequence Shell Sort : "+(endTime-startTime));


		//**** Use sort() function
		startTime = System.nanoTime();
		Collections.sort(unsortedInputList); 
		endTime = System.nanoTime();
		System.out.println("\nTime taken for sort() function : "+(endTime-startTime));
		System.out.println("\n\nResult is same for each sequence function :\t"+unsortedInputList.get(100)+"\t"+unsortedInputList.get(125)+"\t"+unsortedInputList.get(250)+"\t"+unsortedInputList.get(700)+"\t"+unsortedInputList.get(900));


	}		//End of main()

	public static int[] shellSort(int sortList[], int gaps[])
	{
		int gap;
		for (int k = 0; k < gaps.length; k++)
		{
			gap = gaps[k];
			for (int i = gap; i < gaps.length; i++) 
			{
				int temp = sortList[i];
				int j;
				for (j = i;j >= gap && sortList[j - gap] > temp; j=j-gap) 
				{
					sortList[j] = sortList[j - gap];
				}
				sortList[j] = temp;
			}
		}
		return sortList;
	}

	private static int[] getPowerOfTwoSeq() {
		// TODO Auto-generated method stub
		ArrayList<Integer> gapSequence = new ArrayList<Integer>();

		int temp = 0;
		for (int i = 0; temp < 500; i++ ) 
		{
			temp = (int)(java.lang.Math.pow(2,i));	
			gapSequence.add(temp);
		}
		int[] powerofTwoSequence = new int[gapSequence.size()];
		int index = gapSequence.size()-1; 
		for(int i : gapSequence)
		{	
			powerofTwoSequence[index--] = i;
		}
		return powerofTwoSequence;
	
	}

	private static int[] getHibbardSeq() {
		// TODO Auto-generated method stub
		ArrayList<Integer> gapSequence = new ArrayList<Integer>();
		int temp = 0;
		for (int i = 1; temp < 500 && i<1000 ; i++ ) 
		{
			temp = (int)(java.lang.Math.pow(2,i));	
			gapSequence.add(temp-1);
		}
		int[] hibSequence = new int[gapSequence.size()];
		for(int i=0;i< gapSequence.size();i++)
		{	
			hibSequence[i] = gapSequence.get(i);
		}
		return hibSequence;
	}

	private static int[] getPrimeSeries() {
		// TODO Auto-generated method stub
		ArrayList<Integer> gapSequence = new ArrayList<Integer>();

		for(int i=1; i < 500; i++)
		{
			boolean isPrime = true;
			for(int j=2; j < i ; j++)
			{
				if(i % j == 0)
				{
					isPrime = false;
					break;
				}
			}
			if(isPrime)
			{
				gapSequence.add(i);
			}	   
		}
	
		int[] primeSequence = new int[gapSequence.size()];
		int index = gapSequence.size()-1;
		for(int i : gapSequence)
		{	
			primeSequence[index--] = i;
		}
		return primeSequence;
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

			FileInputStream istream = new FileInputStream("inputData3B.txt");
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
