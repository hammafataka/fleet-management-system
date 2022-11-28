package iam.mfa.fleetmanagementsystem.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamceph.resulter.core.Resultable;

import iam.mfa.fleetmanagementsystem.jpa.domain.Maintenance;
import iam.mfa.fleetmanagementsystem.jpa.repositories.MaintenanceRepository;
import iam.mfa.fleetmanagementsystem.models.MaintenanceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 26.11.2022 17:24
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MaintenanceService {
    private final MaintenanceRepository repository;
    private final VehicleService vehicleService;

    public Mono<Resultable> register(final MaintenanceRequest request) {
        return Mono.fromSupplier(() -> request)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(this::validateRequest)
                .map(mapper -> {
                    final var vehicle = vehicleService.findById(mapper.getVehicleId());
                    repository.save(request.asDomain(vehicle));
                    return Resultable.ok("registered");
                });
    }

    public boolean deleteById(final String maintenanceId) {
        return repository.deleteByUuid(maintenanceId) == 1;
    }

    public boolean delete(final Maintenance maintenance) {
        return deleteById(maintenance.getUuid());
    }

    public Maintenance findById(final String maintenanceId) {
        return repository.findById(maintenanceId).orElseThrow(() -> {
            log.error("cannot find insurance with maintenanceId[{}]", maintenanceId);
            return new IllegalStateException("cannot find insurance with maintenanceId: " + maintenanceId);
        });
    }

    private void validateRequest(final MaintenanceRequest request) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(request.getVehicleId());
    }
}
