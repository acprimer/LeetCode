import java.util.Arrays;

public class HIndexII {
    // citations已经是有序的了，可以二分查找
    public int hIndex(int[] citations) {
        if (citations == null || citations.length <= 0) return 0;
        return binary(citations);
    }

    private int binary(int[] A) {
        int left = 0, right = A.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (A[mid] < A.length - mid) {
                left = mid + 1;
            } else {
                ans = A.length - mid;
                if (mid > 0 && A[mid-1] < A.length - mid +1) {
                    return ans;
                }
                right = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new HIndexII().hIndex(new int[]{0,1,3,5,6}));
        System.out.println(new HIndexII().hIndex(new int[]{0}));
        System.out.println(new HIndexII().hIndex(new int[]{0, 0}));
        System.out.println(new HIndexII().hIndex(new int[]{0, 0,0}));
        System.out.println(new HIndexII().hIndex(new int[]{1}));
        System.out.println(new HIndexII().hIndex(new int[]{1,1}));
        System.out.println(new HIndexII().hIndex(new int[]{1,1,1}));
        System.out.println(new HIndexII().hIndex(new int[]{2}));
        System.out.println(new HIndexII().hIndex(new int[]{2,2}));
        System.out.println(new HIndexII().hIndex(new int[]{2,2,2}));
    }
}
