import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimeTilln {

	public static void main(String[] args) {
		int n = 30;
		boolean[] arr = new boolean[n + 1];
		Arrays.fill(arr, true);
		
		arr[0] = arr[1] = false;
		for (int i = 2; i * i <= n; i++) {
			
			if (arr[i] == true) {
				int multiples = i * i;
				while (multiples <= n) {
					arr[multiples] = false;
					multiples = multiples + i;
					
				}
			}
		}
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] == true) {
				System.out.println(i);
			}
		}
	}
}
