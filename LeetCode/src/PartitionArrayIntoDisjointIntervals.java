/**
 * Created by yaodh on 2018/11/6.
 */
public class PartitionArrayIntoDisjointIntervals {
    public int partitionDisjoint(int[] A) {
        int[] min = new int[A.length];
        int[] max = new int[A.length];
        max[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            max[i] = Math.max(max[i-1], A[i]);
        }
        min[A.length-1] = A[A.length-1];
        for (int i = A.length-2; i >=0; i--) {
            min[i] = Math.min(min[i+1], A[i]);
        }
        for (int i = 0; i < A.length-1; i++) {
            if (max[i] <= min[i+1]) return i+1;
        }
        return A.length;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionArrayIntoDisjointIntervals().partitionDisjoint(new int[]{5,0,3,8,6}));
        System.out.println(new PartitionArrayIntoDisjointIntervals().partitionDisjoint(new int[]{1,1,1,0,6,12}));
        System.out.println(new PartitionArrayIntoDisjointIntervals().partitionDisjoint(new int[]{1,1}));
    }
}
