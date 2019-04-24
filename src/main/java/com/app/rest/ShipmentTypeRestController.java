package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/shipmentType/rest")
public class ShipmentTypeRestController {

	@Autowired
	private IShipmentTypeService service;

	// To get All Rows of Data From DataBase
	@GetMapping("/all")
	public ResponseEntity<?> showData(){
		ResponseEntity<?> resp=null;
		List<ShipmentType> list=service.getAllShipmentTypes();
		if(list!=null && !list.isEmpty()) {

			resp=new ResponseEntity<List<ShipmentType>>(list,HttpStatus.OK);
		}
		else {
			resp=new ResponseEntity<String>("NO Data Found",HttpStatus.NO_CONTENT);
		}

		return resp;
	}

	// To Save Data in The DataBase
	@PostMapping("/save")
	public ResponseEntity<?> saveData(@RequestBody ShipmentType shipmentType){
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveShipmentType(shipmentType);
			String body="saved with Id : "+id;
			resp=new ResponseEntity<String>(body,HttpStatus.OK);
		}catch(Exception e) {
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}

	//To Delete One Row of Data in the DataBase Table
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRowById(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		try {
			service.deleteShipmentType(id);
			resp=new ResponseEntity<String>(id+" Deleted Succesfully",HttpStatus.OK);
		}
		catch(Exception e) {
			resp=new ResponseEntity<String>(id+" Unable to Delete/not exists",HttpStatus.BAD_REQUEST);
		}
	return resp;
}
	//To  Get One Row of Data From DataBase Table
	@GetMapping("/getone/{id}")
	public ResponseEntity<?> getOneRow(@PathVariable Integer id){
		ResponseEntity<?> resp=null;
		try {
			ShipmentType st=service.getShipmentTypeId(id);
			if(id!=null) {
				resp=new ResponseEntity<ShipmentType>(st,HttpStatus.OK);
			}
			else {
				resp=new ResponseEntity<String>(id+"Not Found in DataBase",HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			resp=new ResponseEntity<String>("Unable to Process Request",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	//To Update a Row  in DataBase Shipment Table
	@PutMapping("/update")
	public ResponseEntity<?> updateRow(@RequestBody ShipmentType shipmentType){
		ResponseEntity<?> resp=null;
		Integer id=shipmentType.getShipmentId();
		try {
			service.updateShipmentType(shipmentType);
			resp=new ResponseEntity<String>(id+" Updated Succesfully ",HttpStatus.OK);
		}catch(Exception e) {
			resp=new ResponseEntity<String>("Uable to Process Your Request/"+id+" not exists in Database",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
}
