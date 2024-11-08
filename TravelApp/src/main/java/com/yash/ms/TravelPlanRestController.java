package com.yash.ms;

import java.util.List;
import java.util.Map;

import com.yash.entity.TravelPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yash.service.ImplTravelPlanService;

@RestController
@RequestMapping("/travelplan/api")
public class TravelPlanRestController {
@Autowired
private ImplTravelPlanService travelPlanService;

@GetMapping("/categories")
public ResponseEntity<?> showTravelPlanCategories(){
try {
	Map<Integer,String> mapCategories=travelPlanService.getTravelPlanCategories();
	return new ResponseEntity<Map<Integer,String>>(mapCategories, HttpStatus.OK);
	
}
	catch(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}

@PostMapping("/register")
	public ResponseEntity<String> saveTourPlan(@RequestBody TravelPlan plan){
     try{
		 String msg=travelPlanService.registerTravelPlan(plan);
		 return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	 }
	 catch(Exception e) {
		 e.printStackTrace();
		 return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	 }

	}

    @GetMapping("/all")
	public ResponseEntity<?> getAllTravelPlan(){
		try{
			List<TravelPlan> list =travelPlanService.showAllTravelPlans();

			return new ResponseEntity<List<TravelPlan>>(list,HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/find/planId")
	public ResponseEntity<?> getTravelById(@PathVariable Integer planId){
	try{
		TravelPlan plan=travelPlanService.showTravelPlanById(planId);
		return new ResponseEntity<TravelPlan>(plan,HttpStatus.OK);
	}
	catch (Exception e){
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateTravelPlan(@RequestBody TravelPlan plan){
	try{
		String msg= travelPlanService.updateTravelPlan(plan);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	catch (Exception e){
		e.printStackTrace();
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

	@DeleteMapping("/delete/{planId}")
	public ResponseEntity<?> removeTravelPlanById(@PathVariable Integer planId) {
		try {
			String msg = travelPlanService.deleteTravelPlan(planId);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<?> removeTravelPlanByPlanId(@PathVariable Integer planId, @PathVariable String status){
		try{
			String msg= travelPlanService.changeTravelPlanStatus(planId,status);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}



