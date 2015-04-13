import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

		int[] arr = new int[3];
		System.out.println(arr.length);// length for array

		String str = "abc";
		System.out.println(str.length());// length() for string

		// /////////////////////////////
		System.out.println("-----------");

		// How to Check if an Array Contains a Value in Java Efficiently?
		// String[] array = new String[] { "CD", "BC", "EF", "DE", "AB" };

		String[] array = new String[10000];

		Random sr = new Random();
		for (int i = 0; i < 10000; i++) {
			array[i] = String.valueOf(sr.nextInt());
		}

		long startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			useList(array, "A");
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("useList: " + duration / 1000000);

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			useSet(array, "A");
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("useList: " + duration / 1000000);

		startTime = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			useLoop(array, "A");
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("useList: " + duration / 1000000);

		// maybe sorted list or tree or hashset more efficiently

		// /////////////////////////////
		System.out.println("-----------");
	}

	public static void change(String x) {
		x = "cd";
	}

	public static boolean useList(String arr[], String targetValue) {
		return Arrays.asList(arr).contains(targetValue);
	}

	public static boolean useSet(String arr[], String targetValue) {
		Set<String> set = new HashSet<String>(Arrays.asList(arr));
		return set.contains(targetValue);
	}

	public static boolean useLoop(String[] arr, String targetValue) {
		for (String s : arr) {
			if (s.equals(targetValue))
				return true;
		}
		return false;
	}
}
