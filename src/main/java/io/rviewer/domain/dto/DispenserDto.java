package io.rviewer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

@JsonSerialize
public class DispenserDto {

    @JsonProperty("flow_volume")
    @NotNull(message = "Flow Volume Cannot Be Null")
    @Positive(message = "Only Positive Values Accepted For Flow Volume")
    private Double flowVolume;

    @JsonProperty("id")
    private UUID uuid;

    public Double getFlowVolume() {
        return flowVolume;
    }

    public void setFlowVolume(Double flowVolume) {
        this.flowVolume = flowVolume;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
