package in.thoughtclan.ToolInventory.repositories;

import in.thoughtclan.ToolInventory.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

//    boolean findAllById(int id);
}
