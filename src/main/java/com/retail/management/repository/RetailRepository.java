package com.retail.management.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.retail.management.model.Shop;
@Transactional

public interface RetailRepository extends JpaRepository<Shop,Integer> {
	public Shop findByShopName(String shopName);
	
	@Modifying
	@Query(nativeQuery = true, value= "select a.* from shopdetails a where a.latitude =:ilatitude and a.longitude =:ilongitude" )
	public List<Shop> findByLatitudeAndLongitude(@Param("ilatitude")Double latitude,@Param("ilongitude") Double longitude);

}
