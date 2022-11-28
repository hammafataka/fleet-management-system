package iam.mfa.fleetmanagementsystem.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iam.mfa.fleetmanagementsystem.jpa.domain.InsuranceBook;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:46
 */
@Repository
public interface InsuranceBookRepository extends JpaRepository<InsuranceBook, String> {
    long deleteByUuid(final String uuid);
}
