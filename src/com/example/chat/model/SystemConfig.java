package com.example.chat.model;

/**
 * 系统常用配置实体
 * 
 * @author Administrator
 *
 */
public class SystemConfig {
//	private String host;
//	private int port;
//	private String serverName;
	private String account;
	private String password;
	private String sessionId;	//会话id
//	/**
//	 * 用户使用的是哪种终端登录，如果Android手机、iPhone、web等等
//	 */
//	private String resource;
	private boolean isOnline;	//是否连接成功
	private boolean isFirstLogin;	//是否是首次登录

	/*public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}*/

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public boolean isFirstLogin() {
		return isFirstLogin;
	}

	public void setFirstLogin(boolean isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}

	/*public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}*/

}
