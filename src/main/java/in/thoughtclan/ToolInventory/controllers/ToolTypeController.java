package in.thoughtclan.ToolInventory.controllers;

import in.thoughtclan.ToolInventory.models.ToolType;
import in.thoughtclan.ToolInventory.models.User;
import in.thoughtclan.ToolInventory.services.ToolTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.tools.Tool;
import java.util.List;
import java.util.Optional;

@RestController
public class ToolTypeController {
    @Autowired
    private ToolTypeService toolTypeService;

//    @GetMapping("/getToolType")
//    public ResponseEntity<?> getAllToolType() {
//
//        List<ToolType> toolType = toolTypeService.findAll();
//        if (toolType.size() > 0) {
//            return new ResponseEntity<List<ToolType>>(toolType, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("No tool type available", HttpStatus.NOT_FOUND);
//        }
//
//    }

    @GetMapping("/getToolType")
    public ResponseEntity<?> getAllToolType() {

        List<ToolType> toolType = toolTypeService.findAll();
        if (toolType.size() > 0) {
            return new ResponseEntity<List<ToolType>>(toolType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No such tool type available", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/postToolType")
    public ResponseEntity<?> createToolType(@RequestBody ToolType toolType){
        try{
            int id = toolType.getTool_type_id();
            Optional<ToolType> toolTypeOptional = toolTypeService.findById(id);
            if(toolTypeOptional.isPresent()){

                return new ResponseEntity<>("Already available with same id " + id, HttpStatus.NOT_FOUND);
            }
            toolTypeService.save(toolType);
            return new ResponseEntity<ToolType>(toolType, HttpStatus.OK);
        }
        catch(Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ToolType/{id}")
    public ResponseEntity<?> getSingleToolType(@PathVariable("id") int id){
        Optional<ToolType> toolTypeOptional = toolTypeService.findById(id);
        if(toolTypeOptional.isPresent()){
            return new ResponseEntity<>(toolTypeOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Tool type not found with id" + id, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/putToolType/{id}")
    public ResponseEntity<?> UpdateById(@PathVariable("id") int id, @RequestBody ToolType toolType){

        Optional<ToolType> toolTypeOptional = toolTypeService.findById(id);
        if(toolTypeOptional.isPresent()){
            ToolType toolTypetosave = toolTypeOptional.get();
            toolTypetosave.setTool_type_name(toolType.getTool_type_name() != null ? toolType.getTool_type_name() : toolTypetosave.getTool_type_name());
            toolTypetosave.setTool_type_description(toolType.getTool_type_description() != null ? toolType.getTool_type_description() : toolTypetosave.getTool_type_description());
            toolTypeService.save(toolTypetosave);
            return new ResponseEntity<>(toolTypetosave, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("User not found by id "+ id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/ToolType/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id){

        try{
            toolTypeService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted id " + id, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
