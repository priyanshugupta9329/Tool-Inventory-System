package in.thoughtclan.ToolInventory.services;

import in.thoughtclan.ToolInventory.models.Machine;
import in.thoughtclan.ToolInventory.models.User;
import in.thoughtclan.ToolInventory.repositories.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> findAll(){
        return machineRepository.findAll();
    }

    public Optional<Machine> findById(int id){
        return machineRepository.findById(id);
    }

    public Machine save(Machine machine){
        return machineRepository.save(machine);
    }

    public void deleteById(int id) {
        machineRepository.deleteById(id);
    }
}
