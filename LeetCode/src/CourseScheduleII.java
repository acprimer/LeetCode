import java.util.*;

/**
 * Created by yaodh on 15/7/30.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) {
            return new int[]{};
        }
        List<Integer>[] arc = new List[numCourses];
        for(int i=0;i<numCourses;i++) {
            arc[i] = new ArrayList<Integer>();
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            arc[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        // queue : store the index of those nodes that indegree = 0
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] ans = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            ans[count++] = idx;
            for (int i = 0; i < arc[idx].size(); i++) {
                int u = arc[idx].get(i);
                inDegree[u]--;
                if (inDegree[u] == 0) {
                    queue.offer(u);
                    arc[idx].remove(i);
                    i--;
                }
            }
        }
        return count == numCourses ? ans : new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseScheduleII().findOrder(2, new int[][]{{1,0}})));
    }
}
