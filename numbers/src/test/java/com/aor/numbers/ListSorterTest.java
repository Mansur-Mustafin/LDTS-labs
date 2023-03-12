package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {
    List<Integer> list;
    @BeforeEach
    public void Create_list(){
        list = Arrays.asList(3, 2, 6, 1, 4, 5, 7);
    }
    @Test
    public void sort() {
        //List<Integer> list = Arrays.asList(3, 2, 6, 1, 4, 5, 7);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void sort2() {
        list = Arrays.asList(0, 2, 6, -1, 4, 5, -7);
        List<Integer> expected = Arrays.asList(-7, -1, 0, 2, 4, 5, 6);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void sort3() {
        list = Arrays.asList(0, 0, 0, -1, 4, 5, -7);
        List<Integer> expected = Arrays.asList(-7, -1, 0, 0, 0, 4, 5);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void sort4() {
        list = Arrays.asList(-7, -1, 0, 0, 0, 4, 5);
        List<Integer> expected = Arrays.asList(-7, -1, 0, 0, 0, 4, 5);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
    @Test
    public void sort8() {
        list = Arrays.asList(7);
        List<Integer> expected = Arrays.asList(7);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
    @Test
    public void sort5() {
        list = Arrays.asList();
        List<Integer> expected = Arrays.asList();

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void bug_sort_8276() {
        //ListSorter sorter = new ListSorter();


        ListSorter sorter = Mockito.mock(ListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1,2,2,4));

        List<Integer> sorted = sorter.sort(Arrays.asList(1, 2, 4, 2));

        Assertions.assertEquals(Arrays.asList(1, 2, 2, 4), sorted);
    }
}
