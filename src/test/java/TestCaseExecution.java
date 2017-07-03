
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.management.dto.RetailMgntService;
import com.retail.management.model.Address;
import com.retail.management.model.ResponseMessage;
import com.retail.management.model.Shop;
import com.retail.management.service.RetailManagementService;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = RetailManagementService.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class TestCaseExecution {
	
	private static final Logger logger = LoggerFactory.getLogger(TestCaseExecution.class);
	@LocalServerPort
	private int port;


	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void AddingFirstShop() throws Exception {
		
		logger.info("In AddingFirstShop Test ");
		RetailMgntService shopDao = new RetailMgntService();
		Shop shop = new Shop();
		shop.setLatitude(21.2);
		shop.setLongitude(22.6);
		shop.setShopName("TestShop1");
		Address address = new Address();
		address.setAddress("Address Line 1");
		address.setCity("Pune");
		address.setPostCode("344100");
		address.setNumber(1);
		
		shop.setShopAddress(address);
		
		ResponseEntity<ResponseMessage> e =shopDao.add(shop);
		logger.info("In Response Data AddingFirstShop Test:: "+e.getBody());
		assertEquals(e.getBody().getSuccess().contains("Successfully"), true);
	}
	@Test
	public void getdata() throws Exception {
		logger.info("In getdata Test:: "+port+" "+testRestTemplate.toString());
		ResponseEntity<Shop> response = testRestTemplate.getForEntity("http://localhost:8083/retail?lat=22.1&lon=26.1", Shop.class);
		logger.info("Data Fetched :: "+response.getBody().getShopName());
		assertEquals(response.getBody().getShopName().contains("TestShop1"), true);
		
		
	
	}
}
