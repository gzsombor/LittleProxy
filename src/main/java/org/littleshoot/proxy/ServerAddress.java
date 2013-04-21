/**
 *
 */
package org.littleshoot.proxy;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Zsombor Gegesy
 *
 */
public class ServerAddress {

	final String hostAndPort;

	public ServerAddress(String hostAndPort) {
		this.hostAndPort = hostAndPort;
	}

	public String getHostAndPort() {
		return hostAndPort;
	}

	public boolean isProxy() {
		return false;
	}

	public boolean isBlank() {
		return StringUtils.isBlank(hostAndPort);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hostAndPort == null) ? 0 : hostAndPort.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServerAddress other = (ServerAddress) obj;
		if (hostAndPort == null) {
			if (other.hostAndPort != null)
				return false;
		} else if (!hostAndPort.equals(other.hostAndPort))
			return false;
		return true;
	}


}
