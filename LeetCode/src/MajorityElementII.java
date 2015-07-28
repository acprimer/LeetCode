import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2015/7/28.
 */
public class MajorityElementII {
    //    public List<Integer> majorityElement(int[] nums) {
//        int[] candidates = new int[3];
//        int[] cnt = new int[3];
//        int have = 0;
//        for(int i=0;i<nums.length;i++) {
//            boolean find = false;
//            for(int j=0;j<3;j++) {
//                if(cnt[j] > 0 && candidates[j] == nums[i]) {
//                    cnt[j]++;
//                    find = true;
//                }
//            }
//            if(find) {
//                continue;
//            }
//            for(int j=0;j<3;j++) {
//                if(cnt[j] == 0) {
//                    candidates[j] = nums[i];
//                    cnt[j]++;
//                    have++;
//                    break;
//                }
//            }
//            if(have == 3) {
//                for(int k=0;k<3;k++) {
//                    cnt[k]--;
//                    if(cnt[k] == 0) {
//                        have--;
//                    }
//                }
//            }
//        }
//        List<Integer> ans = new ArrayList<Integer>();
//        for(int i=0;i<3;i++) {
//            if(cnt[i] > 0 && check(nums, candidates[i])) {
//                ans.add(candidates[i]);
//            }
//        }
//        return ans;
//    }
//

    public List<Integer> majorityElement(int[] nums) {
        return majorityElement(nums, 2);
    }

    public List<Integer> majorityElement(int[] nums, int k) {
        int[] candidates = new int[k];
        int[] count = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (contains(candidates, count, nums[i], k)) {
                continue;
            }
            for (int j = 0; j < k; j++) {
                count[j]--;
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (count[i] > 0 && check(nums, candidates[i])) {
                ans.add(candidates[i]);
            }
        }
        return ans;
    }

    private boolean contains(int[] candidates, int[] count, int num, int k) {
        for (int j = 0; j < k; j++) {
            if (count[j] > 0 && num == candidates[j]) {
                count[j]++;
                return true;
            }
        }
        for (int j = 0; j < k; j++) {
            if (count[j] == 0) {
                count[j]++;
                candidates[j] = num;
                return true;
            }
        }
        return false;
    }

    public boolean check(int[] nums, int x) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (x == nums[i]) cnt++;
        }
        return cnt > (nums.length / 3);
    }

    public static void main(String[] args) {
        List<Integer> ans = new MajorityElementII().majorityElement(new int[]{-1, 1, 1, 1, 2, 1});
        for (int x : ans) {
            System.out.println(x);
        }
    }
}
