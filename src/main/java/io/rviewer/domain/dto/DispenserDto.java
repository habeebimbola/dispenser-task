package io.rviewer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@JsonSerialize
public class DispenserDto {

    @JsonProperty("flow_volume")
    @NotNull(message = "Flow Volume Cannot Be Null")
    @Positive(message = "Only Positive Values Accepted For Flow Volume")
    private Double flowVolume;

    public Double getFlowVolume() {
        return flowVolume;
    }

    public void setFlowVolume(Double flowVolume) {
        this.flowVolume = flowVolume;
    }
}
