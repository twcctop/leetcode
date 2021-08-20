package leetbook._03_中级算法;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/6/26 20:05
 **/
public class _08设计问题 {
    //序列化二叉树  todo

    // 常数时间插入删除和获取随机元素

    class RandomizedSet {
        Map<Integer,Integer> dict;
        List<Integer> list;
        Random rand = new Random();
        /** Initialize your data structure here. */
        public RandomizedSet() {
           dict =  new HashMap<>();
           list =  new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (dict.containsKey(val)) {
                return  false;
            }
            dict.put(val,list.size());
            list.add(list.size(),val);
            return  true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        //  删除值
        public boolean remove(int val) {
             return  true;

        }

        /** Get a random element from the set. */
        public int getRandom() {
           return 0;
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
