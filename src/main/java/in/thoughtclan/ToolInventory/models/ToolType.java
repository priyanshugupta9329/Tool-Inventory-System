package in.thoughtclan.ToolInventory.models;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Data
@Document(collection = "ToolType")
public class ToolType {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String tool_type_id;

    private String tool_type_name;

    private String tool_type_description;

    public String getTool_type_id() {
        return tool_type_id;
    }

}