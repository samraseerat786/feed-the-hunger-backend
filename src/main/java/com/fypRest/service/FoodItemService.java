package com.fypRest.service;

import com.fypRest.DAO.FoodItemRepository;
import com.fypRest.enitity.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService
{
    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    public FoodItemService(FoodItemRepository foodItemRepository)
    {
        this.foodItemRepository = foodItemRepository;
    }

    public void save(FoodItem foodItem)
    {
        foodItemRepository.save(foodItem);
    }

    public FoodItem findById(int id)
    {
        FoodItem newFoodItem =null;
        Optional<FoodItem> foodItem = foodItemRepository.findById(id);
        if(foodItem.isPresent())
        {
            newFoodItem = foodItem.get();
        }
        return newFoodItem;
    }

    public void deleteById(int id)
    {
        FoodItem foodItem = this.findById(id);
        foodItemRepository.delete(foodItem);
        //foodRepository.deleteById(id);
    }

}
