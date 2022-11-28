package iam.mfa.fleetmanagementsystem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import iam.mfa.fleetmanagementsystem.models.InsuranceRequest;
import iam.mfa.fleetmanagementsystem.services.InsuranceService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 26.11.2022 17:00
 */
@RestController
@RequestMapping(path = "insurance")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class InsuranceResource {
    private final InsuranceService insuranceService;


    @PostMapping(path = "/register")
    public Mono<ResponseEntity<String>> register(final InsuranceRequest request) {
        return Mono.fromSupplier(() -> request)
                .flatMap(insuranceService::registerInsurance)
                .map(mapper -> ResponseEntity.ok(mapper.message()))
                .onErrorResume(throwable -> Mono.just(ResponseEntity.badRequest().body(throwable.getMessage())));
    }


    @DeleteMapping(path = "/delete/{insuranceId}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "insuranceId") final String insuranceId) {
        final var deleted = insuranceService.deleteById(insuranceId);
        if (deleted) {
            return ResponseEntity.ok(insuranceId + " is deleted");
        }
        return ResponseEntity.badRequest().body("could not delete, invalid insurance id");
    }
}
