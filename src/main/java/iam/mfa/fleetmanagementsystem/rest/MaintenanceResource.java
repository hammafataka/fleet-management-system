package iam.mfa.fleetmanagementsystem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import iam.mfa.fleetmanagementsystem.models.MaintenanceRequest;
import iam.mfa.fleetmanagementsystem.services.MaintenanceService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 26.11.2022 17:29
 */
@RestController
@RequestMapping(path = "maintenance")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MaintenanceResource {
    private final MaintenanceService service;


    @PostMapping(path = "/register")
    public Mono<ResponseEntity<String>> register(final MaintenanceRequest request) {
        return Mono.fromSupplier(() -> request)
                .flatMap(service::register)
                .map(mapper -> ResponseEntity.ok(mapper.message()))
                .onErrorResume(throwable ->
                        Mono.just(ResponseEntity
                                .badRequest()
                                .body(throwable.getMessage())
                        )
                );
    }


    @DeleteMapping(path = "/delete/{maintenanceId}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "maintenanceId") final String maintenanceId) {
        final var deleted = service.deleteById(maintenanceId);
        if (deleted) {
            return ResponseEntity.ok(maintenanceId + " is deleted");
        }
        return ResponseEntity.badRequest().body("could not delete maintenance because of invalid id");
    }
}
