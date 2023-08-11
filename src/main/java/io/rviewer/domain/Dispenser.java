package io.rviewer.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.descriptor.jdbc.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import org.hibernate.usertype.UserType;

import java.sql.JDBCType;
import java.sql.SQLType;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DISPENSER")
public class Dispenser {

    @Id
    @Column(name = "UUID" )
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

    @PreUpdate
    public void onUpdate()
    {
       this.setLastUpdateTime(LocalDateTime.now());
    }

    @PrePersist
    public void onCreate()
    {
        this.setLastUpdateTime(LocalDateTime.now());
    }
}
