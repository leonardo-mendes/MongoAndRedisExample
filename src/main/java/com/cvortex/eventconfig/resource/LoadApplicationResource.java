package com.cvortex.eventconfig.resource;

import com.cvortex.eventconfig.domain.EventMetadata;
import com.cvortex.eventconfig.domain.loadAppDomain.LoadApplication;
import com.cvortex.eventconfig.service.EventMetaDataService;
import com.cvortex.eventconfig.service.LoadApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/load-application")
@RequiredArgsConstructor
public class LoadApplicationResource {

    private final LoadApplicationService loadApplicationService;

    @GetMapping("/{applicationId}")
    public ResponseEntity<Optional<LoadApplication>> findConfiguration(@RequestParam(value = "applicationId") String applicationId) {
        return ResponseEntity.ok(loadApplicationService.getConfigurations(applicationId));
    }

}
