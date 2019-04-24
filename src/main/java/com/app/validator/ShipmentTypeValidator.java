package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;

@Component
public class ShipmentTypeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Downcast Form Object
		ShipmentType st=(ShipmentType) target;
		
		//DropDown Validation
		if(StringUtils.isEmpty(st.getShipmentMode())) {
			errors.rejectValue("shipmentMode", null, "Please Choose One Mode");
		}
		
		//Text Input Validation
		if(!Pattern.matches("[A-Z]{2,10}",st.getShipmentCode())) {
			errors.rejectValue("shipmentCode", null," Please Enter 2 to 10 UPPERCASE ALPHABETS!!");
		}
		//DropDown Validation
		if(StringUtils.isEmpty(st.getShipmentEnable())) {
			errors.rejectValue("shipmentEnable", null, "Please Choose One Option");
		}
		//RadioButton Validation
		if(StringUtils.isEmpty(st.getShipmentGrade())) {
			errors.rejectValue("shipmentGrade", null, "Please Choose One Grade");
		}
		
		//Text Input Validation
		if(StringUtils.isEmpty(st.getSnote())||st.getSnote().length()>30) {
			errors.rejectValue("snote", null, "Please Enter note Maximum 30 Chars" );
		}
	}

}
