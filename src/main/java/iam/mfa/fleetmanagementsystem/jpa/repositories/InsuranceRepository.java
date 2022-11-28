package iam.mfa.fleetmanagementsystem.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iam.mfa.fleetmanagementsystem.jpa.domain.Insurance;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:45
 */
@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, String> {
    long deleteByUuid(final String id);
}
