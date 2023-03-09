package in.thoughtclan.ToolInventory.models;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Data
@Document(collection = "MasterTool")
public class MasterTool {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String tool_id;

    private String tool_type_id;

    private String tool_accuracy;

    private String tool_location;

}
