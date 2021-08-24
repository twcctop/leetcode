package leetbook._04_高级算法;

public class _01_数组和字符串 {

    // 除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left =new int[length];
        int[] right= new int[length];
        int[] res= new int[length];

        left[0]=1;
        for (int i = 1; i < left.length; i++) {
             left[i]= nums[i-1]*left[i-1];
        }

        right[length-1]=1;
        for (int i = length-2; i>=0; i--) {
             right[i]= nums[i+1]* right[i+1];
        }


        for (int i = 0; i < length; i++) {
            res[i]=left[i]*right[i];
        }

        return res;

    }


}
