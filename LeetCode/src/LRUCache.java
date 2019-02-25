import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer, Integer> mCache;

    public LRUCache(int capacity) {
        mCache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return mCache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        mCache.put(key, value);
    }
}
