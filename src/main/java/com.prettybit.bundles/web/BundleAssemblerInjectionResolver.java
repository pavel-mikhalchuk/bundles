package com.prettybit.bundles.web;

import com.prettybit.bundles.BundleAssembler;
import com.prettybit.bundles.entity.OS;
import com.prettybit.bundles.entity.UserAgent;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;
import org.glassfish.hk2.api.ServiceLocator;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.core.HttpHeaders;

/**
 * @author Pavel Mikhalchuk
 */
public class BundleAssemblerInjectionResolver implements InjectionResolver<OSBundleAssembler> {

    @Inject
    private Provider<HttpHeaders> headers;

    @Inject
    private ServiceLocator locator;

    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> root) {
        OS os = new UserAgent(headers.get().getHeaderString("user-agent")).getOs();
        return locator.getService(BundleAssembler.class, os.getClass().getSimpleName());
    }

    @Override
    public boolean isConstructorParameterIndicator() {
        return false;
    }

    @Override
    public boolean isMethodParameterIndicator() {
        return false;
    }

}