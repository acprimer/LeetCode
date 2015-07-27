import java.util.TreeSet;

/**
 * Created by yaodh on 15/7/27.
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i] + t);
            Integer ceil = set.ceiling(nums[i] - t);
            if((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if(i >= k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
