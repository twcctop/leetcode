package 算法训练营覃超题目;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: twc
 * @Date 2021/3/15 16:17
 **/
public class _10贪心算法 {
    /**
     * @Description
     * @Date 2021/3/22 18:21
     **/
    @Test
    public void test322() {
     int[]   coins = {1, 2, 5}
     ;
     int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    /**
     * @Description
     * @Date 2021/3/22 19:00
     **/
    @Test
    public void test806() {
//        int[] a={5,5,5,10,20} ;
//        int[] a={5,5,10,10,20} ;
        int[] a={5,5,5,5,10,5,10,10,10,20} ;

//        int[] a={10,10} ;
        System.out.println(lemonadeChange(a));
    }

    public boolean lemonadeChange(int[] bills) {
         Map<Integer, Integer> cash = new HashMap<>();
        for (int i = 0; i < bills.length; i++){
            if (bills[i]==5) {
                putMap(cash,5);
            }
            if (bills[i]==10) {
                if (cash.containsKey(5)) {
                    putMap(cash,10);
                    boolean b = removeMapOne(cash, 5);
                    if (!b){
                        return false;
                    }
                }else {
                    return  false;
                }

            }
            if (bills[i]==20) {
                if (cash.containsKey(10)&&cash.get(10)>0) {
                    removeMapOne(cash,10);
                    if (cash.containsKey(5)&&cash.get(5)> 0){
                        removeMapOne(cash,5);
                    }else {
                        return false;
                    }
                }else{
                    if (cash.containsKey(5)&&cash.get(5)>2){
                        removeMapOne(cash,5);
                        removeMapOne(cash,5);
                        removeMapOne(cash,5);
                    }else {
                        return  false;
                    }
                }
            }
        }
        return true;
    }


    private boolean removeMapOne(Map<Integer, Integer> cash, int i) {
        if (cash.containsKey(i)) {
            Integer count = cash.get(i);
            if (count==1) {
                 cash.remove(i);
            }else {
                 cash.put(i,count-1);
            }
            return true;
        }else {
             return  false;
        }
    }

    private void putMap(Map<Integer, Integer> cash, int i) {
        if (cash.containsKey(i)) {
            cash.put(i,cash.get(i)+1);
        }else {
             cash.put(i,1);
        }
    }

    /**
     * @Description
     * @Date 2021/3/23 16:48
     **/
    @Test
    public void test122() {
//        int[] a= {1,2,3,4,5};
        int[] a= {1,2,3};
//        System.out.println(maxProfit(a));

        System.out.println(maxProfit2(a));
    }

    public int maxProfit(int[] prices) {
        int max[]={0};
        int res[]={0};
        List<ProfitEntity> list = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                 if(prices[j]>prices[i]){
                     ProfitEntity entity = new ProfitEntity();
                     entity.setStart(i);
                     entity.setEnd(j);
                     entity.setProfit(prices[j]-prices[i]);
                     list.add(entity);
                 }
            }
        }
        if (list.size()==0) {
            return 0;
        }
        List<ProfitEntity> entityList = list.stream().sorted(Comparator.comparing(ProfitEntity::getStart)).collect(Collectors.toList());
        getMaxProfit(res,max,entityList,0);
        return  res[0];
    }

    private void getMaxProfit(int[] res, int[] max, List<ProfitEntity> entityList, int end) {

        int start = -1;
        for (ProfitEntity entity : entityList) {
            if (entity.getStart()>= end) {
                start= entity.getStart();
                break;
            }
        }
        if (start==-1) {
            res[0]= Math.max(res[0], max[0]);
             return;
        }
        int reachFlag=0;
        for (ProfitEntity entity : entityList) {
            // 从锚点开始计算
            if (entity.getStart()>= start) {
                reachFlag=1;
                max[0]= max[0]+entity.getProfit();
                getMaxProfit(res,max ,entityList,entity.getEnd());
            }
        }
         if (reachFlag==0){
              res[0]= Math.max(res[0], max[0]);
         }
    }


    static class ProfitEntity{
        int start;
        int end;
        int profit;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }
    }

    // 贪心算法
    public int maxProfit2(int[] prices) {
         int ans = 0;
        for (int i = 1; i < prices.length; i++) {

              ans= ans+ Math.max(0, prices[i] - prices[i - 1]);

        }
        return  ans;

    }

    /**
     * @Description
     * @Date 2021/3/23 18:50
     **/
    @Test
    public void test455() {

    }
    public int findContentChildren(int[] g, int[] s) {
        //胃口
        Arrays.sort(g);
        //饼干
        Arrays.sort(s);
        int gcount=0;

        for (int i = 0; i < s.length; i++) {
            if (s[i]>=g[gcount]) {
                gcount++;
                if (gcount== g.length) {
                    return gcount;
                }
            }
        }
        return gcount;
    }

    /**
     * @Description  commands = [4,-1,4,-2,4], obstacles = [[2,4]]
     * @Date 2021/3/24 9:44
     **/
    @Test
    public void test874() {
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        //向右距离， 向上距离
        int x=0, y=0;
        // 方向  0 north 1 earth  2 south 3 west
        int  direc =0;

        //  接受命令
        for (int i = 0; i < commands.length; i++) {
             // 右转
            if (commands[i] ==-1) {
                direc = direc==3? 0:direc+1;

            } // 左转
            else if(commands[i]==-2){
                    direc= direc-2<0? 4+direc-2:direc-2;
            }// 直行
            else {
                //横向
                //东
                if (direc==1) {
                    for (int r = 0; r < obstacles.length; r++) {
                        for (int c = 0; c < obstacles[0].length; c++) {
                            int modix =x+commands[i];
                                  if(c==y && x<=r && r<= modix){

                                       break;
                                  }
                            
                        }
                    }


                     x=  x+commands[i];
                }else if(direc == 3){

                }
                // 纵向
            }
        }
        return  01;
    }


    /**
     * @Description
     * @Date 2021/3/24 11:57
     **/
    @Test
    public void test55() {
         int[] nums={2,3,1,1,4};
         int[] nums2={3,2,1,0,4};
         int[] nums3={0};
         int[] nums4={0,1};
         int[] nums5={2,0,0};

        System.out.println(canJumpOfficial(nums));
        System.out.println(canJumpOfficial(nums2));
        System.out.println(canJumpOfficial(nums3));
        System.out.println(canJumpOfficial(nums5));
    }

    public boolean canJump(int[] nums) {
        int maxlen= 0;
        for (int i = 0; i < nums.length; i++) {
            maxlen= i+nums[i];
            if (maxlen >=nums.length) {
                 return  true;
            }
            for (int j = i+1; j < maxlen; j++) {
                if (nums[j] +  j> maxlen) {
                      maxlen=  nums[j]+j;
                      i=j;
                      continue;
                }
            }
        }
         return maxlen>=nums.length;
    }
    public boolean canJump2(int[] nums) {
         int  maxlen=0,i=0;
         boolean canjump=true;
        while(canjump){
            maxlen= i+nums[i];
            if (maxlen >=nums.length) {
                return  true;
            }
            for (int j = i+1; j < maxlen; j++) {
                if (nums[j] +  j> maxlen) {
                    maxlen=  nums[j]+j;
                    i=j;
                    continue;
                }
                if (j==maxlen-1) {
                     return  false;
                }
            }

        }
         return true;
    }


    public boolean canJumpOfficial(int[] nums) {
        if (nums.length==0||nums.length==1) {
            return true;
        }
         int maxlen= 0;
        for (int i = 0; i < nums.length; i++) {
            if (i<=maxlen) {
                   maxlen= Math.max(maxlen,i+nums[i]);
            }
        }
        return    maxlen>=nums.length-1;
    }
}
