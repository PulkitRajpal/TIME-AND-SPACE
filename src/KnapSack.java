
public class KnapSack {

	public static void main(String[] args) {
		int[] costs = { 100, 50, 17, 22, 80 };
		int[] wts = { 2, 3, 1, 4, 2 };
		int capacity = 7;
	}

	public static void KnapSack(int[] costs, int[] wts, int capacity) {
		int wsf = 0;
		int csf = 0;

		int maxcost = Integer.MIN_VALUE;
		int[][] f = new int[capacity + 1][wts.length + 1];

		for (int i = 0; i <= capacity; i++) {
			for (int j = 0; j <= wts.length; j++) {
				if (i == 0 || j == 0) {
					f[i][j] = 0;
				} else {
					int rem = j - 1;
					int remcapn = i;
					int fn = f[remcapn][rem];
					int remcapy = i - wts[j - 1];
					int fy = 0;
					if (remcapy >= 0) {
						fy = f[remcapy][rem] + costs[j - 1];
					}
					f[i][j] = Math.max(fy, fn);

				}

			}
		}
		System.out.println(f[2][1]);
	}

}
