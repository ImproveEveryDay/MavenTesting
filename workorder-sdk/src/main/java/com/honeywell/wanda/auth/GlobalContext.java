package com.honeywell.wanda.auth;

import java.io.IOException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.honeywell.wanda.model.ConnectionInfo;

public class GlobalContext {
	private static final String DEFAULT_CONFIG_FILE = "connection.conf";
	public static final String SITE = "Site";
	public static final String COOKIE_NAME = "GuomaoAuth";//GuomaoAuth
	private static final Logger LOG = LoggerFactory.getLogger(GlobalContext.class);
	public static ConnectionInfo connectionInfo;

//	public ConnectionInfo getConnectionInfo() {
//		return connectionInfo;
//	}

//	public void setConnectionInfo(ConnectionInfo connectionInfo) {
//		this.connectionInfo = connectionInfo;
//	}
	
	public static ConnectionInfo readConnectionInfo() {
		try {
			/*
			 * File confFile = new File(conf); LOG.info("configuration file: {}"
			 * , confFile.getCanonicalPath()); String content =
			 * Files.asCharSource(confFile, Charsets.UTF_8).read();
			 */
			URL url = Resources.getResource(DEFAULT_CONFIG_FILE);
			LOG.info("configuration file: {}", url.getFile());
			String content = Resources.toString(url, Charsets.UTF_8);
			LOG.debug("{}", content);
			Gson gson = new Gson();
			connectionInfo = gson.fromJson(content, ConnectionInfo.class);
			return connectionInfo;
		} catch (IOException e) {
			LOG.error("error reading configuration file: {}", e.toString());
		}
		return null;
	}
}
