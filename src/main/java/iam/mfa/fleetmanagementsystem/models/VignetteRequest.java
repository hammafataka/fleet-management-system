package iam.mfa.fleetmanagementsystem.models;

import java.time.LocalDateTime;
import java.util.UUID;

import iam.mfa.fleetmanagementsystem.jpa.domain.Vehicle;
import iam.mfa.fleetmanagementsystem.jpa.domain.Vignette;
import iam.mfa.fleetmanagementsystem.jpa.enums.VignetteType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 26.11.2022 17:32
 */
@Builder
@Data(staticConstructor = "empty")
@NoArgsConstructor(staticName = "empty")
@AllArgsConstructor(staticName = "all")
public class VignetteRequest {
    private String vehicleId;
    private Long vignetteAmount;
    private VignetteType vignetteType;
    private LocalDateTime dateTime;

    public Vignette asDomain(final Vehicle vehicle) {
        return Vignette.builder()
                .uuid(UUID.randomUUID().toString())
                .dateTime(dateTime)
                .vignetteAmount(vignetteAmount)
                .vignetteType(vignetteType)
                .vehicle(vehicle)
                .build();
    }
}
