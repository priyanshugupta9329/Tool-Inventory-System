package in.thoughtclan.ToolInventory.controllers;


import in.thoughtclan.ToolInventory.models.Machine;
import in.thoughtclan.ToolInventory.services.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/machines")
    public ResponseEntity<?> getAllMachine(){
        List<Machine> machine = machineService.findAll();
        if (machine.size() > 0) {
            return new ResponseEntity<List<Machine>>(machine, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No machine available", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/machine")
    public ResponseEntity<?> createmachine(@RequestBody Machine machine){
        try{
            int id = machine.getMachine_id();
            Optional<Machine> machineOptional = machineService.findById(id);
            if(machineOptional.isPresent()){

                return new ResponseEntity<>("Already available with same id " + id, HttpStatus.NOT_FOUND);
            }
            machineService.save(machine);
            return new ResponseEntity<Machine>(machine, HttpStatus.OK);
        }
        catch(Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/machine/{id}")
    public ResponseEntity<?> getSingleMachine(@PathVariable("id") int id){
        Optional<Machine> machineOptional = machineService.findById(id);
        if(machineOptional.isPresent()){
            return new ResponseEntity<>(machineOptional.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("User not found with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/machine/{id}")
    public ResponseEntity<?> UpdateById(@PathVariable("id") int id, @RequestBody Machine machine){

        Optional<Machine> machineOptional = machineService.findById(id);
        if(machineOptional.isPresent()){
            Machine machinetosave = machineOptional.get();
            machinetosave.setMachine_name(machine.getMachine_name() != null ? machine.getMachine_name() : machinetosave.getMachine_name());
            machinetosave.setMachine_description(machine.getMachine_description() != null ? machine.getMachine_description() : machinetosave.getMachine_description());
            machinetosave.setMachine_status(machinetosave.getMachine_status() != null ? machine.getMachine_status() : machinetosave.getMachine_status());
            machinetosave.setTool_type_id(machine.getTool_type_id() != 0 ? machine.getTool_type_id() : machinetosave.getTool_type_id());
            machinetosave.setUser_id(machine.getUser_id() != 0 ? machine.getUser_id(): machinetosave.getUser_id());


            machineService.save(machinetosave);
            return new ResponseEntity<>(machinetosave, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Machine not found by id "+ id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/machine/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id){

        try{
            machineService.deleteById(id);
            return new ResponseEntity<>("Successfully deleted id " + id, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
