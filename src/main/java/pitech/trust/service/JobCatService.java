package pitech.trust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pitech.trust.model.JobCategory;
import pitech.trust.repository.JobCatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobCatService {

    private final JobCatRepository jobCatRepository;

    @Autowired
    public JobCatService(JobCatRepository jobCatRepository){
        this.jobCatRepository = jobCatRepository;
    }

    public List<JobCategory> findAllJobCats(){
        return jobCatRepository.findAll();
    }

    public Optional<JobCategory> findJobCatsByID(String id ){
        return jobCatRepository.findById(id);
    }

    public JobCategory saveJobCat(JobCategory jobCategory) {
        return jobCatRepository.save(jobCategory);
    }

    public void deleterJobCatById(String id) {
        jobCatRepository.deleteById(id);
    }
}
