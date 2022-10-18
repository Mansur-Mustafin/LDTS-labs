package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivisionByFilterTest {
    Integer i;
    boolean res;
    Integer div = 2;

    DivisibleByFilter filt;

    @BeforeEach
    public void Construct(){
        i = 10;

    }

    @Test
    public void Test(){
        filt = new DivisibleByFilter(div);
        res = filt.accept(i);
        Assertions.assertEquals(true, res);

    }

    @Test
    public void Test2(){
        filt = new DivisibleByFilter(3);
        res = filt.accept(i);
        Assertions.assertEquals(false, res);
    }

}

