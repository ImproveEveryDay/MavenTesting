package com.honeywell.wanda.auth;

import java.util.Map;

import javax.ws.rs.core.Response;
import org.apache.cxf.transport.http.Cookie;
import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.honeywell.wanda.model.PassParameters;
import com.honeywell.wanda.model.ProcessWorkOrderResponse;

public class PassWorkOrder {
	private static final Logger LOG = LoggerFactory.getLogger(PassWorkOrder.class);
	
	public static ProcessWorkOrderResponse process(PassParameters passParameters){
		return processWorkorder(passParameters);
	}
	
	public static ProcessWorkOrderResponse process(String sTATUS, String wONUM, String lYRWBH, String sITEID, String dESCRIPTION, String tSTIME,
			String lY, String lEAD, String uRL){
		PassParameters passParameters = new PassParameters(sTATUS, wONUM, lYRWBH, sITEID, dESCRIPTION, tSTIME, lY, lEAD, uRL);
		return process(passParameters);
	}
	
	private static ProcessWorkOrderResponse processWorkorder(PassParameters passParameters){
		GlobalContext.readConnectionInfo();		
		GenerateClient generateClient = new GenerateClient(GlobalContext.connectionInfo.getApiUrl(), Integer.parseInt(passParameters.getSITEID()));
		WebClient client =  generateClient.client;
		ProcessWorkOrderResponse response = null;
		
		Map<String, Cookie> map = WebClient.getConfig(client).getHttpConduit().getCookies();
		
		try{
			Response res = client.post(passParameters);
			int status = res.getStatus();
//			response = client.post(passParameters, ProcessWorkOrderResponse.class);
//			response = res.readEntity(ProcessWorkOrderResponse.class);
			String str = res.readEntity(String.class);
			if(status != 200) {
				LOG.error("request failed, status: {}", Integer.toString(status));
				return null;
			}
			response = new Gson().fromJson(str, ProcessWorkOrderResponse.class);
			LOG.info("get response successfully, response code: {}, response description: {}", response.getRETCODE(), response.getDESCRIPTION());
		}
		catch(Exception e){
			LOG.error("failed to get response");
			LOG.error(e.getMessage());
		}		
		return response;
	}
}
