package in.thoughtclan.ToolInventory.services;

import in.thoughtclan.ToolInventory.models.ToolType;
import in.thoughtclan.ToolInventory.models.User;
import in.thoughtclan.ToolInventory.repositories.ToolTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.tools.Tool;
import java.util.List;
import java.util.Optional;

@Service
public class ToolTypeService {
    @Autowired
    private ToolTypeRepository toolTypeRepository;

    public List<ToolType> findAll(){
        return toolTypeRepository.findAll();
    }

    public Optional<ToolType> findById(int id){
        return toolTypeRepository.findById(id);
    }

    public ToolType save(ToolType toolType){
        return toolTypeRepository.save(toolType);
    }

    public void deleteById(int id){toolTypeRepository.deleteById(id);}
}
