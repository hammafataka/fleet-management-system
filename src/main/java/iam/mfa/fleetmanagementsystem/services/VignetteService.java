package iam.mfa.fleetmanagementsystem.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamceph.resulter.core.Resultable;

import iam.mfa.fleetmanagementsystem.jpa.domain.Vignette;
import iam.mfa.fleetmanagementsystem.jpa.repositories.VignetteRepository;
import iam.mfa.fleetmanagementsystem.models.VignetteRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 26.11.2022 17:31
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class VignetteService {
    private final VignetteRepository repository;
    private final VehicleService vehicleService;

    public Mono<Resultable> register(final VignetteRequest request) {
        return Mono.fromSupplier(() -> request)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(this::validateRequest)
                .map(mapper -> {
                    final var vehicle = vehicleService.findById(mapper.getVehicleId());
                    repository.save(request.asDomain(vehicle));
                    return Resultable.ok("registered");
                });


    }

    public boolean deleteById(final String vignetteId) {
        return repository.deleteByUuid(vignetteId) == 1;
    }

    public boolean delete(final Vignette vignette) {
        return deleteById(vignette.getUuid());
    }

    public Vignette findById(final String vignetteId) {
        return repository.findById(vignetteId).orElseThrow(() -> {
            log.error("cannot find insurance with vignetteId[{}]", vignetteId);
            return new IllegalStateException("cannot find insurance with vignetteId: " + vignetteId);
        });
    }

    private void validateRequest(final VignetteRequest request) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(request.getVehicleId());
    }
}