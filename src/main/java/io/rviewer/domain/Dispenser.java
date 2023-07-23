package io.rviewer.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity()
@Table(name = "DISPENSER")
public class Dispenser {

    @Id
    @Column(name = "UUID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "FLOW_VOLUME")
    private Double flowVolume;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    @Column(name = "LAST_UPDATED_TIME")
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime lastUpdateTime;

    @Column(name = "ID", unique = true)
    private String identity;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Double getFlowVolume() {
        return flowVolume;
    }

    public void setFlowVolume(Double flowVolume) {
        this.flowVolume = flowVolume;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @PreUpdate
    public void onUpdate()
    {
       this.setLastUpdateTime(LocalDateTime.now());
    }
}
