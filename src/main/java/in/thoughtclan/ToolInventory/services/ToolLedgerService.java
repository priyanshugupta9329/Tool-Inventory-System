package in.thoughtclan.ToolInventory.services;

import in.thoughtclan.ToolInventory.models.ToolLedger;
import in.thoughtclan.ToolInventory.models.User;
import in.thoughtclan.ToolInventory.repositories.ToolLedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolLedgerService {
    @Autowired
    private ToolLedgerRepository toolLedgerRepository;

    public List<ToolLedger> findAll(){
        return toolLedgerRepository.findAll();
    }

    public Optional<ToolLedger> findById(int id){
        return toolLedgerRepository.findById(id);
    }

    public ToolLedger save(ToolLedger toolLedger){
        return toolLedgerRepository.save(toolLedger);
    }

    public void deleteById(int id) {
        toolLedgerRepository.deleteById(id);
    }

}
