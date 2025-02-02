import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CS60812AShelar {

	static int graph[][];
	static int size;
	static int totalPath;
	public static void main(String arg[]) throws FileNotFoundException {
		myInfo();
		graph=readFile("C:\\Users\\TejasviniAditya\\Documents\\Java\\MSTGraph\\src\\inputDataSample10.txt");
		size=graph[0].length;
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(graph[i][j]==0)graph[i][j]=Integer.MAX_VALUE;
			}
		}

		System.out.println("Prim's Algorithm to find MST : \n");
		primsAlgo();
		System.out.println("\n\nMST Path Sum : "+totalPath);
	}
	
	static void primsAlgo() {
		int ne;
		int min,x=0,y=0;
		boolean[] selected= new boolean[size];
		totalPath =0;
		//for(int i=0;i<size;i++) selected[i]=false;
		Arrays.fill(selected, false);
		selected[0]=true;
		ne=0;
		
		while(ne<size-1) {
			min=Integer.MAX_VALUE;
			for(int i=0;i<size;i++) {
				if(selected[i]) {
					for(int j=0;j<size;j++) {
						
						if(!selected[j]) {
							if(min>graph[i][j]) {
								min=graph[i][j];
								x=i;
								y=j;
							}
						}
					}
				}
			}
			selected[y]=true;
			System.out.println("Edge : "+(char)(x+'A')+" "+(char)(y+'A')+" Edge Length : "+min);
			ne++;
			totalPath+=min;
		}
	}

	private static void myInfo() {
		// TODO Auto-generated method stub
		Date today = new Date();

		System.out.println("Name : Tejasvini Shelar");
		System.out.println("Course Number : CS608 ");
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


