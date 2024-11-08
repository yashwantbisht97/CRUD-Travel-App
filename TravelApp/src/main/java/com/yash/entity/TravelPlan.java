package com.yash.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "TRAVEL_PLAN")
public class TravelPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PLAN_ID")
    private Integer planId;

    @Column(name = "PLAN_NAME")
    private String planName;
    
    @Column(name="PLAN_MIN_BUDGET")
    private double planMinBudget;
    
    @Column(name="PLAN_DISCRIPTION")
    private String planDiscription;
    
    @Column(name="PLAN_CATEGORY_ID")
    private Integer planCategoryId;
    

    @Column(name = "ACTIVE_SW", length = 15)
    private String activeSW="active";

    @Column(name = "CREATED_DATE", updatable = false)
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name = "UPDATED_DATE", updatable = true, insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column(name = "CREATED_BY", length = 20)
    private String createdBy;

    @Column(name = "UPDATED_BY", length = 20)
    private String updatedBy;


}
