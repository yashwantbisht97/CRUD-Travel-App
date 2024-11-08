package com.yash.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.entity.PlanCategory;
import com.yash.entity.TravelPlan;
import com.yash.repository.IPlanCategoryRepository;
import com.yash.repository.ITravelPlanRepository;

@Service
public class ImplTravelPlanService implements ITravelPlanService {
    @Autowired
    private ITravelPlanRepository travelPlanRepo;
    @Autowired
    private IPlanCategoryRepository planCategoryRepo;

    @Override
    public String registerTravelPlan(TravelPlan plan) {
        // TODO Auto-generated method stub
        TravelPlan saved = travelPlanRepo.save(plan);
        
        if (saved.getPlanId()!= null)
            return "Travel plan saved " + saved.getPlanId();
        else
            return "not saved";

    }

    @Override
    public Map<Integer, String> getTravelPlanCategories() {
        // TODO Auto-generated method stub

        List<PlanCategory> list = planCategoryRepo.findAll();
        Map<Integer, String> categoriesMap = new HashMap<Integer, String>();
        list.forEach(category -> {
            categoriesMap.put(category.getCategoryId(), category.getCategoryName());
        });
        return categoriesMap;

    }

    @Override
    public List<TravelPlan> showAllTravelPlans() {
        // TODO Auto-generated method stub
    	return travelPlanRepo.findAll();
    	}

    @Override
    public TravelPlan showTravelPlanById(Integer planId) {
        // TODO Auto-generated method stub
    	Optional<TravelPlan> opt= travelPlanRepo.findById(planId);
    	if(opt.isPresent()) {
    		return opt.get();
    	}
    	else {
    		throw new IllegalArgumentException("paln it not found");
    	}
    	
        
    }

    @Override
    public String updateTravelPlan(TravelPlan plan) {
//       TravelPlan updated=travelPlanRepo.save(plan);
//       return updated.getPlanId() + "Travel plan is updated";
    	
    	Optional<TravelPlan> opt =travelPlanRepo.findById(plan.getPlanId());
    	if(opt.isPresent()) {
    		travelPlanRepo.save(plan);
            return plan.getPlanId() + "travel plan is updated";
    	}
    	else {
    		return plan.getPlanId() + "travel plan is not found";
    	}
    }

    @Override
    public String deleteTravelPlan(Integer planId) {
    	Optional<TravelPlan> opt =travelPlanRepo.findById(planId);
    	if(opt.isPresent()) {
    		travelPlanRepo.deleteById(planId);
    		return planId + "travel plan deleted";
    	}
    	else {
    		return planId + "travel plan is not found";
    	}
    }

    @Override
    public String changeTravelPlanStatus(Integer planId, String status) {
    	Optional<TravelPlan> opt =travelPlanRepo.findById(planId);
    	if(opt.isPresent()) {
    		TravelPlan plan=opt.get();
    		plan.setActiveSW(status);
    		travelPlanRepo.save(plan);
    		return planId + "travel plan status changed deleted";
    	}
    	else {
    		return planId + "travel plan updates is not found";
    	}
    }

}
