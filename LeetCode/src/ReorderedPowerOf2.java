import java.util.Arrays;

/**
 * Created by yaodh on 2018/11/2.
 */
public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int N) {
        String[] set = new String[31];
        for (int i = 0; i < 31; i++) {
            set[i] = getDigits(1 << i);
        }
        Arrays.sort(set);
        return Arrays.binarySearch(set, getDigits(N)) >= 0;
    }

    private String getDigits(int x) {
        char[] ch = String.valueOf(x).toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(1));
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(10));
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(16));
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(24));
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(46));
        System.out.println(new ReorderedPowerOf2().reorderedPowerOf2(1204));
    }
}
