package pte.mik.habitstatsserver.service;

import java.util.List;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pte.mik.habitstatsserver.dto.ActionStatDto;
import pte.mik.habitstatsserver.entity.Stat;
import pte.mik.habitstatsserver.entity.StatCategory;
import pte.mik.habitstatsserver.entity.UnitType;
import pte.mik.habitstatsserver.repository.StatRepository;

import static pte.mik.habitstatsserver.service.TryCatchService.tryFunction;

@Service
@AllArgsConstructor
public class StatService {

    @Autowired
    private StatRepository statRepository;
    @Autowired
    private StatCategoryService statCategoryService;
    @Autowired
    private UnitTypeService unitTypeService;
    private final ModelMapper mapper = new ModelMapper();

    public StatService() {
        final TypeMap<ActionStatDto, Stat> propertyMapper = mapper.createTypeMap(ActionStatDto.class, Stat.class);
        final Converter<Integer, StatCategory> idToCategory = id -> statCategoryService.getCategoryById(id.getSource());
        final Converter<Integer, UnitType> idToUnitType = id -> unitTypeService.getById(id.getSource());

        propertyMapper.addMappings(
                mapper -> mapper.using(idToCategory).map(ActionStatDto::getCategoryId,Stat::setCategory)
        );
        propertyMapper.addMappings(
                mapper -> mapper.using(idToUnitType).map(ActionStatDto::getUnit_typeId,Stat::setUnit_type)
        );
    }

    public List<Stat> listAllStat() {
        return statRepository.findAll();
    }

    public String addStat(ActionStatDto stat) {
        Stat newStat = this.mapper.map(stat,Stat.class);
        return tryFunction(() -> statRepository.save(newStat));
    }

    public String editStat(ActionStatDto stat) {
        Stat newStat = this.mapper.map(stat,Stat.class);
        return tryFunction(() -> statRepository.save(newStat));
    }

    public String deleteStat(ActionStatDto stat) {
        return tryFunction(() -> statRepository.deleteById(stat.getId()));
    }


}
