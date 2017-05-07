package algorithm.base.conversion;

public class Base62 {
	
	private static final String characterMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static void main(String[] args) {
		Base62 baseConvertor = new Base62();
		System.out.println(baseConvertor.decimalToBase62(2017));
		System.out.println(baseConvertor.decimalToBase62(2117));
	}
	
	public String decimalToBase62(long num){
		StringBuilder sb = new StringBuilder();
		while(num > 0){
			long remainder = num % 62;
			sb.append(characterMap.charAt((int)remainder));
			num = num / 62;
		}
		return sb.reverse().toString();
	}
}
