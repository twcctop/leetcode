package leetbook._04_高级算法;

//https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/
//todo  错误 lru 缓存机制

import java.util.LinkedHashMap;
import java.util.Map;

public class _07设计问题 {

    private int capacity;

    class LRUCache  extends LinkedHashMap<Integer,Integer> {

        public LRUCache(int capacity) {
            super(capacity,0.75F, true);
        }

        public int get(int key) {
            return  super.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }

    }
    //测试
}
