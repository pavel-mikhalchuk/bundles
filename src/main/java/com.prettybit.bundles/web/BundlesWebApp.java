package com.prettybit.bundles.web;

import com.google.common.collect.Lists;
import com.prettybit.bundles.BundleAssembler;
import com.prettybit.bundles.MacBundleAssembler;
import org.glassfish.hk2.utilities.Binder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ApplicationHandler;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Inject;
import javax.inject.Singleton;

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
        }

    }

}