package io.rviewer.rest.validator;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class DispenserValidator {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errorMessages;

    private final String errorMessage;


    public DispenserValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void addError(String errorMessage)
    {
        this.errorMessages.add(errorMessage);
    }
}
