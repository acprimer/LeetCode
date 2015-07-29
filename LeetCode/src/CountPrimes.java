import java.util.BitSet;

/**
 * Created by yaodh on 15/7/28.
 */
public class CountPrimes {
    // using boolean array
//    public int countPrimes(int n) {
//        int ans = 0;
//        boolean[] bits = new boolean[n];
//        for(int i = 2; i < n; i++) {
//            if(!bits[i]) {
//                ans++;
//                if(i > Math.sqrt(n)) continue;
//                for(int j = i * i; j < n; j += i) {
//                    bits[j] = true;
//                }
//            }
//        }
//        return ans;
//    }

    // using BitSet
    public int countPrimes(int n) {
        int ans = 0;
        BitSet bits = new BitSet(n);
        for(int i = 2; i < n; i++) {
            if(!bits.get(i)) {
                ans++;
                if(i > Math.sqrt(n)) continue;
                for(int j = i * i; j < n; j += i) {
                    bits.set(j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(6));
    }
}
