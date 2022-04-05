package pte.mik.habitstatsserver.service.stat;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pte.mik.habitstatsserver.entity.stat.UnitType;
import pte.mik.habitstatsserver.repository.stat.UnitTypeRepository;

import java.util.List;

import static pte.mik.habitstatsserver.service.TryCatchService.tryFunction;

@Service
@AllArgsConstructor
public class UnitTypeService {

    @Autowired
    private UnitTypeRepository unitTypeRepository;

    public List<UnitType> listAll(){return unitTypeRepository.findAll();}

    public UnitType getById(Integer id){
        return unitTypeRepository.findById(id).get();
    }

    public String create(UnitType unitType){ return tryFunction(() -> unitTypeRepository.save(unitType));}

    public String delete(Integer id){ return tryFunction(() -> unitTypeRepository.deleteById(id));}
}
