
public class RodCutting {

	public static void main(String[] args) {
		int[] price = { 0 ,3 ,5 ,6 ,15 ,10 ,25 ,12 ,24 };
		 //Rod(price);
		//int p = MinPalinCut("abccbc", 0, 5, new int[6][6]);
		//System.out.println(p);
		System.out.println(RodM(price, 8,new int[price.length]));
	}
	
	public static void Rod(int[] price) {
		int[] f = new int[price.length];
		f[1] = 3;
		f[0] = 0;
		for (int i = 2; i < price.length; i++) {
			int left = 1;
			int right = i - 1;
			int max = 0;
			int omax = price[i];
			int max1 = price[i];
			while (left <= right) {
				max = f[left] + f[right];

				if (omax < max) {
					omax = max;
				}

				left++;
				right--;
			}
			f[i] = omax;
		}
		System.out.println(f[8]);
	}
	public static int RodM(int[] arr, int r ,int[] qb){
		if(r==0){
			return 0;
		}
		if(qb[r]!=0){
			return qb[r];
		}
		int max = arr[r];
		int left = 1;
		int right =r-1;
		while(left<=right){
			int max1 = RodM(arr, right,qb);
			int max2 = RodM(arr, left,qb);
			left++;
			right--;
			if(max1+max2>max){
				max = max1+max2;
				qb[r] = max;
			
			}
		}
		return max;
		
		
	}

	public static int MinPalinCut(String str, int si, int ei, int[][] qb) {
		int mincut = Integer.MAX_VALUE;
		if(Ispalindrome(str, si, ei)==true){
			return 0;
		}
		if (qb[si][ei] != 0) {
			return qb[si][ei];
		}
		for (int i = si; i < ei; i++) {
			int c1 = MinPalinCut(str, si, i, qb);
			int c2 = MinPalinCut(str, i+1, ei, qb);
			int tc = c1 + c2+1;
			if (tc < mincut) {
				mincut = tc;
			}
		}
		qb[si][ei] = mincut;
		return mincut;
	}
	public static boolean Ispalindrome(String str,int si , int ei){
		int left = si;
		int right = ei;
		while(left<= right){
			if(str.charAt(left)!= str.charAt(right)){
				return false;
			}left++;
			right--;
		}return true;
	}
}
