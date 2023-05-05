package JAvaPrograms;

import java.util.Collections;

public class Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayReversewitheachelement();
		ArrayReversewitheachinteger();
	}
	public static void ArrayReversewitheachelement() {
		String s1[] = { "Aniket", "Optum", "TCS", "Padgilwar" };

		String rev = "";
		for (int i = s1.length - 1; i >= 0; i--) {

			for (int j = s1[i].length() - 1; j >= 0; j--) {
				rev = rev + s1[i].charAt(j);
			}
			System.out.print(rev + " ");
			rev = "";
		}
	}

	public static void ArrayReversewitheachinteger() {
		int s1[] = { 123, 456, 876, 987 };
		String s2 = "";
		String rev = "";
		int rev1;
		for (int i = s1.length - 1; i >= 0; i--) {
			s2 = Integer.toString(s1[i]);
			for (int j = s2.length() - 1; j >= 0; j--) {
				rev = rev + s2.charAt(j);
			}
			rev1 = Integer.parseInt(rev);
			System.out.print(rev1 + " ");
			rev = "";
		}
	}
	


}
