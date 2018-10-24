import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yaodh on 2018/4/28.
 */
public class KthSmallestPrimeFraction {
    private static class Fraction {
        int p, q;
        Fraction next;

        public Fraction(int p, int q) {
            this.p = p;
            this.q = q;
        }

        public Fraction(int p, int q, Fraction next) {
            this.p = p;
            this.q = q;
            this.next = next;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        Fraction[] fa = new Fraction[n*(n-1)/2];
        int m = 0;
        for (int i = 0; i < n; i++) {

        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                fa[m++] = new Fraction(A[i], A[j]);
            }
        }

        Arrays.sort(fa, new Comparator<Fraction>() {
            @Override
            public int compare(Fraction o1, Fraction o2) {
                if (o1.p * o2.q > o1.q * o2.p) return 1;
                return -1;
            }
        });

        int[] ans = new int[2];
        ans[0] = fa[K-1].p;
        ans[1] = fa[K-1].q;
        return ans;
    }

    public static void main(String[] args) {
        new KthSmallestPrimeFraction().kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3);
    }
}
