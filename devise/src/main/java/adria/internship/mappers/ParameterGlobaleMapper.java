package adria.internship.mappers;

import adria.internship.dto.ParameterGlobaleDto;
import adria.internship.entities.ParameterGlobale;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParameterGlobaleMapper {

    private AdminMapper adminMapper;
    public ParameterGlobaleDto parameterGlobaleToDto(ParameterGlobale parameterGlobale) {
        ParameterGlobaleDto parameterGlobaleDto = new ParameterGlobaleDto();
        if(parameterGlobale!=null) {
            BeanUtils.copyProperties(parameterGlobale, parameterGlobaleDto);
            parameterGlobaleDto.setAdminDto(adminMapper.adminToDto(parameterGlobale.getAdmin()));
            return parameterGlobaleDto;
        }
        return null;
    }

    public ParameterGlobale parameterGlobaleDtoToParameterGlobale(ParameterGlobaleDto parameterGlobaleDto) {
        ParameterGlobale parameterGlobale = new ParameterGlobale();
        if (parameterGlobaleDto!=null) {
            BeanUtils.copyProperties(parameterGlobaleDto, parameterGlobale);
            parameterGlobale.setAdmin(adminMapper.adminDtoToAdmin(parameterGlobaleDto.getAdminDto()));
            return parameterGlobale;
        }
        return null;
    }
}
