package io.rviewer.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DispenserUsage implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer usageId;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "OPENED_AT")
    private LocalDateTime openedAt;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "CLOSED_AT")
    private LocalDateTime closedAt;

    @Column(name = "DISPENSER_ID")
    private Integer dispenserId;


    public Integer getUsageId() {
        return usageId;
    }

    public void setUsageId(Integer usageId) {
        this.usageId = usageId;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(LocalDateTime openedAt) {
        this.openedAt = openedAt;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(LocalDateTime closedAt) {
        this.closedAt = closedAt;
    }
}
