import java.util.ArrayList;

public class countBoard {
	public static void main(String[] args) {
		int n = 43;
		int x = num(0, n, new int[n + 1]);
		// int x = cspT(n);
		System.out.println(x);
	}

	public static int num(int src, int dest, int[] str) {
		if (src == dest) {
			return 1;
		}
		if (src > dest) {
			return 0;
		}
		if (str[src] != 0) {
			return str[src];
		}
		int cstod = 0;
		for (int i = 1; i <= 6; i++) {
			int inter = src + i;
			int citod = num(inter, dest, str);
			cstod = cstod + citod;
		}

		str[src] = cstod;
		return cstod;
	}

	public static int cspT(int n) {
		int[] f = new int[n + 1];
		f[10] = 1;
		for (int x = 9; x >= 0; x--) {
			for (int i = 6; i >= 1; i--) {
				if (x + i < f.length) {

					f[x] += f[x + i];
				}
			}
		}
		return f[0];

	}

	public static void cspS(int n ){
		int[] s = new int[6];
		s[0] = 1;
		for(int ns = 1; ns<=n;ns++){
			int ne = s[0]+s[1]+s[2]+s[3]+s[4]+s[5];
			s[5] = s[4];
			s[4] =  s[3];
					s[3] = s[2];
					s[2] = s[1];
					s[1] = s[0];
					s[0] = ne;
		}
		
		System.out.println(s[0]);
		
		
		
	}
}
