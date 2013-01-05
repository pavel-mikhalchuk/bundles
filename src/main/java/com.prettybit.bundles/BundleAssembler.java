package com.prettybit.bundles;

import com.prettybit.bundles.entity.Bundle;

import java.io.File;

/**
 * @author Pavel Mikhalchuk
 */
public interface BundleAssembler {

    File assemble(Bundle bundle);

}