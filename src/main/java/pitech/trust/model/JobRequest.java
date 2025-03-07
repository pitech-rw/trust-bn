package pitech.trust.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Setter
@Getter
@Document(collection = "JobRequest")
public class JobRequest {
    @Id
    private String requestId;
    private User Client;
    private User provider;
    private Job job;
    private JobCategory jobCategory;
    private String jobLocation;
    private Long price;
    private Timestamp requestTime;
    private Timestamp updatedAt;
    private Timestamp completedAt;
    private String requestStatus;
    private String feedback;

}
