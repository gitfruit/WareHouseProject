package com.app.rest;

import java.util.List;

import org.apache.commons.codec.language.bm.Rule.RPattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestOperationsExtensionsKt;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.model.OrderMethod;
import com.app.model.WHUserType;
import com.app.service.IWHUserTypeService;

@RestController
@RequestMapping("/whusertype/rest")
public class WHUserTypeRestController {

	@Autowired
	private IWHUserTypeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> show(){
		ResponseEntity<?> resp=null;
		List<WHUserType> list=service.getAllWHUserType();
		if(list!=null && !list.isEmpty()) {
			resp=new ResponseEntity<List<WHUserType>>(list,HttpStatus.OK);
		}
		else {
			resp=new ResponseEntity<String>("NO Data Found",HttpStatus.NO_CONTENT);
		}
		return resp;
	}

	@RequestMapping("/save")
	public ResponseEntity<String> get(@RequestBody WHUserType wHUserType){
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveWHUserType(wHUserType);
            String body="saved with id :"+id;
            resp=new ResponseEntity<String>(body,HttpStatus.OK);
		}
		catch(Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	
	//To Delete  a Row in Table DataBase
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRow(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		try {
			service.deleteWHUseType(id);
			resp=new ResponseEntity<String>(id+" Deleted successfully",HttpStatus.OK);
		 }catch (Exception e) {
                 resp=new ResponseEntity<>(id+" not Found in Database/Unable to Process Request",HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	
	//  To Update one Row Data From DataBase
         @PutMapping("/update")
         public ResponseEntity<String> update(@RequestBody WHUserType whUserType){
                   ResponseEntity<String> resp=null;
                   Integer id=whUserType.getUserId();
                   try {
                	   service.updateWHUserType(whUserType);
                	   resp=new ResponseEntity<String>(id+" updated Successfully",HttpStatus.OK);
                   }catch (Exception e) {
                     resp=new ResponseEntity<String>(id+" not Found in Database",HttpStatus.BAD_REQUEST);
                   }
                   return resp;
         }
         
         // To Get one Row of Data from DataBase Table
         @GetMapping("/getone/{id}")
         public ResponseEntity<?> getone(@PathVariable Integer id){
        	 ResponseEntity<?> resp=null;
        	 try {
        		 WHUserType wh=service.getWHUserTypeByID(id);
        		 resp=new ResponseEntity<WHUserType>(wh,HttpStatus.OK);
        	 }catch (Exception e) {
              resp=new ResponseEntity<String>(id+" Not Found in DataBase/Unable to Process Your Request",HttpStatus.BAD_REQUEST);
        	 }
        	 return resp;
         }
}

