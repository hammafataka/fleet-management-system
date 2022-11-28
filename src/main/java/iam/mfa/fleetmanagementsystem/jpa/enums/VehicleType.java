package iam.mfa.fleetmanagementsystem.jpa.enums;

import java.util.Arrays;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:02
 */
public enum VehicleType {
    CAR,
    TRUCK,
    MOTORCYCLE,
    UNKNOWN;

    public VehicleType fromName(final String type) {
        return Arrays.stream(VehicleType.values())
                .filter(vehicleType -> vehicleType.name().equalsIgnoreCase(type))
                .findFirst()
                .orElse(UNKNOWN);
    }

}
