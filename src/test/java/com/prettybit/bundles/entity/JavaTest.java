package com.prettybit.bundles.entity;

import org.junit.Test;

import static com.prettybit.bundles.entity.Java.Version.JSE_7_U10_MAC_OS_X_68;
import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Mikhalchuk
 */
public class JavaTest {

    @Test
    public void testEquals() {
        assertEquals(new Java(JSE_7_U10_MAC_OS_X_68), new Java(JSE_7_U10_MAC_OS_X_68));
    }

}