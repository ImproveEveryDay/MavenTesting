package com.honeywell.wanda.auth;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.http.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.common.collect.Lists;

public class GenerateClient {
	public WebClient client;

	private static final Logger LOG = LoggerFactory.getLogger(GenerateClient.class);

	public GenerateClient(String apiUrl, int siteId) {
		client = WebClient.create(apiUrl, Lists.newArrayList(new JacksonJsonProvider()));
		client.type(MediaType.APPLICATION_JSON);
//		.accept(MediaType.APPLICATION_JSON);
		// add HTTP headers to the web service request
		client.header(GlobalContext.SITE, siteId);

		WebClient.getConfig(client).getHttpConduit().getClient().setAllowChunking(false);
		// WebClient.getConfig(client).getHttpConduit().getClient().setConnectionTimeout(CONNECTION_TIMEOUT);
		// WebClient.getConfig(client).getHttpConduit().getClient().setReceiveTimeout(RECEIVE_TIMEOUT);
		// add Cookie
		WebClient.getConfig(client).getRequestContext().put(Message.MAINTAIN_SESSION, Boolean.TRUE);
		Cookie activeCookie = new Cookie(GlobalContext.COOKIE_NAME, getCookie());
		WebClient.getConfig(client).getHttpConduit().getCookies().put(GlobalContext.COOKIE_NAME, activeCookie);
	}

	private String getCookie() {
		AuthenticationService authenticationService = new AuthenticationService(GlobalContext.connectionInfo.getServiceUrl(),
				GlobalContext.connectionInfo.getUserName(), GlobalContext.connectionInfo.getPassword());
		AuthCookie authCookie = authenticationService.get();
		String cookie = authCookie.getCookieValue();
		return cookie;
	}
}
