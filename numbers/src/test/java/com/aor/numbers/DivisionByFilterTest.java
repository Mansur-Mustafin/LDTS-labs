package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisionByFilterTest {
    Integer i;
    boolean res;
    Integer div = 2;

    DivisibleByFilter filt;



    @Test
    public void Test(){
        i = 10;
        filt = new DivisibleByFilter(div);
        res = filt.accept(i);
        Assertions.assertEquals(true, res);
    }

    @Test
    public void Test2(){
        i = 10;
        filt = new DivisibleByFilter(3);
        res = filt.accept(i);
        Assertions.assertEquals(false, res);
    }

    @Test
    public void Test3(){
        i = -10;
        filt = new DivisibleByFilter(3);
        res = filt.accept(i);
        Assertions.assertEquals(false, res);
    }
    @Test
    public void Test4(){
        i = -10;
        filt = new DivisibleByFilter(2);
        res = filt.accept(i);
        Assertions.assertEquals(true, res);
    }

}

