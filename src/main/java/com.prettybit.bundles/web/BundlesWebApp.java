package com.prettybit.bundles.web;

import com.google.common.collect.Lists;
import com.prettybit.bundles.BundleAssembler;
import com.prettybit.bundles.MacBundleAssembler;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.Binder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ApplicationHandler;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.ext.ParamConverterProvider;

/**
 * @author Pavel Mikhalchuk
 */
public class BundlesWebApp extends ResourceConfig {

    @Inject
    public BundlesWebApp(ApplicationHandler handler) {
        handler.registerAdditionalBinders(serviceBinder());
    }

    private Iterable<Binder> serviceBinder() {
        return Lists.<Binder>newArrayList(new ServiceBinder());
    }

    private class ServiceBinder extends AbstractBinder {

        @Override
        protected void configure() {
            bind(MacBundleAssembler.class).to(BundleAssembler.class).in(Singleton.class);
            bind(BundleParamValueFactoryProvider.class).to(ValueFactoryProvider.class).in(Singleton.class);
            bind(BundleInjectionResolver.class).to(new TypeLiteral<InjectionResolver<RequestedBundle>>() {
            }).in(Singleton.class);
            bind(BundleParameterConverterProvider.class).to(ParamConverterProvider.class).in(Singleton.class);
        }

    }

}