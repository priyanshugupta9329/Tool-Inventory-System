package in.thoughtclan.ToolInventory.controllers;

import in.thoughtclan.ToolInventory.models.MasterTool;
import in.thoughtclan.ToolInventory.models.User;
import in.thoughtclan.ToolInventory.services.MasterToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MasterToolController {

    @Autowired
    private MasterToolService masterToolService;

    @GetMapping("/getmastertool")
    public ResponseEntity<?> getAllmastertool() {

        List<MasterTool> masterTools = masterToolService.findAll();
        if (masterTools.size() > 0) {
            return new ResponseEntity<List<MasterTool>>(masterTools, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No master tool available", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/postmastertool")
    public ResponseEntity<?> createMastertool(@RequestBody MasterTool masterTool){
        try{
            int id = masterTool.getTool_id();
            Optional<MasterTool> mastertoolOptional = masterToolService.findById(id);
            if(mastertoolOptional.isPresent()){

                return new ResponseEntity<>("Already available with same tool id " + id, HttpStatus.NOT_FOUND);
            }
            masterToolService.save(masterTool);
            return new ResponseEntity<MasterTool>(masterTool, HttpStatus.OK);
        }
        catch(Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getmastertool/{id}")
    public ResponseEntity<?> getSingletool(@PathVariable("id") int id){
        Optional<MasterTool> masterToolOptional = masterToolService.findById(id);
        if(masterToolOptional.isPresent()){
            return new ResponseEntity<>(masterToolOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Tool not found with id " + id, HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/putmastertool/{id}")
    public ResponseEntity<?> UpdateById(@PathVariable("id") int id, @RequestBody MasterTool masterTool){

        Optional<MasterTool> mastertoolOptional = masterToolService.findById(id);
        if(mastertoolOptional.isPresent()){
            MasterTool tooltosave = mastertoolOptional.get();
            tooltosave.setTool_type_id(masterTool.getTool_type_id() != 0 ? masterTool.getTool_type_id() : tooltosave.getTool_type_id());
            tooltosave.setTool_accuracy(masterTool.getTool_accuracy() != null ? masterTool.getTool_accuracy() : tooltosave.getTool_accuracy());
            tooltosave.setTool_location(masterTool.getTool_location() != null ? masterTool.getTool_location() : tooltosave.getTool_location());
            tooltosave.setTool_lifecycle(masterTool.getTool_lifecycle() != 0 ? masterTool.getTool_lifecycle() : tooltosave.getTool_lifecycle());

            masterToolService.save(tooltosave);
            return new ResponseEntity<>(tooltosave, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Tool not found by id "+ id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletemastertool/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id){

        try{
            masterToolService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted id " + id, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
