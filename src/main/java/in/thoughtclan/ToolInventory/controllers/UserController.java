package in.thoughtclan.ToolInventory.controllers;

import in.thoughtclan.ToolInventory.models.User;
import in.thoughtclan.ToolInventory.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {

        List<User> user = userRepo.findAll();
        if (user.size() > 0) {
            return new ResponseEntity<List<User>>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No user available", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            String id = user.getUser_id();
            Optional<User> userOptional = userRepo.findById(id);
            if(userOptional.isPresent()){

                return new ResponseEntity<>("Already available with same id " + id, HttpStatus.NOT_FOUND);
            }
            userRepo.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        catch(Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getSingleUser(@PathVariable("id") String id){
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isPresent()){
            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("User not found with id" + id, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> UpdateById(@PathVariable("id") String id, @RequestBody User user){

        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isPresent()){
            User usertosave = userOptional.get();
            usertosave.setUser_name(user.getUser_name() != null ? user.getUser_name() : usertosave.getUser_name());
            usertosave.setUser_password(user.getUser_password() != null ? user.getUser_password() : usertosave.getUser_password());
            usertosave.setMachine_id(user.getMachine_id() != null ? user.getMachine_id() : usertosave.getMachine_id());

            userRepo.save(usertosave);
            return new ResponseEntity<>(usertosave, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("User not found by id "+ id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id){

        try{
            userRepo.deleteById(id);
            return new ResponseEntity<>("Successfully deleted id " + id, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
