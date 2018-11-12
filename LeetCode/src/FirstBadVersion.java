public class FirstBadVersion {
    private boolean[] flag = {false, false, false, false};
    boolean isBadVersion(int version) {
        return flag[version];
    }
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(3));
    }
}
