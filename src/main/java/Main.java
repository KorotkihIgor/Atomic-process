
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static AtomicInteger length3 = new AtomicInteger(0);
    public static AtomicInteger length4 = new AtomicInteger(0);
    public static AtomicInteger length5 = new AtomicInteger(0);

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }
        Thread palindromeThread = new Thread(() -> {
            for (String text : texts) {
                if (MethodsClass.palindrome(text)) {
                    samNick(text.length());
                }
            }
        });
        palindromeThread.start();

        Thread increasingCharThread = new Thread(() -> {
            for (String text : texts) {
                if (MethodsClass.increasingChar(text)) {
                    samNick(text.length());
                }
            }
        });
        increasingCharThread.start();

        Thread equalsCharThread = new Thread(() -> {
            for (String text : texts) {
                if (MethodsClass.equalsChar(text)) {
                    samNick(text.length());
                }
            }
        });
        equalsCharThread.start();

        palindromeThread.join();
        increasingCharThread.join();
        equalsCharThread.join();

        System.out.println("Красивых слов с длиной 3:" + length3);
        System.out.println("Красивых слов с длиной 4:" + length4);
        System.out.println("Красивых слов с длиной 5:" + length5);
    }

    public static void samNick(int lenghtNick) {
        if (lenghtNick == 3) {
            length3.incrementAndGet();
        }
        if (lenghtNick == 4) {
            length4.incrementAndGet();
        }
        if (lenghtNick == 5) {
            length5.incrementAndGet();
        }
    }

}
