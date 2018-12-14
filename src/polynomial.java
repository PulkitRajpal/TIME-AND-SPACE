import java.util.Scanner;

public class polynomial {

	public static void main(String[] args) {
		int x = 2;
		int count = 3;
		int xrp = 1;
		int sum = 0;
		while (count >= 1) {
			// for (int i = 1; i <= n; i++) {
			xrp = xrp * x;
			// }

			System.out.println(sum + " " + count + " " + xrp);
			sum = sum + count * xrp;

			count--;
		}
		System.out.println(sum);
	}

}
