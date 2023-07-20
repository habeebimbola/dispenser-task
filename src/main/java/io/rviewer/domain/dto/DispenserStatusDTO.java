package io.rviewer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.rviewer.domain.Status;

@JsonSerialize
public class DispenserStatusDTO {

    @JsonProperty("float_volume")
    private Double floatVolume;

    @JsonProperty("status")
    private io.rviewer.domain.Status Status;

    @JsonProperty("updated_at")
    private String updatedTime;

    public Double getFloatVolume() {
        return floatVolume;
    }

    public void setFloatVolume(Double floatVolume) {
        this.floatVolume = floatVolume;
    }

    public io.rviewer.domain.Status getStatus() {
        return Status;
    }

    public void setStatus(io.rviewer.domain.Status status) {
        Status = status;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

}
