package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-roman
 * 
 * @author hgupta
 *
 */
public class IntegerToRoman {

	public static void main(String[] args) {
		System.out.println(intToRoman(40));
	}

	/**
	 * @param num
	 * @param base
	 * @param val
	 * @param sb
	 * @return
	 */
	private static int updateStr(int num, int base, String val, StringBuilder sb) {
		while (num >= base) {
			int d = num / base;
			while (d != 0) {
				sb.append(val);
				d--;
			}
			num = num % base;
		}
		return num;
	}

	/**
	 * 
	 * @param num
	 * @return
	 */
	public static String intToRoman(int num) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "I");
		map.put(2, "II");
		map.put(3, "III");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(6, "VI");
		map.put(7, "VII");
		map.put(8, "VIII");
		map.put(9, "IX");

		StringBuilder sb = new StringBuilder();
		num = updateStr(num, 1000, "M", sb);
		num = updateStr(num, 900, "CM", sb);
		num = updateStr(num, 500, "D", sb);
		num = updateStr(num, 400, "CD", sb);
		num = updateStr(num, 100, "C", sb);
		num = updateStr(num, 90, "XC", sb);
		num = updateStr(num, 50, "L", sb);
		num = updateStr(num, 40, "XL", sb);
		num = updateStr(num, 10, "X", sb);

		if (map.containsKey(num))
			sb.append(map.get(num));

		return sb.toString();
	}

}
