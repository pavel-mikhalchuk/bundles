package com.prettybit.bundles.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Mikhalchuk
 */
public class BundleTest {

    @Test
    public void testEquals() {
        assertEquals(new Bundle(new Java("1.7")), new Bundle(new Java("1.7")));
    }

}