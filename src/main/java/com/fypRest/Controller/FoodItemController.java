package com.fypRest.Controller;

import com.fypRest.DAO.FoodItemRepository;
import com.fypRest.enitity.FoodItem;
import com.fypRest.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/foodItems")
public class FoodItemController
{
    @Autowired
    FoodItemService foodItemService;

    @Autowired
    private FoodItemRepository foodItemRepository;

    @GetMapping("/list")
    public Page<FoodItem> getFoods(@RequestParam Optional<Integer> page)
    {
        return foodItemRepository.findAll(PageRequest.of(page.orElse(0), 5));
    }

    @PostMapping("/newFoodItem")
    public FoodItem newFood(@RequestBody FoodItem theFoodItem)
    {
        try
        {
            System.out.println(theFoodItem);
            foodItemService.save(theFoodItem);

            return theFoodItem;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return theFoodItem;
    }

    @PutMapping("/updateFoodItem")
    public FoodItem updateFood(@RequestBody FoodItem theFoodItem)
    {
        foodItemService.save(theFoodItem);
        return theFoodItem;
    }

    @DeleteMapping("/deleteFoodItem/{foodItemId}")
    public String deleteFood(@PathVariable int foodId)
    {
        foodItemService.deleteById(foodId);
        return "Food Item with id - " + foodId + " is deleted.";
    }
}
