package iam.mfa.fleetmanagementsystem.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iam.mfa.fleetmanagementsystem.models.VehicleRequest;
import iam.mfa.fleetmanagementsystem.services.VehicleService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * @author HAMMA FATAKA (mfataka@monetplus.cz)
 * @project fleet-management-system
 * @date 20.11.2022 23:09
 */
@RestController
@RequestMapping(path = "vehicle")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class VehicleResource {

    private final VehicleService service;

    @PostMapping(path = "/register")
    public Mono<ResponseEntity<String>> register(@RequestBody final VehicleRequest request) {
        return service.register(request)
                .map(mapper -> ResponseEntity.ok(mapper.message()))
                .onErrorResume(throwable -> Mono.just(throwable.getMessage())
                        .map(mapper -> ResponseEntity.badRequest().body(mapper))
                );
    }

}
