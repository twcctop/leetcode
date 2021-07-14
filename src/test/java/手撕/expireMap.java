package 手撕;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: twc
 * @Date 2021/7/14 18:31
 **/
public class expireMap {

     Map<String,String> map =new ConcurrentHashMap<>();
     Map<String,Long> timeMap =new ConcurrentHashMap<>();

     //双端时间队列
     Deque<Long> timeQuene = new LinkedList<>();

     //倒转map
    Map<Long,Queue<String>> reveseMap  = new ConcurrentHashMap<>();


     public synchronized void put(String key,String value){
         long curTime = System.currentTimeMillis();
         timeQuene.addLast(curTime);
         map.put(key,value);
         timeMap.put(key,curTime);

          //倒转map赋值，记录每一个时间戳下的value
         if (reveseMap.containsKey(value)) {
             Queue<String>  queue= reveseMap.get(value);
             queue.add(key);
         }else{
             Queue<String> queue= new LinkedList<>();
             queue.add(key);
             reveseMap.put(curTime,queue);
         }


         //找出所有时间队列中过期的key 及map容器中对应的数据并删除
         while(System.currentTimeMillis()-timeQuene.getFirst() >1000){
             Long despiseTime = timeQuene.pollFirst();
             Queue<String> queue = reveseMap.get(despiseTime);
             reveseMap.remove(despiseTime);
             while(!queue.isEmpty()){
                 String poll = queue.poll();
                 map.remove(poll);
                 timeMap.remove(poll);
             }
         }
     }
    public String get(String key){
        Long s = timeMap.getOrDefault(key,System.currentTimeMillis()-10001);
        //比较时间,超过10s则删除
        if ( System.currentTimeMillis()-s > 10000) {
             timeMap.remove(key);
             map.remove(key);
             return null;
        }else {
             return  map.getOrDefault(key,null);
        }
    }

    public boolean expire(String key,Long value){
        if (timeMap.containsKey(key)) {
            timeMap.put(key,value);
            return true;
        }
        return  false;
    }





}
