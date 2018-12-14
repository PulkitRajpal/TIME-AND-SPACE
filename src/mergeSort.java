
public class mergeSort {

	public static void main(String[] args) {

		int arr[] = { 4, 2, 6, 8, 1, 5, 3, 7 };
		
		int[] ans = mergesort(arr, 0, arr.length-1);
		
		for(int val:ans){
			System.out.print(val + " ");
		}
		System.out.println();
	}

	public static int[] mergesort(int[] arr, int left, int right) {

		if (left == right) {
			int[] arr1 = new int[1];
			arr1[0] = arr[left];
			return arr1;
		}

		int mid = (left + right) / 2;

		int[] lans = mergesort(arr, left, mid);
		int[] rans = mergesort(arr, mid + 1, right);

		int[] rv = merge(lans, rans);
		return rv;

	}

	public static int[] merge(int[] lans, int[] rans) {
		int[] arr1 = new int[lans.length + rans.length];

		int left = 0, right = 0;
		int kidx = 0;

		while (left < lans.length && right < rans.length) {

			if (lans[left] < rans[right]) {

				arr1[kidx] = lans[left];
				left++;
			} else {
				arr1[kidx] = rans[right];
				right++;
			}

			kidx++;

		}

		while (left < lans.length) {
			arr1[kidx] = lans[left];
			left++;
			kidx++;

		}

		while (right < rans.length) {
			arr1[kidx] = rans[right];
			right++;
			kidx++;
		}

		return arr1;

	}
}
