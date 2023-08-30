package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.FoodModel;

import jakarta.transaction.Transactional;


public interface FoodRepo extends JpaRepository<FoodModel, Integer>
{


// native query
@Query(value="select * from food_model", nativeQuery=true)
public List<FoodModel> getAllRows();
//FooModel getAllRows();


//using model name 
@Query("select h from FoodModel h where h.foodName like %?1%") 
public List<FoodModel>getByname1(@Param("name") String name);


//using like 
@Query(value="select * from food_model where food_name like %?1%",nativeQuery = true)
public List<FoodModel> getByname (@Param("name") String name);

@Query(value="select * from food_model where foodid=:id and address=:addr and foodname=:name",nativeQuery=true)
public List<FoodModel> getSpecRows(@Param("id") int id,@Param("addr") String addr,@Param("nam") String name);



// delete using native query
@Modifying
@Transactional
@Query(value = "delete from food_model where food_id=:id",nativeQuery=true)
public int deleteId(@Param("id") int id);


//update the native query
@Modifying
@Transactional
@Query(value = "update food_model set food_add=:addr where food_id=:id",nativeQuery=true)
public Integer updateByid(@Param("addr") String addr,@Param("id") int id);


//update by modal name
@Modifying
@Transactional
@Query("update FoodModel h set h.foodAdd=:add where h.foodId=:id")
public int hmas(@Param("add") String add,@Param("id") int id);


//delete by modal class
@Modifying 
@Transactional 
@Query("delete from FoodModel h where h.foodId=:id") 
public int hma(@Param("id") int id);
}