class Calculation{
	int z=0;
	public void add(int x, int y) {
		z=x+y;
		System.out.println("Addition is: "+z);
	}
	
}

class mycal extends Calculation{
	
	public void sub(int x,int y) {
		add(20, 30);
		z=x-y;
		System.out.println("Subtraction is :"+z);
	}
	
}
public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mycal obj = new mycal();
		obj.sub(30, 20);
	}
}

