public class P1359 {
    public static int countOrders(int n) {
        long ans = 1;
        int MOD = 1000000007;
        for (int i = 1; i <= n * 2; i += 2) {
            System.out.println("i " + i);
            ans = i * (i + 1) / 2 * ans % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(countOrders(6));
        System.out.println(countOrders(7));
    }
}
