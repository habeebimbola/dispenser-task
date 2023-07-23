package io.rviewer.rest.validator;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class DispenserValidator {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errorMessages;

    private final String errorMessage;


    public DispenserValidator(String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorMessages = new ArrayList<>();
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void addError(String errorMessage)
    {
        this.errorMessages.add(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
