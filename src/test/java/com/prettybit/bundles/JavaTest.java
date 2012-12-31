package com.prettybit.bundles;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Mikhalchuk
 */
public class JavaTest {

    @Test
    public void testEquals() {
        assertEquals(new Java("1.7"), new Java("1.7"));
    }

}