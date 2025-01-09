package pitech.trust.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "Job")
public class Job {

    @Id
    private String jobId;
    private String jobName;
    private JobCategory jobCategory;
}
