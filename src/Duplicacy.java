import java.util.Scanner;

public class Duplicacy {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		for (int j = 0; j < x; j++) {
			int y = scn.nextInt();
			int[] arr = new int[y];
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {

				sum = sum ^ arr[i] ^ i;
			}
			boolean z = true;

			if(sum!=0){
			z=false;		
			}
			System.out.println(z);
			
		}
	}

}
