package com.prettybit.bundles.entity;

import org.junit.Test;

import static com.prettybit.bundles.entity.Maven.Version.MVN_2_0_10;
import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Mikhalchuk
 */
public class MavenTest {

    @Test
    public void testEquals() {
        assertEquals(new Maven(MVN_2_0_10), new Maven(MVN_2_0_10));
    }

}