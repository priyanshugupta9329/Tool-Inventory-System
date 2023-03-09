package in.thoughtclan.ToolInventory.models;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Data
@Document(collection = "Machine")
public class Machine {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String machine_id;

    private String machine_name;

    private String machine_description;

    private String tool_type_id;

    private String user_id;

    private String machine_status;

}
