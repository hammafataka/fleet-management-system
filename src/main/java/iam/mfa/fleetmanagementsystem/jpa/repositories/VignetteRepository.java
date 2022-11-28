package iam.mfa.fleetmanagementsystem.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iam.mfa.fleetmanagementsystem.jpa.domain.Vignette;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:47
 */
@Repository
public interface VignetteRepository extends JpaRepository<Vignette, String> {
    long deleteByUuid(final String uuid);
}
