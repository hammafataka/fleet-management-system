package iam.mfa.fleetmanagementsystem.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import iam.mfa.fleetmanagementsystem.jpa.domain.Insurance;
import iam.mfa.fleetmanagementsystem.jpa.domain.Vehicle;
import iam.mfa.fleetmanagementsystem.jpa.domain.Vignette;
import iam.mfa.fleetmanagementsystem.jpa.enums.FuelType;
import iam.mfa.fleetmanagementsystem.jpa.enums.VehicleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 20:34
 */
@Builder
@Data(staticConstructor = "empty")
@NoArgsConstructor(staticName = "empty")
@AllArgsConstructor(staticName = "all")
public class VehicleRequest {
    private String licensePlate;
    private String color;
    private VehicleType type;
    private String vin;
    private LocalDateTime manufactureDttm;
    private String model;
    private FuelType fuelType;
    private String engineContent;
    private List<Insurance> insurances;
    private List<Vignette> vignettes;


    public Vehicle asDomain() {
        return Vehicle.builder()
                .vehicleId(UUID.randomUUID().toString())
                .color(color)
                .engineContent(engineContent)
                .fuelType(fuelType)
                .licensePlate(licensePlate)
                .type(type)
                .vignettes(vignettes)
                .insurances(insurances)
                .manufactureDttm(manufactureDttm)
                .vin(vin)
                .model(model)
                .build();
    }
}
