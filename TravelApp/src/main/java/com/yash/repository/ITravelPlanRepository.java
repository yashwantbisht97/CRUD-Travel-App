package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.entity.TravelPlan;

public interface ITravelPlanRepository extends JpaRepository<TravelPlan, Integer> {

}
