package com.app.validator;


import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;
import com.app.model.WhUserType;
@Component
public class WhUserTypeValidator  implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return  WhUserType.class.equals(clazz);
	}

	

		
	
	@Override
	public void validate(Object target, Errors errors) {
		//DownCast Form Object
		WhUserType wh=(WhUserType)target;


		//RadioButton Validation
		if(StringUtils.isEmpty(wh.getUserType())) {
			errors.rejectValue("userType", null, "Please Choose One Grade");
		}
		//Text Input Validation
		if(!Pattern.matches("[A-Z]{2,10}",wh.getUserCode())) {
			errors.rejectValue("userCode", null," Please Enter 2 to 10 UPPERCASE ALPHABETS!!");
		}
		//DropDown Validation
		if(StringUtils.isEmpty(wh.getUserFor())) {
			errors.rejectValue("userFor", null, "Please Choose One Mode");
		}

		//Text Input Validation
		if(!Pattern.matches("[A-Z]{2,10}",wh.getUserEmail())) {
			errors.rejectValue("userEmail", null," Please Enter 2 to 10 UPPERCASE ALPHABETS!!");
		}

		//Text Input Validation
		if(!Pattern.matches("[6-9]{1}[0-9]{9}",wh.getUserContact())) {
			errors.rejectValue("userContact", null," Please Enter 2 to 10 UPPERCASE ALPHABETS!!");
		}
		//DropDown Validation
		if(StringUtils.isEmpty(wh.getUserIDType())) {
			errors.rejectValue("userIDType", null, "Please Choose One Option");
		}
		//Text Input Validation
		if(StringUtils.isEmpty(wh.getIdNumber())) {
			errors.rejectValue("idNumber", null," Please Enter 2 to 10 UPPERCASE ALPHABETS!!");
		}

	}

}


