package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;

@Component
public class OrderMethodValidator  implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderMethod orm=(OrderMethod)target;
		//RadionButton Validation
		if(StringUtils.isEmpty(orm.getOrderMode())) {
			errors.rejectValue("orderMode", null, "Please Choose one OrderMode");
		}
		//TextBox Validation
		if(!Pattern.matches("[A-Z]{2,10}", orm.getOrderCode())) {
			errors.rejectValue("orderCode", null,"Please Enter 2-10 UpperCase Alphabets");
		}

		//DropDown Validation
		if(StringUtils.isEmpty(orm.getExeType())) {
			errors.rejectValue("exeType", null, "Please Choose One Option");
		}

		//CheckBox Validation
		if(orm.getOrderAccepts()==null||orm.getOrderAccepts().isEmpty()) {
			errors.rejectValue("orderAccepts", null	, "Please Check Atleast Order Atleast");

			//TextArea Validation
			if(StringUtils.isEmpty(orm.getNote())||orm.getNote().length()>20) {
				errors.rejectValue("note", null, "Please write Description maximuma 20 character");
			}


		}
	}

}
