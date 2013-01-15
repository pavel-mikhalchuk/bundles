package com.prettybit.bundles;

import com.prettybit.bundles.entity.Bundle;
import com.prettybit.bundles.entity.Java;
import org.junit.Test;

/**
 * @author Pavel Mikhalchuk
 */
public class MacOSBundleAssemblerTest {

    private MacOSBundleAssembler assembler = new MacOSBundleAssembler();

    @Test
    public void testAssembleJava() {
        assembler.assemble(new Bundle(new Java(Java.Version.JSE_7_U10_MAC_OS_X_68)));
    }

}