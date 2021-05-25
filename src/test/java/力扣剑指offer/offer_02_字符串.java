package 力扣剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: twc
 * @Date 2021/5/21 15:52
 **/
public class offer_02_字符串 {

    //38 字符串的排列  回溯加剪肢
    public String[] permutation(String s) {
        List<String> resList = new ArrayList<>();
        char[] chars = s.toCharArray();
        List<Character>  charList =new ArrayList<>();
        for (char aChar : chars) {
              charList.add(aChar);
        }
        List<Character> curList =  new ArrayList<>();
        dfs38(charList,resList,curList);

        String[] res = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
             res[i]= resList.get(i);
        }

        return   res;
    }


    //todo  理解错题意了 字符串是可以重复的
    private void dfs38(List<Character> charList, List<String> resList, List<Character> curList) {
        if (charList.size()==curList.size()) {
            StringBuilder builder = new StringBuilder();
            for (Character character : curList) {
                 builder.append(character);
            }
            if (!resList.contains(builder.toString())) {
             resList.add(builder.toString());
            }
            return;
        }

//        List<Character>  newCharList= new ArrayList<>();
//        for (Character character : charList) {
//            if (!curList.contains(character)) {
//                 newCh
//            }
//        }

        for (Character character : charList) {
            List<Character> newList = new ArrayList<>();
            newList.addAll(curList);
            newList.add(character);
            dfs38(charList, resList, newList);
        }

    }


    //39
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return   nums[length/2];
    }

    //40
    public int[] getLeastNumbers(int[] arr, int k) {
          Arrays.sort(arr);
          int[] res= new int[k];
        for (int i = 0; i < k; i++) {
            res[i]= arr[i];
        }
        return  res;
    }
    //41  todo 双堆   list 结构超时
    class MedianFinder {
         List<Integer> list;
        /** initialize your data structure here. */
        public MedianFinder() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
            if (list.size()%2 ==0) {
                Integer integer = collect.get(collect.size() / 2);
                Integer integer2 = collect.get(collect.size() / 2 -1);
                Double aDouble = Double.valueOf(integer + integer2);
                return aDouble/ (double)2;
            }
            return  collect.get((collect.size()-1)/2);
        }
    }
    //41  todo 连续子数组最大和
    public int maxSubArray(int[] nums) {
        return  0;
    }
}
