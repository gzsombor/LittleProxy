/**
 *
 */
package org.littleshoot.proxy;

/**
 * @author Zsombor Gegesy
 *
 */
public class ProxyServerAddress extends ServerAddress {

	final String proxyUser;
	final String proxyPassword;

	public ProxyServerAddress(String hostAndPort, String proxyUser,
			String proxyPassword) {
		super(hostAndPort);
		this.proxyUser = proxyUser;
		this.proxyPassword = proxyPassword;
	}

	public ProxyServerAddress(String hostAndPort) {
		this(hostAndPort, null, null);
	}

	@Override
	public boolean isProxy() {
		return true;
	}

	public String getProxyPassword() {
		return proxyPassword;
	}

	public String getProxyUser() {
		return proxyUser;
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
		result = prime * result
				+ ((proxyPassword == null) ? 0 : proxyPassword.hashCode());
		result = prime * result
				+ ((proxyUser == null) ? 0 : proxyUser.hashCode());
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
		ProxyServerAddress other = (ProxyServerAddress) obj;
		if (hostAndPort == null) {
			if (other.hostAndPort != null)
				return false;
		} else if (!hostAndPort.equals(other.hostAndPort))
			return false;
		if (proxyPassword == null) {
			if (other.proxyPassword != null)
				return false;
		} else if (!proxyPassword.equals(other.proxyPassword))
			return false;
		if (proxyUser == null) {
			if (other.proxyUser != null)
				return false;
		} else if (!proxyUser.equals(other.proxyUser))
			return false;
		return true;
	}

}
