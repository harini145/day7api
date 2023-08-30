package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FoodModel;
import com.example.demo.service.FoodService;

@RestController
public class FoodController {
	@Autowired
	public FoodService hserv;
	
	//post mapping
	@PostMapping("/postFood")
	public String postFood(@RequestBody FoodModel hr)
	{
		hserv.saveFood(hr);
		return "Data saved";
	}
	
	//get mapping
	@GetMapping("/getFood")
	public List<FoodModel> getFoodInfo()
	{
		return hserv.getFood();
	}
	
	//put mapping
	@PutMapping("/updateFood")
	public FoodModel updateFoodInfo(@RequestBody FoodModel ha)
	{
		return hserv.updateFood(ha);
	}
	
	//delete mapping using path variable
	@DeleteMapping("/deleteFood/{id}")
	public String removeFood(@PathVariable("id") int hid)
	{
		hserv.deleteFood(hid);
		return "Food with Id"+hid+" is deleted";
	}
	
	//delete mapping using request param
	@DeleteMapping("/byReqParm")
	public String removeByRequestPam(@RequestParam("id") int id)
	{ 
		hserv.deleteFood(id);
		return "Food with Id "+id+" is deleted"; 
	}
	
	
	//delete mapping with present or not
	@DeleteMapping("/deletefoodif/{id}")
	public ResponseEntity<String>deletefoodinfo(@PathVariable int id)
	{
		boolean deleted=hserv.deletefoodinfo(id);
		if(deleted)
		{
			return ResponseEntity.ok("Food with ID "+ id +" deleted successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food with ID "+ id +" not found");
		}
	}
	
	//getuserById
		@GetMapping("/users/{userId}")
		public ResponseEntity<?>getUserId(@PathVariable int userId)
		{
		Optional<FoodModel>food=hserv.getUserId(userId);
		if(food!=null) {
			return ResponseEntity.ok(food); //return the users data if available
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
			
		}
		
		//sort by asc
		
		@GetMapping("/sortAsc/{name}")
		public List<FoodModel> sortasc(@PathVariable("name") String name)
		{
			return hserv.sortByAsc(name);
		}
		
		
		
		
		
		//get all the data
		@GetMapping("/getAllRows")
		public List<FoodModel> getallRows()
		{
			return hserv.getAllrows();
		}
		
		//delete data
		@DeleteMapping("/deleteRow/{id}")
		public String deleted(@PathVariable("id") int id)
		{
			return hserv.deleteRowByid(id)+" Row is deleted";
		}
		
		//update data
		@PutMapping("/update/{d}/{id}")
		public String updateById(@PathVariable("d") String d,@PathVariable("id") int id)
		{
			return hserv.updateRow(d, id)+" Row is Updated";
		}
		
		//using like
		@GetMapping("/likeAllrows/{d}") 
		public List<FoodModel>getbyname(@PathVariable("d") String d) 
		{ 
			return hserv.getbyName(d);
		}
		
		//using model name
		@GetMapping("/likeAllRows1/{d1}")
		public List<FoodModel>getbyname1(@PathVariable("d1") String d1)
		{
			return hserv.getbyName(d1);
		}
		
		@GetMapping
		public String Welcome() {
			return "Welcome";
		}
		
		//delete by modal class
		@DeleteMapping("/deletemodal/{id}")

		public String hma (@PathVariable("id") int id)

		{
		return hserv.getBymodelid(id)+" Deleted";
		}
		
		//update by modal class name
		@PutMapping("/updatemodalname/{add}/{id}")
		public String hmasl (@PathVariable("add") String add,@PathVariable("id") int id)
		{
			return hserv.getByString(add,id)+" is Updated";
		}
	
}