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
@Document(collection = "ToolLedger")
public class ToolLedger {


//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String tool_ledger_id;

    private String user_id;

    private String tool_id;

    private String machine_id;

    private String start_date_time;

    private String end_date_time;

    private String tool_lifecycle;

}
