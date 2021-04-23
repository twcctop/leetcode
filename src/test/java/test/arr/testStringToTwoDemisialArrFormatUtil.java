package test.arr;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import util.ArrayUtil;

import java.util.Arrays;

/**
 * @Author: twc
 * @Date 2021/4/23 10:19
 **/
public class testStringToTwoDemisialArrFormatUtil {
    @Test
    public  void testStringFormatUtil(){
        String  ss="[\n" +
                "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
                "]\n" +
                "\n" ;

       ArrayUtil.printTwoDemimalCharArray(ArrayUtil.convertStringCharTwoDimensionArray(ss)
       );
    }

}
