package in.thoughtclan.ToolInventory.models;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "MasterTool")
public class MasterTool {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int tool_id;

    private int tool_type_id;

    private String tool_accuracy;

    private String tool_location;

    private int tool_lifecycle;

}
