/**
 * Created by yaodh on 2014/11/29.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int idx = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i]<=0 || A[i]>A.length) {
                idx++;
            }
        }
        return 0;
    }
}
