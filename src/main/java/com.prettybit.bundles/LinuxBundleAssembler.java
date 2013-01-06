package com.prettybit.bundles;

import com.prettybit.bundles.entity.Bundle;
import org.apache.commons.lang.NotImplementedException;

import javax.inject.Named;
import java.io.File;

/**
 * @author Pavel Mikhalchuk
 */
@Named("Linux")
public class LinuxBundleAssembler implements BundleAssembler {

    @Override
    public File assemble(Bundle bundle) {
        throw new NotImplementedException();
    }

}