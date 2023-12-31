package io.rviewer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.rviewer.domain.Status;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@JsonSerialize
public class DispenserStatusDTO {

//    @NotNull(message = "Float Volume Must Be Specified")
//    @JsonProperty("float_volume")
//    private Double floatVolume;

    @NotNull(message = "Dispenser Status Must Not Be Null")
    @JsonProperty("status")
    private Status Status;

    @JsonProperty("updated_at")
    private String updatedTime;

//    public Double getFloatVolume() {
//        return floatVolume;
//    }
//
//    public void setFloatVolume(Double floatVolume) {
//        this.floatVolume = floatVolume;
//    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        Status = status;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

}
