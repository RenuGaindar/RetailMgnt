package com.retail.management.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.management.dto.RetailMgntService;
import com.retail.management.model.ResponseMessage;
import com.retail.management.model.Shop;

@RestController

public class RetailMgntController {

	private static final Logger logger = LoggerFactory.getLogger(RetailMgntController.class);

	
	@Autowired
	private RetailMgntService repo;
	@RequestMapping(value = "/retail", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody ResponseEntity<ResponseMessage> addShop(@RequestBody Shop shop) {

		logger.info("Retail addShop Service invoked :: "+shop.getShopName());
		
		
		return repo.add(shop);
	}
	@RequestMapping(value = "/retail", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public @ResponseBody List<Shop> getShopsOnGoogle(@QueryParam("lat") Double lat,@QueryParam("lon") Double lon) {

		logger.info("Retail getShopsOnGoogle Service invoked :: ");
		
		return repo.findByShopName(lat , lon);
	}


/*

	@ExceptionHandler({ NoRecordsFoundException.class })
	public String exceptionHandler(NoRecordsFoundException ex) {
		logger.info("Inside CustomerCreditController.exceptionHandler ");
		CustomMessages error = new CustomMessages();
		String response = new String();
		Document doc = ex.getDoc();
		error.addMessage("Error", "Invalid Data Provided - Metheod");
		response = createResponse.getResponse(doc, "RJCT");
		return response;

	}
*/
}
