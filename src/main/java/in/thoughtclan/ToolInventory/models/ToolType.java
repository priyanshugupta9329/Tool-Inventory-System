package in.thoughtclan.ToolInventory.models;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ToolType")
public class ToolType {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String tool_type_id;

    private String tool_type_name;

    private String tool_type_description;


}