package in.thoughtclan.ToolInventory.controllers;

import in.thoughtclan.ToolInventory.models.ToolLedger;
import in.thoughtclan.ToolInventory.models.User;
import in.thoughtclan.ToolInventory.services.ToolLedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ToolLedgerController {
    @Autowired
    private ToolLedgerService toolLedgerService;

    @GetMapping("/getToolLedger")
    public ResponseEntity<?> getAllToolLedger() {

        List<ToolLedger> toolLedger = toolLedgerService.findAll();
        if (toolLedger.size() > 0) {
            return new ResponseEntity<List<ToolLedger>>(toolLedger, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No tool entries yet", HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/postToolLedger")
    public ResponseEntity<?> createToolLedger(@RequestBody ToolLedger toolLedger){
        try{
            int id = toolLedger.getTool_ledger_id();
            Optional<ToolLedger> toolLedgerOptional = toolLedgerService.findById(id);
            if(toolLedgerOptional.isPresent()){

                return new ResponseEntity<>("Already available with same id " + id, HttpStatus.NOT_FOUND);
            }
            toolLedgerService.save(toolLedger);
            return new ResponseEntity<ToolLedger>(toolLedger, HttpStatus.OK);
        }
        catch(Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/ToolLedger/{id}")
    public ResponseEntity<?> getSingleToolLedger(@PathVariable("id") int id){
        Optional<ToolLedger> toolLedgerOptional = toolLedgerService.findById(id);
        if(toolLedgerOptional.isPresent()){
            return new ResponseEntity<>(toolLedgerOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No entery about tool with id" + id, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/putToolLedger/{id}")
    public ResponseEntity<?> UpdateById(@PathVariable("id") int id, @RequestBody ToolLedger toolLedger){

        Optional<ToolLedger> toolLedgerOptional = toolLedgerService.findById(id);
        if(toolLedgerOptional.isPresent()){
            ToolLedger toolLedgertosave = toolLedgerOptional.get();
            toolLedgertosave.setUser_id(toolLedger.getUser_id() != 0 ? toolLedger.getUser_id() : toolLedgertosave.getUser_id());
            toolLedgertosave.setTool_id(toolLedger.getTool_id() != 0 ? toolLedger.getTool_id() : toolLedgertosave.getTool_id());
            toolLedgertosave.setMachine_id(toolLedger.getMachine_id() != 0 ? toolLedger.getMachine_id() : toolLedgertosave.getMachine_id());
            toolLedgertosave.setStart_date_time(toolLedger.getStart_date_time() != null ? toolLedger.getStart_date_time() : toolLedgertosave.getStart_date_time());
            toolLedgertosave.setEnd_date_time(toolLedger.getEnd_date_time() != null ? toolLedger.getEnd_date_time() : toolLedgertosave.getEnd_date_time());
            toolLedgertosave.setTool_lifecycle(toolLedger.getTool_lifecycle() != null ? toolLedger.getTool_lifecycle() : toolLedgertosave.getTool_lifecycle());

            toolLedgerService.save(toolLedgertosave);
            return new ResponseEntity<>(toolLedgertosave, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("User not found by id "+ id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/ToolLedger/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id){

        try{
            toolLedgerService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted id " + id, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
