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
@Document(collection = "Machine")
public class Machine {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int machine_id;

    private String machine_name;

    private String machine_description;

    private int tool_type_id;

    private int user_id;

    private String machine_status;

}
