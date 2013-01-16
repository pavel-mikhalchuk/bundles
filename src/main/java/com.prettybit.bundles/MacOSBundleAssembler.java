package com.prettybit.bundles;

import com.prettybit.bundles.entity.Bundle;
import com.prettybit.bundles.entity.Java;
import com.prettybit.bundles.entity.Maven;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static com.google.common.collect.Maps.toMap;

/**
 * @author Pavel Mikhalchuk
 */
public class MacOSBundleAssembler implements BundleAssembler {

    private static Map<Java.Version, String> java = toMap(Java.Version.list(), Java.Version.getFileFunction());
    private static Map<Maven.Version, String> maven = toMap(Maven.Version.list(), Maven.Version.getFileFunction());

    @Override
    public File assemble(Bundle bundle) {
        File j = bundle.getJava() != null ? new File(java.get(bundle.getJava().getVersion())) : null;
        File m = bundle.getMaven() != null ? new File(maven.get(bundle.getMaven().getVersion())) : null;
        return zip(j, m);
    }

    private File zip(File java, File maven) {
        try {
            File zip = new File("/Users/pacan/bundles/bundle.zip");
            zip.delete();

            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zip.getAbsoluteFile()));
            put(java, zos);
            put(maven, zos);
            zos.close();

            return zip;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void put(File file, ZipOutputStream zos) throws IOException {
        if (file != null) {
            FileInputStream fis = new FileInputStream(file);
            zos.putNextEntry(new ZipEntry(file.getName()));
            IOUtils.copy(fis, zos);
            fis.close();
            zos.closeEntry();
        }
    }

}
