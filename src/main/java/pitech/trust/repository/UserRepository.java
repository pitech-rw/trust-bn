package pitech.trust.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pitech.trust.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);

    @Query("{'roles': 'provider', 'jobs.jobName': ?0}")
    List<User> findProvidersWithJob(String jobTitle);
}
