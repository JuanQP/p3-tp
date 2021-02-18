package tp;

public class Utils {
	public static String padString(String inputString, int length, char pad) {
		return String.format("%1$" + length + "s", inputString).replace(' ', pad);
	}
}
