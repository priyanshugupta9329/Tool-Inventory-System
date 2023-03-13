package in.thoughtclan.ToolInventory.services;

import in.thoughtclan.ToolInventory.models.Machine;
import in.thoughtclan.ToolInventory.models.MasterTool;
import in.thoughtclan.ToolInventory.repositories.MasterToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasterToolService {

    @Autowired
    private MasterToolRepository masterToolRepository;

    public List<MasterTool> findAll(){
        return masterToolRepository.findAll();
    }

    public Optional<MasterTool> findById(int id){
        return masterToolRepository.findById(id);
    }

    public MasterTool save(MasterTool masterTool){
        return masterToolRepository.save(masterTool);
    }

    public void deleteById(int id) {
        masterToolRepository.deleteById(id);
    }
}
