/**
 * Created by yao on 2014/11/23.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num.length<=1) return;
        for(int i=num.length-2;i>=0;i--) {
            if(num[i] < num[i+1]) {
                int idx = reverse(num, i+1, num[i]);
                swap(num, i, idx);
                return;
            }
        }
        reverse(num, 0, 0);
    }

    private int reverse(int[] num, int start, int target) {
        for(int i=start,j=num.length-1;i<j;i++,j--) {
            swap(num, i, j);
        }
        for(int i=start;i<num.length;i++) {
            if(num[i] > target) return i;
        }
        return -1;
    }

    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,1,4,1};
        new NextPermutation().nextPermutation(num);
        for(int i=0;i<num.length;i++) {
            System.out.print(num[i] + " ");
        }
    }
}
