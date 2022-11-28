package iam.mfa.fleetmanagementsystem.jpa.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import iam.mfa.fleetmanagementsystem.jpa.enums.FuelType;
import iam.mfa.fleetmanagementsystem.jpa.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 17:59
 */
@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle implements Serializable {

    @Id
    @Column(length = 128, name = "uuid")
    private String vehicleId;
    @Column(length = 30, name = "license_plate")
    private String licensePlate;

    @Column
    @Enumerated
    private VehicleType type;

    @Column(length = 30)
    private String vin;

    @Column(name = "manufacture_dttm")
    private LocalDateTime manufactureDttm;

    @Column(length = 30)
    private String color;

    @Column(length = 30)
    private String model;

    @Enumerated
    @Column(length = 30, name = "fuel_type")
    private FuelType fuelType;

    @Column(length = 128, name = "engine_content")
    private String engineContent;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
    private List<Insurance> insurances;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Vignette> vignettes;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private List<Maintenance> maintenances;

}
