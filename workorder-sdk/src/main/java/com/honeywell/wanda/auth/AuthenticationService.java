package com.honeywell.wanda.auth;

import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.common.collect.Lists;

public class AuthenticationService {
	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);
	private String serviceRoot;
	protected WebClient client;

	private static final long CONNECTION_TIMEOUT = 120000L;
	private static final long RECEIVE_TIMEOUT = 120000L;

	public AuthenticationService(String serviceUrl, String userId, String pwd) {
		this.serviceRoot = serviceUrl;
		client = WebClient.create(serviceRoot, Lists.newArrayList(new JacksonJsonProvider()));
		WebClient.getConfig(client).getHttpConduit().getClient().setAllowChunking(false);
		WebClient.getConfig(client).getHttpConduit().getClient().setConnectionTimeout(CONNECTION_TIMEOUT);
		WebClient.getConfig(client).getHttpConduit().getClient().setReceiveTimeout(RECEIVE_TIMEOUT);

		client.type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		// client.header(GlobalContext.SITE,
		// GlobalContext.getInstance().getConfig().getSite().getId());
		client.header("usrid", userId);
		client.header("pwd", pwd);
	}

	public AuthCookie get() {
		AuthCookie result = null;
		try {
//			Response response = client.get();
//			result = response.readEntity(AuthCookie.class);
			result = client.get(AuthCookie.class);
			LOG.info("Get cookie successfully:{}, expired on {}", result.getCookieValue(), result.getExpDate());
		} catch (Exception e) {
			LOG.error("Can not get cookie");
			LOG.error(e.getMessage());
		}

		return result;
	}

	public Map<String, Cookie> getCookie() {

		return WebClient.getConfig(client).getHttpConduit().getCookies();
	}

}
