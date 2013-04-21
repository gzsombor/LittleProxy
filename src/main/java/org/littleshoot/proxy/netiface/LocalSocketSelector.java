/**
 *
 */
package org.littleshoot.proxy.netiface;

import java.net.SocketAddress;

import org.jboss.netty.handler.codec.http.HttpRequest;

/**
 * Based on the request, picks a <b>local</b> socket address, where to bind the forwarding proxy request,
 * Use to pick the correct NetworkInterface
 *
 * @author Zsombor Gegesy
 *
 */
public interface LocalSocketSelector {
	SocketAddress getLocalSocketAddress(HttpRequest httpRequest);
}
