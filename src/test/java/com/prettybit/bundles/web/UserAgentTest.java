package com.prettybit.bundles.web;

import com.prettybit.bundles.entity.Linux;
import com.prettybit.bundles.entity.MacOS;
import com.prettybit.bundles.entity.UserAgent;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Pavel Mikhalchuk
 */
public class UserAgentTest {

    @Test
    public void testGetOsFromHeader() {
        assertEquals(new MacOS(), new UserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:17.0) Gecko/20100101 Firefox/17.0").getOs());
        assertEquals(new MacOS(), new UserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:17.0) Gecko/20100101 Firefox/17.0".toLowerCase()).getOs());

        assertEquals(new Linux(), new UserAgent("Mozilla/5.0 (X11; U; Linux; i686; en-US; rv:1.6) Gecko Galeon/1.3.14").getOs());
        assertEquals(new Linux(), new UserAgent("Mozilla/5.0 (X11; U; Linux; i686; en-US; rv:1.6) Gecko Galeon/1.3.14".toLowerCase()).getOs());
    }

}