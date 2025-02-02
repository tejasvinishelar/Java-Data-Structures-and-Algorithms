import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CS60812BShelar {

	static int graph[][];
	static int size;
	static int totalPath;
	static int degree[];
	public static void main(String arg[]) throws FileNotFoundException {
		myInfo();
		degree=new int[15];
		graph=readFile("inputData12B.txt");
		size=graph[0].length;
		findDegreeOfEachNode();
		int odd= isEulerianPathAndCircuit();
		if(odd==2 || odd==0) {
			System.out.println("\n\nYes,Given Graph satisfies Eulerian path condition as\nIt contains exactly two or no verices with odd degree ");
		}
		else {
			System.out.println("\n\nNo,Given Graph does not satisfy Eulerian path condition as\nIt doesn't contains exactly two verices with odd degree \nas well as all even degree nodes ");
		}
		if(odd==0) {
			System.out.println("\n\nGiven Graph satisfies Eulerian Circuit condition as\nIt contains all nodes with even degree ");
		}else
			System.out.println("\n\nNo,Given Graph does not satisfy Eulerian Circuit condition as\nIt doesn't contains all even degree nodes ");
		
		
		if(isDiracTheorem()) 
			System.out.println("\n\nYes, It Satisfies Dirac Theorem : \n1-As there are more than 3 nodes\n 2- Every node degree is greater than n/3 ");
		else
			System.out.println("\n\nNo, It does not Satisfies Dirac Theorem : \n1-As there are either no more than 3 nodes or \n2- Not every node degree is greater than n/2  ");
		
		if(isOresTheorem())
			System.out.println("\n\nYes, It Satisfies Ore's Theorem : \nSum of degree of every non adjacent node is greater than or equal to "+graph[0].length);
		else
			System.out.println("\n\nNo, It does not Satisfies Ore's Theorem : \nAs Sum of degree of every non adjacent node is not greater than or equal to "+graph[0].length);
	}
	

	private static boolean isOresTheorem() {
		// TODO Auto-generated method stub
		int sum=20;
		boolean flag=true;
		for(int i=0;i<graph[0].length;i++) {
			for(int j=0;j<graph[0].length;j++) {
				if(graph[i][j]==0 && i!=j) {
					sum=degree[i]+degree[j];
				}
				if(sum<graph[0].length) {
					flag=false;
				}
			}
		}
		return flag;
	}

	private static boolean isDiracTheorem() {
		// TODO Auto-generated method stub
		int n=graph[0].length;
		Boolean dirac=true;
		for(int i: degree) {
			if(n<3 || i<n/2)
				dirac=false;
		}
		return dirac;
	}

	private static int isEulerianPathAndCircuit() {
		// TODO Auto-generated method stub
		int odd=0;
		for(int i : degree) {
			if(i%2==1)
				odd++;
		}
		return odd;
	}

	private static void findDegreeOfEachNode() {
		// TODO Auto-generated method stub
		int degre=0;
		for(int i=0;i<15;i++) {
			degre=0;
			for(int j=0;j<15;j++) {
				if(graph[i][j]>0)
					degre++;
			}
			degree[i]=degre;
		}
		
	}

	private static void myInfo() {
		// TODO Auto-generated method stub
		Date today = new Date();

		System.out.println("Name : Tejasvini Shelar");
		System.out.println("Course Number : CS1508 ");
		System.out.println("Date : "+today.toString());
	}

	private static int[][] readFile(String filename) throws FileNotFoundException {
		ArrayList<Integer> list=new ArrayList<>(); 
		int inputdata[][] = null,i=0;
		File f1 = new File(filename);
		if(!f1.exists())
			System.out.println("input file not found");

		Scanner sc = new Scanner(f1);
		inputdata = new int[15][15];
		while(sc.hasNextInt()) {
			for (i=0; i<15; i++) {
				for(int j=0; j<15; j++) {
					inputdata[i][j] = sc.nextInt();
				}
			}
		}
		return inputdata;
	}

}


