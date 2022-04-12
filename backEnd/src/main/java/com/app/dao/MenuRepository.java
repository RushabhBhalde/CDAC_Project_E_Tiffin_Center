package com.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojo.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

	@Query("select m from Menu m where m.restaurant.id=:ri")
	List<?> findRestaurantMenu(@Param("ri")int ri);
	
	@Query("select m from Menu m where m.id=:mi")
	Menu findByManuId(@Param("mi")int mi);
	
	//added last time
	@Modifying
	@Transactional
	@Query(value="delete from menu_tbl where rest_id=:id",nativeQuery=true)
	void deleteMenu(int id);
	
}
