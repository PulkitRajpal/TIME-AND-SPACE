
public class Power {

	public static void main(String[] args) {

		int ans = power2(2, 5);
		System.out.println(ans);
	}

	public static int power1(int x, int n) {

		if (n == 0)
			return 1;

		int rans = power1(x, n - 1);
		int ma = rans * x;
		return ma;

	}

	public static int power2(int x, int n) {

		if (n == 0) {
			return 1;

		}

		int rans = power2(x, n / 2);
		int ma = rans * rans;
		
		if(n%2 == 1){
			ma = ma*x;
		}
		
		return ma;
	}
}