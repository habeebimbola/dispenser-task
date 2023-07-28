package io.rviewer.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "DISPENSER_USAGE")
public class DispenserUsage implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer usageId;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "OPENED_AT")
    private LocalDateTime openedAt;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "CLOSED_AT")
    private LocalDateTime closedAt;

    @Column(name = "TOTAL_USAGE")
    private Double totalUsage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISPENSER_ID", referencedColumnName = "UUID", updatable = true, nullable = false, insertable = true )
    private Dispenser dispenser;

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

    public Dispenser getDispenser() {
        return dispenser;
    }

    public void setDispenser(Dispenser dispenser) {
        this.dispenser = dispenser;
    }

    public Double getTotalUsage() {
        return totalUsage;
    }

    public void setTotalUsage(Double totalUsage) {
        this.totalUsage = totalUsage;
    }
}
