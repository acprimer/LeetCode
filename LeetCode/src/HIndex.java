import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length <= 0) return 0;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] <= citations.length - i) return citations[i];
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new HIndex().hIndex(new int[]{1, 1, 1, 1}));
        System.out.println(new HIndex().hIndex(new int[]{1, 1, 2, 2}));
    }
}
