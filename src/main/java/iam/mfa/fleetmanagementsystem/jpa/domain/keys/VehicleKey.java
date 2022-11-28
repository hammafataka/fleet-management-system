package iam.mfa.fleetmanagementsystem.jpa.domain.keys;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 20:46
 */
@Getter
@Setter
@ToString
@Embeddable
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class VehicleKey implements Serializable {
    @Column(length = 128, name = "vehicle_id")
    private String vehicleId;
    @Column(length = 30, name = "license_plate")
    private String licensePlate;
}
