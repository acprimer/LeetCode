import java.util.HashSet;
import java.util.Set;

/**
 * Created by yaodh on 15/7/27.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++) {
           if(set.contains(nums[i])) {
               return true;
           } else {
               set.add(nums[i]);
           }
        }
        return false;
    }
}
