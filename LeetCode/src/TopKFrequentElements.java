import java.util.*;

public class TopKFrequentElements {
    class Entry implements Comparable<Entry> {
        int key, count;

        public Entry(int key, int count) {
            this.key = key;
            this.count = count;
        }

        @Override
        public int compareTo(Entry o) {
            return this.count < o.count ? -1 : 1;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Entry> queue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Entry entry = new Entry(e.getKey(), e.getValue());
            if (queue.size() < k || entry.compareTo(queue.peek()) > 0) {
                queue.offer(entry);
            }
            if (queue.size() > k) queue.poll();
        }
        List<Integer> ans = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            ans.add(0, queue.poll().key);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ans = new TopKFrequentElements().topKFrequent(
                new int[]{1, 1, 1, 2, 2, 3}, 2
        );
        for (int x : ans) {
            System.out.println(x);
        }
    }
}
