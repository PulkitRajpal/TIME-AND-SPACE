
public class Fib_ {

	public static void main(String[] args) {
		int n = 43;
		//int x = Fib(n, new int[43+1]);
		FibS(43);
		//System.out.println(x);
	}
	public static int Fib(int n,int[] qb ){
		if(n==0||n==1){
			return n ;
		}
		if(qb[n]!=0){
			return qb[n];
		}
		int fnml1 = Fib(n-1, qb);
		int fnml2= Fib(n-2, qb);
		int fn = fnml1+fnml2;
		qb[n] = fn;
		return fn ;
	}
	public static void FibT(int n){
		int[] f=  new int [n+1];
		f[0] = 0;
		f[1]=1;
		for(int i = 2; i<=n ; i++){
			f[i] = f[i-1]+f[i-2];
		}
		System.out.println(f[43]);
	}
	
	public static void FibS(int n ){
		int[] s = new int [2];
		s[0] = 0;
		s[1] = 1;
		for(int ns = 1; ns<=n;ns++){
			int nf = s[0]+s[1];
			s[0] = s[1];
			s[1] = nf;
		}
		System.out.println(s[1]);
	}
}
