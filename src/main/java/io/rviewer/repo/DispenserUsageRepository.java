package io.rviewer.repo;

import io.rviewer.domain.DispenserUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispenserUsageRepository extends JpaRepository<DispenserUsage, Integer> {
}
