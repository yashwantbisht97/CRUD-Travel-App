package com.yash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.entity.PlanCategory;

public interface IPlanCategoryRepository extends JpaRepository<PlanCategory, Integer> {

}
