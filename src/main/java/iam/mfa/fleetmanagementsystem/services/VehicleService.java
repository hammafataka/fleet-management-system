package iam.mfa.fleetmanagementsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.iamceph.resulter.core.Resultable;

import iam.mfa.fleetmanagementsystem.jpa.domain.Vehicle;
import iam.mfa.fleetmanagementsystem.jpa.repositories.VehicleRepository;
import iam.mfa.fleetmanagementsystem.models.VehicleRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 20:33
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public Mono<Resultable> register(@NonNull final VehicleRequest request) {
        return Mono.fromSupplier(() -> request)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(this::validateRequest)
                .map(mapper -> {
                    final var licensePlate = mapper.getLicensePlate();
                    final var maybeExists = vehicleRepository.existsByLicensePlate(licensePlate);
                    if (maybeExists) {
                        throw new IllegalStateException("vehicle with " + licensePlate + " already exists");
                    }
                    final var vehicle = mapper.asDomain();
                    vehicleRepository.save(vehicle);
                    log.trace("registered vehicle with id [{}] license plate [{}]", vehicle.getVehicleId(), vehicle.getLicensePlate());
                    return Resultable.ok("registered");
                });
    }


    public Vehicle findById(final String vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> {
                    log.error("vehicle with vehicle id[{}] does not exists", vehicleId);
                    return new IllegalStateException("vehicle with vehicleId: " + vehicleId + "does not exists");
                });
    }

    private void validateRequest(final VehicleRequest request) {
        final var licensePlate = request.getLicensePlate();
        final var manufactureDttm = request.getManufactureDttm();
        final var model = request.getModel();
        Assert.notNull(licensePlate, "licensePlate cannot be null");
        Assert.notNull(manufactureDttm, "manufacture date time cannot be null");
        Assert.notNull(model, "model date time cannot be null");
    }

    public boolean exists(final Vehicle vehicle) {
        return vehicleRepository.exists(Example.of(vehicle));
    }

    public boolean existsById(final String vehicleId) {
        return vehicleRepository.existsById(vehicleId);
    }
}
