package io.rviewer.rest.validator;

import org.springframework.validation.BindingResult;

public class DispenserValidatorBuilder {

    public static DispenserValidator fromBindingErrors(BindingResult bindingResult)
    {
        DispenserValidator dispenserValidator = new DispenserValidator("There are "+bindingResult.getAllErrors().size()+" total errors.");
        bindingResult.getAllErrors().stream().forEach((objectError)->{ dispenserValidator.addError( objectError.getDefaultMessage()); });
        return  dispenserValidator;
    }
}
