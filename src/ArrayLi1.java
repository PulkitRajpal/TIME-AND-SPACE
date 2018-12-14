import java.util.ArrayList;

public class ArrayLi1 {

	public static void main(String[] args) {
		int[] den = {2 ,3 ,5 ,6 };
		CoinChange(den, 10);
		
	}public static void CoinChange(int[] den,int amount){
		int[] str = new int [amount+1];
		ArrayList<String> path[] = new ArrayList[amount+1]; 
		for(int i =0; i<path.length;i++){
			path[i] = new ArrayList<>();
		}
		str[0] = 1;
		path[0].add("");
		for(int i =0;i<den.length;i++){
			for(int j = den[i];j<=amount;j++){
				str[j] = str[j]+str[j-den[i]];
				for(String rstr:path[j-den[i]]){
					String nstr = rstr +den[i];
					path[j].add(nstr);
				}
			}
		}System.out.println(str[str.length-1]);
		System.out.println(path[path.length-1]);
	}

}
