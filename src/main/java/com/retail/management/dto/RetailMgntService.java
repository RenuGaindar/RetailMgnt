package com.retail.management.dto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retail.management.model.ResponseMessage;
import com.retail.management.model.Shop;
import com.retail.management.repository.RetailRepository;

@Service
public class RetailMgntService {
	private static final Logger logger = LoggerFactory.getLogger(RetailMgntService.class);
	@Autowired
	private RetailRepository repo;
	@Autowired
	private ResponseMessage responseMessage;
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<ResponseMessage>  add(Shop shop) {
		logger.info("RetailMgntService.add :: "+shop.getShopName());
		 
		 Shop exitShop  = repo.findByShopName(shop.getShopName());
		 if(exitShop==null){
			 repo.save(shop);
			 responseMessage.setSuccess("Record Added Successfully");
			 
		 }	 
		 else{
			 exitShop.setShopAddress(shop.getShopAddress());
			 repo.save(shop);
			 responseMessage.setSuccess("Record Updated Successfully");
		 }	 	 
		return	new ResponseEntity(responseMessage, HttpStatus.OK);
	
	}		
	
	public List<Shop>  findByShopName(Double latitude, Double longitude) {
		logger.info("RetailMgntService.findByShopName :: "+latitude +" "+longitude);
		  
		List<Shop>  shop =repo.findByLatitudeAndLongitude(latitude,  longitude);
		shop.forEach(l->logger.info("RetailMgntService.findByShopName Data Fetched :: "+l));
		
		return	shop;
	
	}		
}
