
public class FindUnique {

	public static void main(String[] args) {

		int[] arr = { 2, 18, 6, 18, 2, 7, 7 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum ^ arr[i];
		}
		System.out.println(sum);
	}

}
