package com.mdmytriaha;

import com.mdmytriaha.controllet.HomeController;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HomeControllerTest {

    @Test
    public void testApp() {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals(result, "Hello to test application");
    }
}
