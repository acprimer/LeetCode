import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by yaodh on 2018/4/14.
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>(right - left + 1);
        for (int i = left; i <= right; i++) {
            if (check(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean check(int x) {
        int y = x;
        while (x > 0) {
            int d = x % 10;
            if (d == 0) return false;
            if (y % d != 0) return false;
            x /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        new SelfDividingNumbers().selfDividingNumbers(21, 1000);
    }
}
