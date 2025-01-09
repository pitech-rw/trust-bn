package pitech.trust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pitech.trust.model.JobRequest;
import pitech.trust.service.RequestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/requests")
public class RequestController {

    private final RequestService requestService;

    @Autowired
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public List<JobRequest> getAllRequests() {
        return requestService.findAllRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobRequest> getJobRequestById(@PathVariable String id) {
        Optional<JobRequest> request = requestService.findRequestByID(id);
        return request.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public JobRequest createJobRequest(@RequestBody JobRequest request) {
        return requestService.saveRequest(request);
    }

    @DeleteMapping("/{id}")
    public void deleteJobRequest(@PathVariable String id) {
        requestService.deleterRequestById(id);
    }
}

