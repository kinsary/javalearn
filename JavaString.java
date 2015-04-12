public class JavaString {

	public static void main(String[] args) {

		System.out.println("-----------");

		String s1 = "abcd";
		String s2 = s1;

		System.out.println(s1);
		System.out.println(s2);

		s1 = s1.concat("ef");

		System.out.println(s1);
		System.out.println(s2);

		// /////////////////////////////
		System.out.println("-----------");

		String x = "abcdef";
		x = x.substring(1, 3);
		System.out.println(x);

		// /////////////////////////////
		System.out.println("-----------");

		String a = "abcd"; // method area
		String b = "abcd";
		System.out.println(a == b); // true
		System.out.println(a.equals(b));

		String c = new String("abcd"); // heap
		String d = new String("abcd");
		System.out.println(c == d); // false
		System.out.println(c.equals(d));

		String c1 = new String("abcd").intern();
		String d1 = new String("abcd").intern();
		System.out.println(c1 == d1); // now true
		System.out.println(c1.equals(d1));

		// /////////////////////////////
		System.out.println("-----------");

		String x2 = new String("ab");
		change(x2);
		System.out.println(x2);

		// /////////////////////////////
		System.out.println("-----------");

	}

	public static void change(String x) {
		x = "cd";
	}

}
