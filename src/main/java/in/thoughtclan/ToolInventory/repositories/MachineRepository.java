package in.thoughtclan.ToolInventory.repositories;

import in.thoughtclan.ToolInventory.models.Machine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends MongoRepository<Machine, Integer> {

}
