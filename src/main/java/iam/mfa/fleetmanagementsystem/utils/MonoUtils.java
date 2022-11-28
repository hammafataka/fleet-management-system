package iam.mfa.fleetmanagementsystem.utils;

import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 20:32
 */
@UtilityClass
public class MonoUtils {
    public <T> Mono<T> error(final String message) {
        return Mono.error(new Throwable(message));
    }

}
