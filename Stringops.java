public class StringOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello";
		printChars(str);
		System.out.println("******************************");
		printSS(str);
		System.out.println("******************************");
		System.out.println(isPalindrome("abdcba"));
		System.out.println("******************************");
		System.out.println(countpalSS(str));
		System.out.println("******************************");
		System.out.println(toggleCase("HelIo"));
		System.out.println("******************************");
		System.out.println(ModifyPattern("acf"));
	}

	public static void printChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}
