/**
 *
 */
package org.littleshoot.proxy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Zsombor Gegesy 
 *
 */
public class HostFilterTest {

    HostFilter hf;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        hf = new HostFilter("localhost, 127.0.0.1, *.somewhere.corp,198.0.*, hudson*");
    }

    @Test
    public void test() {
        System.out.println("host filter is "+ hf);
        assertTrue("localhost", hf.match("localhost"));
        assertFalse("facebook.com", hf.match("facebook.com"));
        assertTrue("127.0.0.1", hf.match("127.0.0.1"));
        assertTrue("server.somewhere.corp", hf.match("server.somewhere.corp"));
        assertTrue("hudson.com", hf.match("hudson.com"));
        assertTrue("198.0.173.32", hf.match("198.0.173.32"));
        assertFalse("198.1.173.32", hf.match("197.1.173.32"));
    }

}
