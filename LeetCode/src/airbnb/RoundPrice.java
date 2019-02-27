package airbnb;

import java.util.Arrays;

public class RoundPrice {
    private int[] roundPrice(float[] prices) {
        int n = prices.length;
        int floor = 0;
        float sum = 0f;
        float[] fraction = new float[n];
        for (int i = 0; i < n; i++) {
            floor += (int) prices[i];
            sum += prices[i];
            fraction[i] = prices[i] - (int) prices[i];
        }
        int carry = Math.round(sum) - floor;
        Arrays.sort(fraction);
        float gap = fraction[n - carry];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) prices[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            float f = prices[i] - ans[i];
            if (Math.abs(f-gap) < 1e-6) continue;
            if (f > gap) {
                ans[i]++;
                count++;
            }
        }
        for (int i = 0; i < n && count < carry; i++) {
            float f = prices[i] - ans[i];
            if (Math.abs(f-gap) < 1e-6) {
                ans[i]++;
                count++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RoundPrice().roundPrice(new float[]{
                30.3f, 2.4f, 3.5f
        })));
        System.out.println(Arrays.toString(new RoundPrice().roundPrice(new float[]{
                30.9f, 2.4f, 3.9f
        })));
        System.out.println(Arrays.toString(new RoundPrice().roundPrice(new float[]{
                30.5f, 2.5f, 3.5f
        })));
    }
}
