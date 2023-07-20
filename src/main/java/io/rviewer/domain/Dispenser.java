package io.rviewer.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity()
@Table(name = "DISPENSER")
public class Dispenser {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "FLOW_VOLUME")
    private Double flowVolume;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;


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
}
