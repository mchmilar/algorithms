package leetcode;

public class ZigzagConversion {

	public static void main(String[] args) {
		System.out.println(convert("A", 1));

	}
	
	public static String convert(String s, int numRows) {
		if (numRows == 1) return s;
        int mod = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
        	for (int j = 0; i + j < s.length(); j += mod) {
        		sb.append(s.charAt(i+j));
        		int diagonal = i+j+ mod - 2*i;
        		if (i != 0 && i != numRows - 1 && diagonal < s.length()) {
        			sb.append(s.charAt(diagonal));
        		}
        	}
        }
		return sb.toString();
    }
}
