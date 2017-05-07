package algorithm.base.conversion;

/**
 * This class can convert any long decimal to its base62 representation. 
 * This is using base 62 because [a-z](26) + [A-Z](26) + (0-9)10 = 62
 * 
 * This solution was discussed here for tinyURL: 
 * 			http://stackoverflow.com/questions/742013/how-to-code-a-url-shortener
 * @author hgupta
 *
 */
public class Base62 {
	
	private static final String characterMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static void main(String[] args) {
		Base62 baseConvertor = new Base62();
		System.out.println(baseConvertor.decimalToBase62(2017));
		System.out.println(baseConvertor.decimalToBase62(2117));
		System.out.println(baseConvertor.base63ToLong("Ij"));
		System.out.println(baseConvertor.base63ToLong("GH"));
	}
	
	/**
	 * This will convert decimal to base.
	 * @param num
	 * @return
	 */
	public String decimalToBase62(long num){
		StringBuilder sb = new StringBuilder();
		if(num ==0) return "a";
		while(num > 0){
			long remainder = num % 62;
			sb.append(characterMap.charAt((int)remainder));
			num = num / 62;
		}
		return sb.reverse().toString();
	}
	
	/**
	 * Returns original value from its base62 string.
	 * @param str
	 * @return
	 */
	public double base63ToLong(String str){
		if(null == str || str.length() == 0) return 0;
		double val = 0;
		for(int i=0; i<str.length(); i++){
			double tmp_val = characterMap.indexOf(str.charAt(i));
			tmp_val = tmp_val * Math.pow(62, str.length() - (i + 1));
			val  += tmp_val;
		}
		return val;
	}
}
