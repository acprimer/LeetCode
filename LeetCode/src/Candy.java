/**
 * Created by yao on 2014/11/12.
 */
public class Candy {
    int[] height;
    public int candy(int[] ratings) {
        if(ratings.length <= 1) {
            return ratings.length;
        }
        int n = ratings.length;
        height = new int[n+1];
        for(int i=0;i<n;i++) {
            height[i] = 1;
        }
        if(ratings[0] < ratings[1]) {
            update(0, ratings);
        }
        if(ratings[n-1] < ratings[n-2]) {
            update(n-1, ratings);
        }
        for(int i=1;i<n-1;i++) {
            if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]) {
                update(i, ratings);
            }
        }
        int ans = 0;
        for(int i =0;i<n;i++) {
            ans += height[i];
        }
        return ans;
    }

    private void update(int i, int[] ratings) {
        int n = ratings.length;
        int j = i-1, curHeight = 1;
        while(j>=0 && ratings[j] > ratings[j+1]) {
            height[j] = Math.max(height[j], ++curHeight);
            j--;
        }
        j = i+1;
        curHeight = 1;
        while(j<n && ratings[j] > ratings[j-1]) {
            height[j] = Math.max(height[j], ++curHeight);
            j++;
        }
    }

    public static void main(String[] args) {
        int ans = new Candy().candy(new int[]{5,1,1,1,10,2,1,1,1,3});
        System.out.println(ans);
    }
}
