
public class DiagonalTraversing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromicSS("abaaba");
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

}
