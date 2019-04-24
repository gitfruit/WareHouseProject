package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
@Component
public class UomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	    Uom uom=(Uom)target;
		//DropDown validation
		if(StringUtils.isEmpty(uom.getUomType())) {
			errors.rejectValue("uomType", null, "Please Choose one UomType");
		}
		
		//TextBox Validation
		if(!Pattern.matches("[A-Z]{2,10}", uom.getUomCode())){
			errors.rejectValue("uomCode", null, "Please Enter 2-10 UpperCase Alphabets !!");
		}
		
		//RadioButton Validation
		if(StringUtils.isEmpty(uom.getEnableUom())) {
		          errors.rejectValue("enableUom", null, "Please Choose one Option");
		}
		
		//TextBox Validation
		if(!Pattern.matches("[A-Z]{2,10}",uom.getMetaCode())) {
			errors.rejectValue("metaCode", null, "Please Enter 2-10 UpperCase Alphabets !!");
		}
		
		//RadioButton Validation
		if(StringUtils.isEmpty(uom.getAdjSize())) {
			errors.rejectValue("adjSize", null, "Please Choose One Option");
		}
		
		//TextBox Validation
		if(StringUtils.isEmpty(uom.getNote())||uom.getNote().length()>20) {
			errors.rejectValue("note", null, "Please Write Description Maximum 20 Character" );
		}
	}

}
