package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @Author: twc
 * @Date 2021/4/23 11:53
 **/
public class testPassByValue {

    /**
     * @Description
     * @Date 2021/4/23 11:53
     **/
    @Test
    public void testPassByValueOrRefrence() {

        int a=1;
        changeIntNumber(a);
        assertThat(a,is(1));

        String s= "a";
        changeStringValue(s);
        assertThat(s,is("a"));

        AtomicInteger ai = new AtomicInteger(1);
        changeAtomicIntNumber(ai);
        assertThat(ai.get(),is(2));

        boolean flag =true;
        changeTrueToFalse(flag);
        assertThat(flag,is(true));

    }

    public void changeIntNumber(int  number){
        number= number+1;
    }
    public void changeStringValue(String str){
        str= str+ "AddedInfo";
    }
    public void changeAtomicIntNumber(AtomicInteger  number){
        number.set(number.addAndGet(1));
    }
    public void changeTrueToFalse(boolean flag){
          flag = false;
    }
}
