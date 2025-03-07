package pitech.trust.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "JobCategory")
public class JobCategory {

    @Id
    private String catId;
    private String catNAme;
    private String type;
    private String catDescription;
    private String estimatedPrice;

}
