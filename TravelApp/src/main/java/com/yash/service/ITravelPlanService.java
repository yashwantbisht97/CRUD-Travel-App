package com.yash.service;

import java.util.List;
import java.util.Map;

import com.yash.entity.TravelPlan;

public interface ITravelPlanService {

    public String registerTravelPlan(TravelPlan plan);  //save ops

    public Map<Integer, String> getTravelPlanCategories();  //select

    public List<TravelPlan> showAllTravelPlans();  //save

    public TravelPlan showTravelPlanById(Integer planId);   // for edit to show existing record with planid which selected

    public String updateTravelPlan(TravelPlan plan);  //update

    public String deleteTravelPlan(Integer planId);   //delete

    public String changeTravelPlanStatus(Integer planId, String status);

}
