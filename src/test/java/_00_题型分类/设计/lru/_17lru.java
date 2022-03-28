package _00_题型分类.设计.lru;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: twc
 * @Date 2021/4/23 17:06
 **/
public class _17lru {
//    https://leetcode-cn.com/problems/lru-cache/
    /**
     * @Description   LRU (最近最少使用) 缓存机制
     * @Date 2021/4/23 17:06
     *
     **/
    @Test
    public void test146() {

    }

    class LRUCache {
        private int capacity;
         Map<Integer,Integer> map;
        public LRUCache(int capacity) {
             this.capacity= capacity;
            map= new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                 return  map.get(key);
            }
            return  -1;
        }
        public void put(int key, int value) {
             map.put(key,value);
        }
    }


}


