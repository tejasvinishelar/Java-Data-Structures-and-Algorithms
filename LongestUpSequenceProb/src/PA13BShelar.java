import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PA13BShelar {
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

			int listofnum[] =new int[seqOfInt.size()];
			System.out.println(" ");
			for(int i=0;i<seqOfInt.size();i++) {
				listofnum[i]=seqOfInt.get(i);
			}
			findLUP(listofnum);
		}
	}

	private static void findLUP(int[] listofnum) {
		// TODO Auto-generated method stub
		Node root=new Node(listofnum[0]);
		Node node=root;
		if(node.right==null && node.right==null && node.ele<listofnum[1]) {
			node.right=new Node(listofnum[1]);
		}
		if(node.left==null && node.right==null && node.ele>listofnum[1]) {
			node.left=new Node(node.ele);
			node.ele=listofnum[1];
		}

		for(int i=2;i<listofnum.length;i++) {
			node=root;
			while(node.right!=null && node.right.ele<listofnum[i]) {
				node=node.right;
			}
			if(node.right==null) {
				node.right=new Node(listofnum[i]);
			}else {
				if(node.right.left==null) {
					node.right.left=new Node(node.right.ele);
					node.right.ele=listofnum[i];
				}else {
					Node newnode=node.right;
					int temp=0;
					while(newnode.left!=null) {
						temp=newnode.left.ele;
						newnode.left.ele=newnode.ele;
						newnode=newnode.left;
					}
					newnode.left=new Node(temp);
					node.right.left=newnode;
					node.right.ele=listofnum[i];
				}
			}
		}
		printLUP(root);
	}

	private static void printLUP(Node root) {
		// TODO Auto-generated method stub
		Node rootnode=root;
		System.out.println("\nLUP : ");
		while(rootnode!=null) {
			System.out.print(" "+rootnode.ele);
			rootnode=rootnode.right;
		}
		
		System.out.println("\nLUP Tree Hangers :");
		
		while(root!=null) {
			System.out.println(" ");
			System.out.print(" "+root.ele);
			Node node=root;
			while(node.left!=null) {
				System.out.print(" "+node.left.ele);
				node=node.left;
			}
			root=root.right;
		}

	}

}

class Node{
	Node left;
	int ele;
	Node right;

	public Node(int n){
		left = null;
		ele = n; 
		right = null;
	}	
}


