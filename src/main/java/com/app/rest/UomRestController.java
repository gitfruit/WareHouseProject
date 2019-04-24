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

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
@RequestMapping("/uom/rest")
public class UomRestController {

	@Autowired
	private IUomService service;

	@GetMapping("/all")
	public ResponseEntity<?> showUom(){
		ResponseEntity<?> resp=null;
		List<Uom> list=service.getAllUoms();
		if(list!=null && !list.isEmpty()) {
			resp= new ResponseEntity<List<Uom>>(list,HttpStatus.OK);
		}
		else {
			resp=new ResponseEntity<String>("NO_Data_Found",HttpStatus.NO_CONTENT); 
		}
		return resp;
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody Uom uom){
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveUom(uom);
			String body="saved with id :"+id;
			resp=new ResponseEntity<String>(body,HttpStatus.OK);
		}
		catch(Exception e) {
           resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
           e.printStackTrace();
		}
		return resp;
	}
	
      //To Delete one row DataBase Table
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOneRow(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		try {
			service.deleteUom(id);
				resp=new ResponseEntity<String>(id+" deleted Successfully",HttpStatus.OK);
		}catch(Exception e) {
				resp=new ResponseEntity<String>("Unable to Process Request/Data not found",HttpStatus.BAD_REQUEST);
			}
		
		return resp;
	}
 
	//To Get One Row Data from DataBase Table
	@GetMapping("/getone/{id}")
	public ResponseEntity<?> getOneRowById(@PathVariable Integer id){
		ResponseEntity<?> resp=null;
	try {
		Uom uom=service.getUomById(id);
		if(id!=null) {
		resp=new ResponseEntity<Uom>(uom,HttpStatus.OK);
		}else {
			resp=new ResponseEntity<String>("NO Data Found",HttpStatus.BAD_REQUEST);
		}
	}catch (Exception e) {
		resp=new ResponseEntity<String>("unable to Process Request",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		return resp;
	}
	
	//To Update Data in DataBase Table
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody Uom uom){
		ResponseEntity<String> resp=null;
		try {
			service.updateUom(uom);
			Integer id=uom.getUomId();
				resp=new ResponseEntity<String>(id+" updated Successfully",HttpStatus.OK);
			
		}
			catch (Exception e) {
            resp=new ResponseEntity<>("Unable to Process Request/Id not exists in DataBase",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		return resp;
	}

}
