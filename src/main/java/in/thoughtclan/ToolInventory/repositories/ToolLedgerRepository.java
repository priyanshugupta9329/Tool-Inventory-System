package in.thoughtclan.ToolInventory.repositories;

import in.thoughtclan.ToolInventory.models.ToolLedger;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolLedgerRepository extends MongoRepository<ToolLedger, Integer> {
}
