package in.thoughtclan.ToolInventory.repositories;

import in.thoughtclan.ToolInventory.models.MasterTool;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterToolRepository extends MongoRepository<MasterTool, Integer> {
}
