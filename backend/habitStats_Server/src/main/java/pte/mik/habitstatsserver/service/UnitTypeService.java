package pte.mik.habitstatsserver.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pte.mik.habitstatsserver.entity.UnitType;
import pte.mik.habitstatsserver.repository.UnitTypeRepository;

@Service
@AllArgsConstructor
public class UnitTypeService {

    @Autowired
    private UnitTypeRepository unitTypeRepository;

    public UnitType getUnitTypeById(Integer id){
        return unitTypeRepository.getById(id);
    }
}
