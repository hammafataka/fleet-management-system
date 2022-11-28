package iam.mfa.fleetmanagementsystem.jpa.enums;

import java.util.Arrays;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 18:12
 */
public enum MaintenanceType {
    GUARANTEE_INSPECTION,
    REPAIRS,
    ACCIDENT,
    UNKNOWN;

    public MaintenanceType fromName(final String type) {
        return Arrays.stream(MaintenanceType.values())
                .filter(maintenanceType -> maintenanceType.name().equalsIgnoreCase(type))
                .findFirst()
                .orElse(UNKNOWN);
    }

}
