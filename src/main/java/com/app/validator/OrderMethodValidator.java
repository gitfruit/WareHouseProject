package com.app.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;

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
	
	}

}
