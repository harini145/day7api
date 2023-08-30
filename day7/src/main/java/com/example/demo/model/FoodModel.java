package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FoodModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int foodId;
	private String foodName;
	private String foodAdd;
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodAdd() {
		return foodAdd;
	}
	public void setFoodAdd(String foodAdd) {
		this.foodAdd = foodAdd;
	}
	
	
	
}