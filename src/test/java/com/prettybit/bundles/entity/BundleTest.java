package com.prettybit.bundles.entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Mikhalchuk
 */
public class BundleTest {

    @Test
    public void testEquals() {
        assertEquals(new Bundle(new Java(Java.Version.JSE_7_U10_MAC_OS_X_68)), new Bundle(new Java(Java.Version.JSE_7_U10_MAC_OS_X_68)));
        assertEquals(new Bundle(new Maven(Maven.Version.MVN_2_0_10)), new Bundle(new Maven(Maven.Version.MVN_2_0_10)));
        assertEquals(new Bundle(new Java(Java.Version.JSE_7_U10_MAC_OS_X_68), new Maven(Maven.Version.MVN_2_0_10)),
                new Bundle(new Java(Java.Version.JSE_7_U10_MAC_OS_X_68), new Maven(Maven.Version.MVN_2_0_10)));
    }

}