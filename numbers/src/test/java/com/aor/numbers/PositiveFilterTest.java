package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {

    PositiveFilter filtro = new PositiveFilter();
    boolean res;


    @Test
    public void Accrpt(){
        Integer testnumber = 10;
        res = filtro.accept(testnumber);
        Assertions.assertEquals(true, res);
    }

    @Test
    public void Accrpt2(){
        Integer testnumber = -5;
        res = filtro.accept(testnumber);
        Assertions.assertEquals(false, res);
    }

    @Test
    public void Accrpt3(){
        Integer testnumber = 0;
        res = filtro.accept(testnumber);
        Assertions.assertEquals(false, res);
    }

}
