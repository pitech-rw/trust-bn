package pitech.trust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pitech.trust.model.JobRequest;
import pitech.trust.repository.RequestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    private final RequestRepository requestRepository;

    @Autowired
    public RequestService(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    public List<JobRequest> findAllRequests(){
        return requestRepository.findAll();
    }

    public Optional<JobRequest> findRequestByID(String id ){
        return requestRepository.findById(id);
    }

    public JobRequest saveRequest(JobRequest request) {
        return requestRepository.save(request);
    }

    public void deleterRequestById(String id) {
        requestRepository.deleteById(id);
    }
}
