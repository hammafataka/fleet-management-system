package iam.mfa.fleetmanagementsystem.jpa.enums;

import java.util.Arrays;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:27
 */
public enum VignetteType {
    MONTHLY,
    YEARLY,
    DAILY,
    UNKNOWN;
    public VignetteType fromName(final String type) {
        return Arrays.stream(VignetteType.values())
                .filter(vehicleType -> vehicleType.name().equalsIgnoreCase(type))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
