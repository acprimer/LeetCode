/**
 * Created by yaodh on 2018/11/8.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int[] from = new int[10];
        int[] to = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                from[secret.charAt(i) - '0']++;
                to[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < from.length; i++) {
            b += Math.min(from[i], to[i]);
        }
        return String.format("%dA%dB", a, b);
    }

    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("1807", "7810"));
        System.out.println(new BullsAndCows().getHint("1123", "0111"));
    }
}
