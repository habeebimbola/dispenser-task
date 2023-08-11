package io.rviewer.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.rviewer.domain.DispenserUsage;

import java.util.List;

@JsonSerialize
public class DispenserUsageDTO {

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("usages")
    private List<DispenserUsage> usageList;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<DispenserUsage> getUsageList() {
        return usageList;
    }

    public void setUsageList(List<DispenserUsage> usageList) {
        this.usageList = usageList;
    }
}
