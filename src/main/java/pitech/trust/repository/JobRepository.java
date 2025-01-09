package pitech.trust.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pitech.trust.model.Job;

@Repository
public interface JobRepository extends MongoRepository<Job, String> {
}
