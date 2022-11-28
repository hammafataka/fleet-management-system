package iam.mfa.fleetmanagementsystem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import iam.mfa.fleetmanagementsystem.models.VignetteRequest;
import iam.mfa.fleetmanagementsystem.services.VignetteService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 26.11.2022 17:35
 */
@RestController
@RequestMapping(path = "vignette")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class VignetteResource {
    private final VignetteService service;


    @PostMapping(path = "/register")
    public Mono<ResponseEntity<String>> register(final VignetteRequest request) {
        return Mono.fromSupplier(() -> request)
                .flatMap(service::register)
                .map(mapper -> ResponseEntity.ok(mapper.message()))
                .onErrorResume(throwable -> Mono.just(ResponseEntity.badRequest().body(throwable.getMessage())));
    }


    @DeleteMapping(path = "/delete/{vignetteId}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "vignetteId") final String vignetteId) {
        final var deleted = service.deleteById(vignetteId);
        if (deleted) {
            return ResponseEntity.ok(vignetteId + " is deleted");
        }
        return ResponseEntity.badRequest().body("could not delete because of invalid vignette id");
    }
}
