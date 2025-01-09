package pitech.trust.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pitech.trust.model.JobRequest;

@Repository
public interface RequestRepository  extends MongoRepository<JobRequest, String> {
}
