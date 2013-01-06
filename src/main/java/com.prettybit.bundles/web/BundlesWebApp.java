package com.prettybit.bundles.web;

import com.google.common.collect.Lists;
import com.prettybit.bundles.BundleAssembler;
import com.prettybit.bundles.LinuxBundleAssembler;
import com.prettybit.bundles.MacOSBundleAssembler;
import com.prettybit.bundles.WindowsBundleAssembler;
import com.prettybit.bundles.entity.Linux;
import com.prettybit.bundles.entity.MacOS;
import com.prettybit.bundles.entity.Windows;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.Binder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ApplicationHandler;
import org.glassfish.jersey.server.ResourceConfig;

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
            bind(MacOSBundleAssembler.class).to(BundleAssembler.class).named(MacOS.class.getSimpleName()).in(Singleton.class);
            bind(LinuxBundleAssembler.class).to(BundleAssembler.class).named(Linux.class.getSimpleName()).in(Singleton.class);
            bind(WindowsBundleAssembler.class).to(BundleAssembler.class).named(Windows.class.getSimpleName()).in(Singleton.class);
            bind(BundleParameterConverterProvider.class).to(ParamConverterProvider.class).in(Singleton.class);
            bind(BundleAssemblerInjectionResolver.class).to(new TypeLiteral<InjectionResolver<OSBundleAssembler>>() {
            }).in(Singleton.class);
        }

    }

}