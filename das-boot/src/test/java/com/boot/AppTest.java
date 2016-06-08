package com.boot;

import com.boot.controllet.HomeController;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AppTest {

    @Test
    public void testApp() {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals(result, "Das Boot, reporting for duty!");
    }
}
