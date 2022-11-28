package iam.mfa.fleetmanagementsystem.models;

import java.util.List;
import java.util.UUID;

import iam.mfa.fleetmanagementsystem.jpa.domain.Insurance;
import iam.mfa.fleetmanagementsystem.jpa.domain.InsuranceBook;
import iam.mfa.fleetmanagementsystem.jpa.domain.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 26.11.2022 15:16
 */
@Builder
@Data(staticConstructor = "empty")
@NoArgsConstructor(staticName = "empty")
@AllArgsConstructor(staticName = "all")
public class InsuranceRequest {
    private String vehicleId;
    private String insuranceType;
    private List<InsuranceBook> insuranceBooks;

    public Insurance asDomain(final Vehicle vehicle) {
        return Insurance.builder()
                .uuid(UUID.randomUUID().toString())
                .vehicle(vehicle)
                .insuranceBooks(insuranceBooks)
                .build();
    }


}
