package io.rviewer.repo;

import io.rviewer.domain.Dispenser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DispenserRepository extends JpaRepository<Dispenser, UUID> {
}
