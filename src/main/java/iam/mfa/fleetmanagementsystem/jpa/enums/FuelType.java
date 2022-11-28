package iam.mfa.fleetmanagementsystem.jpa.enums;

import java.util.Arrays;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:07
 */
public enum FuelType {

    DIESEL,
    BENZINE,
    LPG,
    UNKNOWN;

    public FuelType fromName(final String type) {
        return Arrays.stream(FuelType.values())
                .filter(vehicleType -> vehicleType.name().equalsIgnoreCase(type))
                .findFirst()
                .orElse(UNKNOWN);
    }

}
