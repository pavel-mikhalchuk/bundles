package com.prettybit.bundles.web;

import com.prettybit.bundles.BundleAssembler;
import com.prettybit.bundles.entity.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.File;

/**
 * @author Pavel Mikhalchuk
 */
@Path("bundle")
public class BundleApi {

    private static final Logger log = LoggerFactory.getLogger(BundleApi.class);

    @OSBundleAssembler
    private BundleAssembler assembler;

    @POST
    @Path("get")
    public Response get(@FormParam("bundle") Bundle bundle) {
        return respond(assembler.assemble(bundle));
    }

    private Response respond(File bundle) {
        return Response.ok()
                .header("Content-Disposition", "attachment; filename=\"" + bundle.getName() + "\"")
                .entity(bundle)
                .build();
    }

}