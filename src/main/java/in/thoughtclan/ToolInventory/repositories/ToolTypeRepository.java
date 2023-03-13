package in.thoughtclan.ToolInventory.repositories;

import in.thoughtclan.ToolInventory.models.ToolType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToolTypeRepository extends MongoRepository<ToolType, Integer> {
}
