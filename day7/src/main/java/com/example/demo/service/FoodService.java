package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.FoodModel;
import com.example.demo.repository.FoodRepo;

@Service
public class FoodService {
	@Autowired
	public FoodRepo frepo;
	
	//post data
	public String saveFood(FoodModel h)
	{
		frepo.save(h);
		return "Data is saved to database";
	}
	
	//get data
	public List<FoodModel> getFood()
	{
		return frepo.findAll();
	}
	
	//update the data
	public FoodModel updateFood(FoodModel hm)
	{
		return frepo.saveAndFlush(hm);
	}
	
	//delete the data
	public void deleteFood(int id)
	{
		System.out.println("Deleted");
		frepo.deleteById(id);
	}
	
	public boolean deletefoodinfo(int foodId)
	{
		if(frepo.existsById(foodId))
		{
			frepo.deleteById(foodId);
			return true;
		}
		return false;
	}
	
	public Optional<FoodModel> getUserId(int userId)
	   {
		   Optional<FoodModel>food=frepo.findById(userId);
		   if(food.isPresent())
		   {
			   return food;
		   }
		   return null;
	   }
	
	
	//sorting
	
	public List<FoodModel> sortByAsc(String name)
	{
		return frepo.findAll(org.springframework.data.domain.Sort.by(name).descending());
	}
	
	
	// get all the data
	public List<FoodModel> getAllrows()
	{
		return frepo.getAllRows();
	}
	
	//get specific rows
	public List<FoodModel> getSpecrows(int id,String add,String name)
	{
		return frepo.getSpecRows(id,add,name);
	}
	
	//get by name
	public List<FoodModel> getByname(String name)
	{
		return frepo.getByname(name);
	}
	
	//delete the data
	public int deleteRowByid(int id)
	{
		return frepo.deleteId(id);
	}
	
	//update the data
	public Integer updateRow(String addr,int id)
	{
		return frepo.updateByid(addr, id);
	}
	
	//same name 
			public List<FoodModel>getbyName(String d) 
			{ 
				return frepo.getByname(d); 
			}
			
	//delete by modal class
			public Integer getBymodelid(int id)

			{
	   	       return frepo.hma(id);
		    }
			
	//update by modal class name
			public int getByString(String add,int id)
			{
				return frepo.hmas(add,id);
			}
}