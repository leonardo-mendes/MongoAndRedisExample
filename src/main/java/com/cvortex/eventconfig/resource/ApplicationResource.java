package com.cvortex.eventconfig.resource;

import com.cvortex.eventconfig.domain.Application;
import com.cvortex.eventconfig.repository.ApplicationRepository;
import com.cvortex.eventconfig.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationResource {

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<Application> save(@RequestBody Application application) {
        return ResponseEntity.ok(applicationService.insertApplication(application));
    }

    @GetMapping
    public ResponseEntity<Iterable<Application>> findAll() {
        return ResponseEntity.ok(applicationService.findAll());
    }

}
