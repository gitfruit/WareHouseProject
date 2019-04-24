package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@RestController
@RequestMapping("/ordermethod/rest")
public class OrderMethodRestController {

	@Autowired
	private IOrderMethodService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> show(){
		ResponseEntity<?> resp=null;
		List<OrderMethod> list=service.getAllOrderMethods();
		if(list!=null && !list.isEmpty()) {
			resp=new ResponseEntity<List<OrderMethod>
			>(list,HttpStatus.OK);
		}
		else {
			resp=new ResponseEntity<String>("NO Data Found",HttpStatus.NO_CONTENT);
		}
		
		return resp;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody OrderMethod orderMethod){
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveOrderMethod(orderMethod);
			String body="saved with id :"+id;
			resp=new ResponseEntity<String>(body,HttpStatus.OK);
		}
		catch(Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
					e.printStackTrace();
		}
		
		return resp;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRow(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		try {
			service.deleteOrderMethod(id);
			resp=new ResponseEntity<>(id+"updated Successfully",HttpStatus.OK);
		}catch (Exception e) {
                resp=new ResponseEntity<String>(id+" Unable to Delete/ Not Exists",HttpStatus.OK);
		}
		
		return resp;
	}
	
	@GetMapping("/getone/{id}")
	public ResponseEntity<?> getoneRow(@PathVariable	 Integer id){
		ResponseEntity<?> resp=null;
		try {
			OrderMethod ord=service.getOrderMethod(id);
			resp=new ResponseEntity<>(ord,HttpStatus.OK);
		}catch (Exception e) {
                 resp=new ResponseEntity<String>("No Data Found/Unable to Process",HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateRow(@RequestBody OrderMethod orderMethod){
		ResponseEntity<String> resp=null;
		Integer id=orderMethod.getOrderId();
		try {
			service.updateOrderMethod(orderMethod);
			resp=new ResponseEntity<String>(id+" updated Successfully",HttpStatus.OK);
		}catch (Exception e) {
                   resp=new ResponseEntity<>(id+" not Found in DataBase/Unable to Process Request",HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
}
