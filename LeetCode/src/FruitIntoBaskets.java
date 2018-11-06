/**
 * Created by yaodh on 2018/11/6.
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int p = tree[0];
        int i = 1;
        while (i < tree.length && tree[i] == p) i++;
        if (i >= tree.length) return tree.length;

        int last = i;
        int q = tree[i];
        int count = i + 1;
        int ans = count;
        while (++i < tree.length) {
            while (i < tree.length && (tree[i] == p || tree[i] == q)) {
                if (tree[i] != tree[last]) last = i;
                i++;
                count++;
            }
            ans = Math.max(ans, count);
            if (i >= tree.length) break;
            p = tree[i-1];
            q = tree[i];
            count = i - last + 1;
            last = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FruitIntoBaskets().totalFruit(new int[]{1,2,1}));
        System.out.println(new FruitIntoBaskets().totalFruit(new int[]{0,1,2,2}));
        System.out.println(new FruitIntoBaskets().totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(new FruitIntoBaskets().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
        System.out.println(new FruitIntoBaskets().totalFruit(new int[]{1,0,3,4,3}));
    }
}
