package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    List<Integer> list;
    List<Integer> expected;

    @BeforeEach
    public void Create_list(){
        list = Arrays.asList(1,2,3,4,5,6,6,7,-1,-2,-13);
    }

    @Test
    public void filter_pos(){
        expected = Arrays.asList(1,2,3,4,5,6,6,7);
        //PositiveFilter filt = new PositiveFilter();

        GenericListFilter filt = Mockito.mock(GenericListFilter.class);

        Mockito.when(filt.accept(1)).thenReturn(true);
        Mockito.when(filt.accept(2)).thenReturn(true);
        Mockito.when(filt.accept(3)).thenReturn(true);
        Mockito.when(filt.accept(4)).thenReturn(true);
        Mockito.when(filt.accept(5)).thenReturn(true);
        Mockito.when(filt.accept(6)).thenReturn(true);
        Mockito.when(filt.accept(7)).thenReturn(true);
        Mockito.when(filt.accept(-1)).thenReturn(false);
        Mockito.when(filt.accept(-2)).thenReturn(false);
        Mockito.when(filt.accept(-13)).thenReturn(false);

        ListFilterer filter = new ListFilterer(filt);
        Assertions.assertEquals(expected,filter.filter(list) );
    }

    @Test
    public void filter_div(){
        expected = Arrays.asList(2,4,6,6,-2);

        GenericListFilter filt = Mockito.mock(GenericListFilter.class);

        //DivisibleByFilter D = new DivisibleByFilter(2);

        Mockito.when(filt.accept(1)).thenReturn(false);
        Mockito.when(filt.accept(2)).thenReturn(true);
        Mockito.when(filt.accept(3)).thenReturn(false);
        Mockito.when(filt.accept(4)).thenReturn(true);
        Mockito.when(filt.accept(5)).thenReturn(false);
        Mockito.when(filt.accept(6)).thenReturn(true);
        Mockito.when(filt.accept(7)).thenReturn(false);
        Mockito.when(filt.accept(-1)).thenReturn(false);
        Mockito.when(filt.accept(-2)).thenReturn(true);
        Mockito.when(filt.accept(-13)).thenReturn(false);

        ListFilterer filter = new ListFilterer(filt);

        Assertions.assertEquals(expected,  filter.filter(list)  );
    }

}
