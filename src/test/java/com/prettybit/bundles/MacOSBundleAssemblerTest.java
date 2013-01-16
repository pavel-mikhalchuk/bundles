package com.prettybit.bundles;

import com.prettybit.bundles.entity.Bundle;
import com.prettybit.bundles.entity.Java;
import com.prettybit.bundles.entity.Maven;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Pavel Mikhalchuk
 */
public class MacOSBundleAssemblerTest {

    private MacOSBundleAssembler assembler = new MacOSBundleAssembler();

    @Test
    public void testAssembleJava() {
        assertTrue(assembler.assemble(new Bundle(new Java(Java.Version.JSE_7_U10_MAC_OS_X_68))).exists());
        assertTrue(assembler.assemble(new Bundle(new Maven(Maven.Version.MVN_2_0_10))).exists());
        assertTrue(assembler.assemble(new Bundle(new Java(Java.Version.JSE_7_U10_MAC_OS_X_68), new Maven(Maven.Version.MVN_2_0_10))).exists());
    }

}