import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yaodh on 15/7/30.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        List<Integer>[] arc = new List[numCourses];
        for(int i=0;i<numCourses;i++) {
            arc[i] = new ArrayList<Integer>();
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            arc[prerequisites[i][0]].add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }
        // queue : store the index of those nodes that indegree = 0
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            count++;
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
        return count == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(3, new int[][]{{2,0},{2,1}}));
    }
}
