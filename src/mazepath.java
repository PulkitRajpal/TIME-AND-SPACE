import java.util.Arrays;

public class mazepath {
	public static void main(String[] args) {
		//int n = 20;
		//int[][] cost = { { 0, 1, 5, 10 }, { 2, 6, 3, 80 }, { 1, 2, 6, 0 }, { 3, 4, 1, 0 } };
		// int x = printMazePathM(0, 0, 3, 3, new int[4][4]);
		// int x = printMazePathT(n);
		// int x = MinCostPath(n, cost);
		// int x = MinCostPathM(0, 0, cost);
		//int path[][] = { { 1, 0, 1, 1, 1, 1 }, { 1, 1, 1, 0, 0, 1 }, { 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1 },
			//	{ 1, 1, 1, 1, 1, 0 }, { 0, 1, 0, 1, 1, 0 } };
		// MaxSizeSquareSubMatrixT(path);

		//int x = MaxSize(path, 0, 0, new int[path.length][path[0].length]);
		//System.out.println(omax);
		System.out.println(printMazeS(20, 20));
	}

	public static int printMazePath(int sr, int sc, int dr, int dc) {
		int x = 0;
		if (sr == dr && sc == dc) {
			return 1;
		}
		int y = 0;
		if (sr + 1 <= dr) {
			y = printMazePath(sr + 1, sc, dr, dc);

		}
		int z = 0;
		if (sc + 1 <= dc) {
			z = printMazePath(sr, sc + 1, dr, dc);

		}
		x = y + z;
		return x;
	}

	public static int printMazePathM(int sr, int sc, int dr, int dc, int[][] qb) {
		int x = 0;
		if (sr == dr && sc == dc) {
			return 1;
		}
		int y = 0;
		if (sr + 1 <= dr) {
			y = printMazePathM(sr + 1, sc, dr, dc, qb);

		}
		if (qb[sr][sc] != 0) {
			return qb[sr][sc];
		}
		int z = 0;
		if (sc + 1 <= dc) {
			z = printMazePathM(sr, sc + 1, dr, dc, qb);

		}
		x = y + z;
		qb[sr][sc] = x;
		return x;
	}

	public static int printMazePathT(int n) {
		int[][] f = new int[n + 1][n + 1];
		for (int i = 3; i >= 0; i--) {
			for (int j = 3; j >= 0; j--) {
				if (i == 3 || j == 3) {
					f[i][j] = 1;
				} else {
					f[i][j] = f[i][j + 1] + f[i + 1][j];
				}
			}
		}
		return f[0][0];
	}
//407575348
	public static int printMazeS(int dr, int dc) {
		int [] s = new int[dc+1];
		Arrays.fill(s, 1);
		for (int ns = 1; ns <= dr; ns++) {
			for(int c=dc-2;c>=0;c--){
				int ne = s[c+1]+s[c];
				s[c]=ne;
			}
		}
		return s[0];
	}

	public static int MinCostPath(int n, int[][] cost) {
		int[][] Acost = new int[4][4];
		for (int i = 3; i >= 0; i--) {
			for (int j = 3; j >= 0; j--) {
				if (i == 3 && j == 3) {
					Acost[i][j] = cost[i][j];
				} else if (i == 3) {
					Acost[i][j] = cost[i][j] + Acost[i][j + 1];
				} else if (j == 3) {
					Acost[i][j] = cost[i][j] + Acost[i + 1][j];
				} else {

					if (Acost[i + 1][j] > Acost[i][j + 1]) {
						Acost[i][j] = cost[i][j] + Acost[i][j + 1];
					} else {
						Acost[i][j] = cost[i][j] + Acost[i + 1][j];
					}
				}
			}
		}
		return Acost[0][0];
	}

	public static int MinCostPathM(int sr, int sc, int[][] cost, int[][] qb) {

		int horizontal = Integer.MAX_VALUE;
		int vertical = Integer.MAX_VALUE;
		int x = 0;
		if (sr == cost.length - 1 && sc == cost[0].length - 1) {
			return cost[sr][sc];
		}
		if (sr + 1 < cost.length) {
			vertical = MinCostPathM(sr + 1, sc, cost, qb);
		}
		if (sc + 1 < cost[0].length) {
			horizontal = MinCostPathM(sr, sc + 1, cost, qb);
		}
		x = cost[sr][sc] + Math.min(horizontal, vertical);
		return x;
	}

	public static void MaxSizeSquareSubMatrixT(int[][] arr) {
		int omax = 0;
		int omaxc = 0;
		int omaxr = 0;
		int Ans[][] = new int[arr.length][arr[0].length];
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = arr[0].length - 1; j >= 0; j--) {

				if (i == arr.length - 1 || j == arr[0].length - 1) {
					Ans[i][j] = arr[i][j];
				} else if (i == arr.length - 1 && j == arr[0].length - 1) {
					Ans[i][j] = arr[i][j];
				} else {
					if (arr[i][j] != 0) {
						Ans[i][j] = 1 + Math.min(Ans[i + 1][j + 1], Math.min(Ans[i + 1][j], Ans[i][j + 1]));
						if (Ans[i][j] > omax) {
							omax = Ans[i][j];
							omaxc = j;
							omaxr = i;
						}
					}
				}
			}
		}
		System.out.println(omax + " " + omaxc + " " + omaxr);
	}

	static int omax = 0;

	public static int MaxSize(int[][] mat, int sr, int sc, int[][] qb) {
		int dc = mat[0].length - 1;
		int dr = mat.length - 1;

		if (sr == dr || sc == dc) {
			return mat[sr][sc];
		}
		if (qb[sr][sc] != 0) {
			return qb[sr][sc];
		}
		if (mat[sr][sc] == 0) {
			return 0;
		} else {
			int h = MaxSize(mat, sr, sc + 1, qb);
			int v = MaxSize(mat, sr + 1, sc, qb);
			int d = MaxSize(mat, sr + 1, sc + 1, qb);
			int res = 1 + Math.min(d, Math.min(h, v));
			if (res > omax) {
				omax = res;
			}
			qb[sr][sc] = res;
			return res;
		}
	}
}
