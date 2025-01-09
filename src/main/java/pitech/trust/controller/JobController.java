package pitech.trust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pitech.trust.model.Job;
import pitech.trust.service.JobService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.findAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable String id) {
        Optional<Job> user = jobService.findJobByID(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable String id) {
        jobService.deleteJobById(id);
    }
}

