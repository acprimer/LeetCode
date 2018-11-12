import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length <= 0) return 0;
        Arrays.sort(citations);
        int ans = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= (citations.length - i)) {
                ans = Math.max(ans, citations.length - i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new HIndex().hIndex(new int[]{1, 1, 1, 1}));
        System.out.println(new HIndex().hIndex(new int[]{1, 1, 2, 2}));
        System.out.println(new HIndex().hIndex(new int[]{11, 15}));
        System.out.println(new HIndex().hIndex(new int[]{1, 15}));
    }
}
