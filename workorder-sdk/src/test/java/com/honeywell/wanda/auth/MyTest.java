//package com.honeywell.wanda.auth;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import com.honeywell.wanda.model.PassParameters;
//import com.honeywell.wanda.model.ProcessWorkOrderResponse;
//
//public class MyTest {
//
//	@Test
//	public void test() {
////		//usage 1: pass an object
//////		  PassParameters passParameters = new PassParameters();
//////		  passParameters.setSTATUS("1");
//////		  passParameters.setWONUM("asdf");
//////		  passParameters.setLYRWBH("8df0d9c0-c152-46aa-ad5a-1b5de169887b");
//////		  passParameters.setSITEID("1");
//////		  passParameters.setDESCRIPTION("TTTTTTTT1");
//////		  passParameters.setTSTIME("2015-08-21T10:13:41.896");
//////		  passParameters.setLY("1");
//////		  passParameters.setLEAD("12333");
//////		  passParameters.setURL("http7777");
////		  
////		  //or pass string parameters one by one
//		  PassParameters passParameters = new PassParameters("1", "asdf", "8df0d9c0-c152-46aa-ad5a-1b5de169887b", "1", "TTTTTTTT1", "2015-08-21T10:13:41.896", "1", "12333", "http7777");
//		  
//		  ProcessWorkOrderResponse response = PassWorkOrder.process(passParameters);
//		  if(response != null) {
//			  String description = response.getDESCRIPTION();
//			  String retCode = response.getRETCODE();
//		  }
//	}
//
//}
