
public class Goldmine {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 5, 0, 3 }, { 6, 7, 0, 8, 2 }, { 17, 0, 6, 0, 0 }, { 5, 15, 0, 3, 2 } };
		// int n = arr.length;
		// int o = arr[0].length;
		// PalindromicSS("abaaba");
		// int[] arr = { 5, 3, 9, 12, 8, 10, 1, 80, 4 };
		// Goldmine(arr, n, o);
		// longIncSA(arr);
		for (int sr = 0; sr < arr[0].length; sr++) {
			int x = GoldmineM(arr, sr, 0, new int[arr.length][arr[0].length]);
			if (omax < x) {
				omax = x;
			}
			
		}System.out.println(omax);
	}

	public static void Goldmine(int[][] arr, int n, int o) {
		int[][] f = new int[n][o];
		int omax = Integer.MIN_VALUE;
		for (int j = o - 1; j >= 0; j--) {
			for (int i = 0; i <= n - 1; i++) {
				if (j == o - 1) {
					f[i][j] = arr[i][j];
				} else if (i == 0) {
					f[i][j] = arr[i][j] + Math.max(f[i][j + 1], f[i + 1][j + 1]);
				} else if (i == n - 1) {
					f[i][j] = arr[i][j] + Math.max(f[i - 1][j + 1], f[i][j + 1]);
				} else {
					f[i][j] = arr[i][j] + Math.max(f[i + 1][j + 1], Math.max(f[i][j + 1], f[i - 1][j + 1]));
				}
				if (f[i][j] > omax) {
					omax = f[i][j];
				}
			}
		}
		System.out.println(omax);
	}

	static int omax = 0;

	public static int GoldmineM(int[][] mat, int sr, int sc, int[][] qb) {

		int dc = mat[0].length - 1;
		int dr = mat.length - 1;

		if (sc == dc) {
			return mat[sr][sc];
		}

		if (qb[sr][sc] != 0) {
			return qb[sr][sc];
		}

		int s2d = 0;

		int h = Integer.MIN_VALUE;
		int vd = Integer.MIN_VALUE;
		int dd = Integer.MIN_VALUE;

		if (sr > 0) {
			vd = GoldmineM(mat, sr - 1, sc + 1, qb);
		}

		h = GoldmineM(mat, sr, sc + 1, qb);

		if (sr < mat.length - 1) {
			dd = GoldmineM(mat, sr + 1, sc + 1, qb);
		}

		s2d = mat[sr][sc] + Math.max(vd, Math.max(dd, h));
		qb[sr][sc] = s2d;
		return s2d;

	}

	public static void PalindromicSS(String str) {
		boolean[][] check = new boolean[6][6];
		int counter = 0;
		for (int gap = 0; gap <= 5; gap++) {
			int i = 0;
			int j = i + gap;
			while (j < 6) {
				if (i == j) {
					check[i][j] = true;
					counter++;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						check[i][j] = true;
						counter++;
					}
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						if (check[i + 1][j - 1] == true) {
							check[i][j] = true;
							counter++;
						}
					}
				}
				i++;
				j++;
			}
		}

		System.out.println(counter);

	}

	public static void longIncSA(int[] arr) {
		int omax = 0;
		int[] ar = new int[arr.length];
		ar[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (ar[j] > ar[i]) {
						ar[i] = ar[j];

					}

				}

			}
			ar[i] += 1;
			if (omax < ar[i]) {
				omax = ar[i];
			}
		}
		System.out.println(omax);
	}
}
