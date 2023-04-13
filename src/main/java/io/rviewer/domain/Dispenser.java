package io.rviewer.domain;

import java.util.UUID;

public class Dispenser {

    private UUID uuid;

    private Status status;



    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
