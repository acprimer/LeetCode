/**
 * Created by yaodh on 2014/11/13.
 *
 * LeetCode: Gas Station
 * Link: https://oj.leetcode.com/problems/gas-station/
 * Description:
 * -----------------------------
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * The solution is guaranteed to be unique.
 * -----------------------------
 *
 * Tag: Greedy
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0;i<n;i++) {
            gas[i] -= cost[i];
        }
        int maxGas = -1, maxIdx = -1;
        int sumGas = 0;
        for(int i=n-1;i>=0;i--) {
            sumGas += gas[i];
            if(sumGas > maxGas) {
                maxGas = sumGas;
                maxIdx = i;
            }
        }
        if(sumGas < 0) return -1;
        int ans = maxIdx;
        sumGas = gas[maxIdx];
        for(int i=(maxIdx+1)%n; i!=maxIdx; i=(i+1)%n) {
            sumGas += gas[i];
            if(sumGas < 0) {
                ans = -1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new GasStation().canCompleteCircuit(new int[]{5}, new int[]{4});
        System.out.print(ans);
    }
}
