package pitech.trust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pitech.trust.model.Job;
import pitech.trust.repository.JobRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    public List<Job> findAllJobs(){
        return jobRepository.findAll();
    }

    public Optional<Job> findJobByID(String id ){
        return jobRepository.findById(id);
    }

    public Job saveJob(Job request) {
        return jobRepository.save(request);
    }

    public void deleteJobById(String id) {
        jobRepository.deleteById(id);
    }
}
