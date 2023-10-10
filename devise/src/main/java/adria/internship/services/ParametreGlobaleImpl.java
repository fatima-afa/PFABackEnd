package adria.internship.services;

import adria.internship.dto.ParameterGlobaleDto;
import adria.internship.entities.ParameterGlobale;
import adria.internship.exceptions.ParamNotFound;
import adria.internship.mappers.ParameterGlobaleMapper;
import adria.internship.repositories.ParameterGlobaleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class ParametreGlobaleImpl implements ParametreGlobaleService{

    private ParameterGlobaleMapper parameterGlobaleMapper;
    private ParameterGlobaleRepository parameterGlobaleRepository;
    @Override
    public ParameterGlobaleDto saveParametreGlobale(ParameterGlobaleDto parameterGlobaleDto) {
        ParameterGlobale parameterGlobale= parameterGlobaleMapper.parameterGlobaleDtoToParameterGlobale(parameterGlobaleDto);
        ParameterGlobale parameterGlobalesaved= parameterGlobaleRepository.save(parameterGlobale);
        return parameterGlobaleMapper.parameterGlobaleToDto(parameterGlobalesaved);
    }

    @Override
    public ParameterGlobaleDto getParametreGlobale(Long id) throws ParamNotFound {
        ParameterGlobale param=parameterGlobaleRepository.findById(id).orElse(null);
        if(param==null)throw new ParamNotFound("parametre not found");
        return parameterGlobaleMapper.parameterGlobaleToDto(param);
    }

    @Override
    public ParameterGlobaleDto updateParametreGlobale(Long id, ParameterGlobaleDto parameterGlobaleDto) {
        return null;
    }

    @Override
    public void deleteParametreGlobale(Long id) {
        parameterGlobaleRepository.deleteById(id);
    }

    @Override
    public List<ParameterGlobaleDto> allParametreGlobale() {
        List<ParameterGlobale> params = parameterGlobaleRepository.findAll();
        return params.stream()
                .map(parameterGlobaleMapper::parameterGlobaleToDto)
                .collect(Collectors.toList());
    }
}
