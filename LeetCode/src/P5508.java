import java.util.HashMap;
import java.util.Map;

public class P5508 {
    public static void main(String[] args) {
        System.out.println(new P5508().numTriplets(new int[]{7, 4}, new int[]{5, 2, 8, 9}));
        System.out.println(new P5508().numTriplets(new int[]{1, 1}, new int[]{1, 1, 1}));
        System.out.println(new P5508().numTriplets(new int[]{7, 7, 8, 3}, new int[]{1, 2, 9, 7}));
        System.out.println(new P5508().numTriplets(new int[]{4, 7, 9, 11, 23}, new int[]{3, 5, 1024, 12, 18}));
        System.out.println(new P5508().numTriplets(new int[]{43024, 99908}, new int[]{1864}));
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> set1 = new HashMap();
        Map<Long, Integer> set2 = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long cal = 1L * nums1[i] * nums1[j];
                set1.put(cal, set1.getOrDefault(cal, 0) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long cal = 1L * nums2[i] * nums2[j];
                set2.put(cal, set2.getOrDefault(cal, 0) + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < nums1.length; i++) {
            ans += set2.getOrDefault(1L * nums1[i] * nums1[i], 0);
        }
        for (int i = 0; i < nums2.length; i++) {
            ans += set1.getOrDefault(1L * nums2[i] * nums2[i], 0);
        }
        return ans;
    }
}
