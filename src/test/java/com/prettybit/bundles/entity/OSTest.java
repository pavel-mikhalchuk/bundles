package com.prettybit.bundles.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Mikhalchuk
 */
public class OSTest {

    @Test
    public void testEquals() {
        assertEquals(new MacOS(), new MacOS());
        assertEquals(new Linux(), new Linux());
        assertEquals(new Windows(), new Windows());
    }

}