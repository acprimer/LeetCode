/**
 * Created by yaodh on 2014/11/12.
 *
 * LeetCode: Search for a Range
 * Link: https://oj.leetcode.com/problems/search-for-a-range/
 * Description:
 * -----------------------------
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * -----------------------------
 *
 * Tag: Array | Binary Search
 */
public class SearchForARange {
    // Accepted
    /*public int[] searchRange(int[] A, int target) {
        int start = -1, end = -1;
        int left = 0, right = A.length - 1;
        while(left <= right) {
            if(A[left] == target) {
                start = left;
                break;
            }
            int mid = (left + right) >> 1;
            if(A[mid] == target) {
                right = mid;
            }
            else if(A[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        left = 0;
        right = A.length - 1;
        while(left <= right) {
            if(A[right] == target) {
                end = right;
                break;
            }
            int mid = (left + right + 1) >> 1;
            if(A[mid] == target) {
                left = mid;
            }
            else if(A[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return new int[]{start, end};
    }*/
    public int[] searchRange(int[] nums, int target) {
        int start = findLowestIndex(nums, target);
        int end = findHighestIndex(nums, target);
        return new int[]{start, end};
    }
    public int findLowestIndex(int[] nums, int target) {
        if(nums == null || nums.length <= 0) {
            return -1;
        }
        if(nums[0] == target) return 0;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) >>> 1;
            if(nums[mid] == target) {
                if(nums[mid-1] == target) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public int findHighestIndex(int[] nums, int target) {
        if(nums == null || nums.length <= 0) {
            return -1;
        }
        if(nums[nums.length - 1] == target) return nums.length - 1;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) >>> 1;
            if(nums[mid] == target) {
                if(nums[mid+1] == target) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] ans = new SearchForARange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        int[] ans = new SearchForARange().searchRange(new int[]{1}, 0);
        System.out.print(ans[0] + "," + ans[1]);
    }
}
