package com.fypRest.DAO;

import com.fypRest.enitity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer>
{
    //@Query(value = "SELECT * FROM food where charity_house_id=?1", nativeQuery = true)
    //public List<Food> findBy(String id);
}
