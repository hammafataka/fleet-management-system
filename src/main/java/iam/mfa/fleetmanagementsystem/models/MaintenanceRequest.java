package iam.mfa.fleetmanagementsystem.models;

import java.time.LocalDateTime;
import java.util.UUID;

import iam.mfa.fleetmanagementsystem.jpa.domain.Maintenance;
import iam.mfa.fleetmanagementsystem.jpa.domain.Vehicle;
import iam.mfa.fleetmanagementsystem.jpa.enums.MaintenanceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 26.11.2022 17:22
 */
@Builder
@Data(staticConstructor = "empty")
@NoArgsConstructor(staticName = "empty")
@AllArgsConstructor(staticName = "all")
public class MaintenanceRequest {
    private String vehicleId;
    private String ownerName;
    private MaintenanceType maintenanceType;
    private LocalDateTime maintenanceDttm;

    public Maintenance asDomain(final Vehicle vehicle) {
        return Maintenance.builder()
                .uuid(UUID.randomUUID().toString())
                .maintenanceDttm(maintenanceDttm)
                .maintenanceType(maintenanceType)
                .vehicle(vehicle)
                .ownerName(ownerName)
                .build();
    }
}
