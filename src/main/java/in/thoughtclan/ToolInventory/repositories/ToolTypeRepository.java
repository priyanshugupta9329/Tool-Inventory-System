package in.thoughtclan.ToolInventory.repositories;

import in.thoughtclan.ToolInventory.models.ToolType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolTypeRepository extends MongoRepository<ToolType, Integer> {
}
