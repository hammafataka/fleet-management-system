package iam.mfa.fleetmanagementsystem.jpa.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import iam.mfa.fleetmanagementsystem.jpa.enums.MaintenanceType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:10
 */
@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance implements Serializable {
    @Id
    @Column(length = 128)
    private String uuid;
    @ManyToOne
    @JoinColumn(name = "vehicle_id",referencedColumnName = "uuid")
    private Vehicle vehicle;
    @Column(length = 128, name = "owner_name")
    private String ownerName;
    @Enumerated
    @Column(length = 32, name = "maintenance_type")
    private MaintenanceType maintenanceType;
    @Column(name = "maintenance_dttm")
    private LocalDateTime maintenanceDttm;
}
