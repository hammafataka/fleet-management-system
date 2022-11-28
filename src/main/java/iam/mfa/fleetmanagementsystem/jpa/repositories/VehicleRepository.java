package iam.mfa.fleetmanagementsystem.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iam.mfa.fleetmanagementsystem.jpa.domain.Vehicle;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:47
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    @Query("select v from Vehicle as v where v.licensePlate=:licensePlate")
    Vehicle findByLicensePlate(final String licensePlate);

    long deleteByVehicleId(final String vehicleId);

    boolean existsByLicensePlate(final String licensePlate);
}
