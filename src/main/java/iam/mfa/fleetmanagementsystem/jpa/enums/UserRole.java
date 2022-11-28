package iam.mfa.fleetmanagementsystem.jpa.enums;

import java.util.Arrays;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 26.11.2022 20:11
 */
public enum UserRole {
    USER,
    ADMIN,
    SYSTEM_ADMIN,
    VISITOR,
    UNKNOWN;

    public UserRole fromName(final String type) {
        return Arrays.stream(UserRole.values())
                .filter(userRole -> userRole.name().equalsIgnoreCase(type))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
