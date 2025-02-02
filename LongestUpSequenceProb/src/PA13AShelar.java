import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PA13AShelar {

	public static void main(String arg[]) throws FileNotFoundException {
		myInfo();
		readFile("LUPData.txt");
	}

	private static void myInfo() {
		// TODO Auto-generated method stub
		Date today = new Date();
		System.out.println("Name : Tejasvini Shelar");
		System.out.println("Course Number : CS608 ");
		System.out.println("Date : "+today.toString());
	}

	private static void readFile(String filename) throws FileNotFoundException {
		ArrayList<Integer> list=new ArrayList<>(); 
		File f1 = new File(filename);
		if(!f1.exists())
			System.out.println("input file not found");

		Scanner sc = new Scanner(f1);
		ArrayList<Integer> seqOfInt = new ArrayList<>(); 
		while(sc.hasNextLine()) {
			seqOfInt.clear();
			String line = sc.nextLine();
			String[] nums = line.split(" ");
			for(String num : nums) {
				seqOfInt.add(Integer.parseInt(num));
			}

			int listofnum[][] =new int[3][seqOfInt.size()+1];
			System.out.println(" ");
			listofnum[0][0]=0;
			for(int i=1;i<=seqOfInt.size();i++) {
				listofnum[0][i]=seqOfInt.get(i-1);
			}
			findLUP(listofnum);
		}
	}

	private static void findLUP(int[][] listofnum) {
		// TODO Auto-generated method stub
		int maxsl=0,flag=0,hp=0;
		ArrayList<Integer> maxsllist =new ArrayList<>();

		for(int i=0;i<listofnum[0].length;i++) {
			maxsl=0;
			for(int k=i-1;k>=0;k--) {
				if(maxsl<listofnum[1][k]) {
					maxsl=listofnum[1][k];
				}
			}
			for(int j=i-1;j>=0;j--) {
				flag=0;
				maxsllist.clear();
				for(int k=j;k>=0;k--) {
					if(listofnum[1][k]==maxsl) {
						maxsllist.add(listofnum[0][k]);
						flag=1;
					}
				}

				for(int num: maxsllist) {
					if(flag==0) {
						break;
					}
					if(num<listofnum[0][i]) {
						hp=num;
						flag=2;
					}
				}
				if(flag==2) {
					listofnum[2][i]=hp;
					listofnum[1][i]=maxsl+1;
					break;
				}else {
					maxsl--;
				}
				if(maxsl==0) {
					listofnum[1][i]=2;
					listofnum[2][i]=listofnum[0][0];
				}
			}

		}
		printLUP(listofnum);
	}

	private static void printLUP(int[][] listofnum) {
		// TODO Auto-generated method stub
		System.out.println("\n");
		for(int k=1;k<listofnum[0].length;k++) {
			System.out.print(listofnum[0][k]+" | ");
		}
		System.out.println(" ");
		for(int k=1;k<listofnum[0].length;k++) {
			System.out.print((listofnum[1][k])+"  | ");
		}
		System.out.println(" ");
		for(int k=1;k<listofnum[0].length;k++) {
			if((listofnum[1][k]-1)==0) {
				System.out.print("-"+"  | ");
			}else
				System.out.print(listofnum[2][k]+" | ");
		}
		int maxsl=0;
		for(int k=1;k<listofnum[0].length;k++) {
			if(maxsl<=listofnum[1][k]) {
				maxsl=listofnum[1][k];
			}
		}

		System.out.println("\nLength of Subsequnece : "+maxsl);
		ArrayList<Integer> subseq = new ArrayList<>();
		int ph=0;
		for(int i=1;i<listofnum[0].length;i++) {
			if(maxsl==listofnum[1][i]) {
				System.out.println("\nSubsequence : ");
				ph=listofnum[0][i];
				for(int j=i;j>0;j--) {
					if(ph==listofnum[0][j]) {
						subseq.add(listofnum[0][j]);
						ph=listofnum[2][j];
					}
				}
				
				for(int j=subseq.size()-1;j>=0;j--) {
					System.out.print(" "+subseq.get(j));
				}
				subseq.clear();
			}
		}
	}

}




