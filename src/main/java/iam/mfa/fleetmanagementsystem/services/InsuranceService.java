package iam.mfa.fleetmanagementsystem.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamceph.resulter.core.Resultable;

import iam.mfa.fleetmanagementsystem.jpa.domain.Insurance;
import iam.mfa.fleetmanagementsystem.jpa.repositories.InsuranceRepository;
import iam.mfa.fleetmanagementsystem.models.InsuranceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 26.11.2022 15:14
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class InsuranceService {

    private final VehicleService vehicleService;
    private final InsuranceRepository repository;

    public Mono<Resultable> registerInsurance(final InsuranceRequest request) {
        return Mono.fromSupplier(() -> request)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(this::validateRequest)
                .map(mapper -> {
                    final var vehicle = vehicleService.findById(mapper.getVehicleId());
                    repository.save(request.asDomain(vehicle));
                    return Resultable.ok("registered");
                });


    }

    public boolean delete(final Insurance insurance) {
        return deleteById(insurance.getUuid());
    }

    public boolean deleteById(final String insuranceId) {
        return repository.deleteByUuid(insuranceId) == 1;
    }


    public Insurance findById(final String insuranceId) {
        return repository.findById(insuranceId).orElseThrow(() -> {
            log.error("cannot find insurance with insuranceId[{}]", insuranceId);
            return new IllegalStateException("cannot find insurance with insuranceId: " + insuranceId);
        });
    }

    private void validateRequest(final InsuranceRequest request) {
        Objects.requireNonNull(request);
        Objects.requireNonNull(request.getVehicleId());
    }
}
