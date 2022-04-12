package com.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojo.Restaurants;

public interface RestaurantsRepository extends JpaRepository<Restaurants, Integer> {

	@Query("select r from Restaurants r where r.city=:city")
	List<?> findByCity(@Param("city")String city);
	
	//add a method to get add available restaurants
	List<Restaurants> findAll();
	
	@Query("select r from Restaurants r where r.user.id=:uid")
	List<Restaurants> finsByUserId(@Param("uid")int uid);
	
	//added last time
	@Modifying
	@Transactional
	@Query(value="delete from restaurants_tbl where id=:id",nativeQuery=true)
	void deleteRestaurant(int id);
	
}
