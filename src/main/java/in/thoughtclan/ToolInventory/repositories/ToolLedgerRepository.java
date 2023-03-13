package in.thoughtclan.ToolInventory.repositories;

import in.thoughtclan.ToolInventory.models.ToolLedger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToolLedgerRepository extends MongoRepository<ToolLedger, Integer> {
}
