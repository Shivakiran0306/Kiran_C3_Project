import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE
    @BeforeEach
    private void refactored_CreatRestaurant() {
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //-------FOR THE 2 TESTS BELOW, YOU MAY USE THE CONCEPT OF MOCKING, IF YOU RUN INTO ANY TROUBLE
    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE

        Restaurant spyRestaurant =Mockito.spy(restaurant);
        LocalTime mockedCurrentTime=LocalTime.parse("19:30:00");
        Mockito.when(spyRestaurant.getCurrentTime()).thenReturn(openTime);
        System.out.println(spyRestaurant.isRestaurantOpen());
        assertTrue(spyRestaurant.isRestaurantOpen());

    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){
        //WRITE UNIT TEST CASE HERE


        Restaurant spyRestaurant =Mockito.spy(restaurant);
        LocalTime mockedCurrentTime=LocalTime.parse("00:00:00");
        Mockito.when(spyRestaurant.getCurrentTime()).thenReturn(openTime);
        System.out.println(spyRestaurant.isRestaurantOpen());
        assertFalse(spyRestaurant.isRestaurantOpen());


    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){


        int initialMenuSize = restaurant.getMenu().size();
        restaurant.addToMenu("Sizzling brownie",319);

    }
    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws itemNotFoundException {


        int initialMenuSize = restaurant.getMenu().size();
        restaurant.removeFromMenu("Vegetable lasagne");
        assertEquals(initialMenuSize-1,restaurant.getMenu().size());
    }
    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {


        assertThrows(itemNotFoundException.class,
                ()->restaurant.removeFromMenu("French fries"));
    }
    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>BILL<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void returnTotalCost_returns_the_expected_Bill_amount()
    {

        int returnedBillAmount = restaurant.returnTotalCost("Vegetable lasagne","Sweet corn soup");
        //expectedBillAmount = 269 + 119 = 388
        assertEquals(388, returnedBillAmount);
    }
    //<<<<<<<<<<<<<<<<<<<<<<<BILL>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}