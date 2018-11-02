import java.util.HashSet;
import java.util.Set;

/**
 * Created by yaodh on 2018/11/2.
 */
public class XKindDeckCards {
    private static final int MAX = 10005;
    int[] pTable;

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) return false;

        int[] cnt = new int[MAX];
        for (int n : deck) {
            cnt[n]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < MAX; i++) {
            if (cnt[i] == 1) return false;
            if (cnt[i] > 0) set.add(cnt[i]);
        }
        primeTable();
        int[] p = new int[MAX];
        for (int x : set) {
            countPrime(x, p);
        }
        for (int i = 0; i < MAX; i++) {
            if (p[i] >= set.size()) return true;
        }

        return false;
    }

    private void countPrime(int x, int[] p) {
        for (int i = 0; i < pTable.length && x > 1; i++) {
            int div = pTable[i];
            if (x % div == 0) {
                p[div]++;
                while (x % div == 0) {
                    x /= div;
                }
            }
        }
    }

    private void primeTable() {
        boolean[] prime = new boolean[MAX];
        int cnt = 0;
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                cnt++;
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
        pTable = new int[cnt];
        cnt = 0;
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                pTable[cnt++] = i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new XKindDeckCards().hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(new XKindDeckCards().hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(new XKindDeckCards().hasGroupsSizeX(new int[]{1}));
        System.out.println(new XKindDeckCards().hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(new XKindDeckCards().hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
    }
}
