package 算法训练营覃超题目;

import entity.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * @Author: twc
 * @Date 2021/3/9 16:44
 **/
public class _03数组链表 {









    //k个一组反转链表
    @Test
    public void test25(){

    }
    public ListNode reverseKGroup(ListNode head, int k) {


        return null;
    }



    /**
     *  home work部分
     */


    @Test
    public void test26(){

    }

    public int removeDuplicates(int[] nums) {
        int  slow = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[slow]) {
                slow++;
                nums[slow]=nums[i];
            }
        }
        return slow+1;
    }



    @Test
    public void test189() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        rotate(a, 3);
        System.out.println(a[3]);

    }

    public void rotate(int[] nums, int k) {

        int[] clone = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int offset = i - k;
            if (offset < 0) {
                offset = offset + nums.length;
            }
            nums[i] = clone[offset];
        }
    }

    @Test
    public void test88() {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        merge(a, 3, b, 3);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numsRes = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            if (i < m) {
                if (nums1[i] == 0) continue;
                numsRes[i] = nums1[i];

            } else {
                if (nums2[i - m] == 0) continue;
                numsRes[i] = nums2[i - m];
            }

        }
        nums1 = numsRes;
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, m, nums1, n, m + n);
        Arrays.sort(nums1);
    }

    @Test
    public void test1() {
        int[] a = {2, 5, 5, 11};

        twoSum(a, 10);

    }

    public int[] twoSum(int[] nums, int target) {
        int[] numsOri = nums.clone();
        int[] res = {-1, -1};
        int[] resOri = new int[2];
        Arrays.sort(nums);
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            System.out.println("pre" + i + "#" + j);
            if (nums[nums.length - 1] + nums[i] - target < 0) {
                System.out.println("<0" + i);
                i++;
                j = i + 1;
            }

            if (nums[j] + nums[i] - target == 0) {
                System.out.println("=0" + i);
                int[] c = {nums[i], nums[j]};
                resOri = c;

            }
        }
        for (int k = 0; k < numsOri.length; k++) {
            if (resOri[0] == numsOri[k] || resOri[1] == numsOri[k]) {
                if (res[0] == -1) {
                    res[0] = k;
                } else {
                    res[1] = k;
                    return res;
                }
            }
        }
        return res;
    }

}
