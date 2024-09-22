
public class MethodsClass {
    public static boolean palindrome(String text) {
        return text.contentEquals(new StringBuilder(text).reverse());
    }

    public static boolean equalsChar(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) != text.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean increasingChar(String text) {
        return equalsChar(text);
    }

}
