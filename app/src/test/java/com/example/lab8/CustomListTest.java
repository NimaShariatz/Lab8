package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }//MockCityList

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }//addCityTest


    /**
     * add city to list, hasCity() will check if its empty. the assert checks if outcome is what is desired.
     */
    @Test
    public void hasCityTest(){
        list=MockCityList();
        list.addCity(new City("Moscow","Moscow Oblast"));
        assertEquals(list.hasCity(), true);

    }//hasCityTest

    /**
     * add city to list, delete it, then check if count is 0
     */
    @Test
    public void deleteCityTest(){
        list=MockCityList();
        list.addCity(new City("Moscow","Moscow Oblast"));
        int ItemCount = list.getCount();
        list.deleteCity(0);
        assertEquals(list.getCount(), ItemCount - 1);
    }//deleteCityTest


    /**
     * add 2 entries to list. check if 2 are added. delete then check count. delete then check count by assert.
     *
     */

    @Test
    public void countCitiesTest(){
        list=MockCityList();
        assertEquals(0,list.getCount());
        list.addCity(new City("Moscow","Moscow Oblast"));
        list.addCity(new City("Leningrad","Leningrad Oblast"));
        assertEquals(2,list.getCount());
        list.deleteCity(1);
        assertEquals(1,list.getCount());
        list.deleteCity(0);
        assertEquals(0,list.getCount());
    }//countCitiesTest


}
