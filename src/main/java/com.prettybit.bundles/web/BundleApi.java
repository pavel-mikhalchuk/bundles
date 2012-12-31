package com.prettybit.bundles.web;

import com.prettybit.bundles.BundleAssembler;
import com.prettybit.bundles.BundleParser;
import org.glassfish.hk2.api.ServiceLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author Pavel Mikhalchuk
 */
@Path("bundle")
public class BundleApi {

    private static final Logger log = LoggerFactory.getLogger(BundleApi.class);

    @Inject
    private BundleAssembler assembler;

    @Inject
    private ServiceLocator locator;

    @POST
    @Path("get")
    public Response get(@FormParam("bundle") String query) throws UnsupportedEncodingException {
        File bundle = assembler.assemble(BundleParser.parse(URLDecoder.decode(query, "UTF-8")));
        return respond(bundle.getAbsoluteFile());
    }

    private Response respond(File bundle) {
        return Response.ok()
                .header("Content-Disposition", "attachment; filename=\"" + bundle.getAbsolutePath() + "\"")
                .entity(bundle)
                .build();
    }

}