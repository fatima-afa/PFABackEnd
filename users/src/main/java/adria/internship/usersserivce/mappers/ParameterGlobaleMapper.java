package adria.internship.usersserivce.mappers;

import adria.internship.usersserivce.dto.ParameterGlobaleDto;
import adria.internship.usersserivce.entities.ParameterGlobale;
import org.springframework.beans.BeanUtils;

public class ParameterGlobaleMapper {

    private AdminMapper adminMapper;
    public ParameterGlobaleDto parameterGlobaleToDto(ParameterGlobale parameterGlobale) {
        ParameterGlobaleDto parameterGlobaleDto = new ParameterGlobaleDto();
        BeanUtils.copyProperties(parameterGlobale, parameterGlobaleDto);
        parameterGlobaleDto.setAdminDto(adminMapper.adminToDto(parameterGlobale.getAdmin()));
        return parameterGlobaleDto;
    }

    public ParameterGlobale parameterGlobaleDtpToParameterGlobale(ParameterGlobaleDto parameterGlobaleDto) {
        ParameterGlobale parameterGlobale = new ParameterGlobale();
        BeanUtils.copyProperties(parameterGlobaleDto, parameterGlobale);
        parameterGlobale.setAdmin(adminMapper.adminDtoToAdmin(parameterGlobaleDto.getAdminDto()));
        return parameterGlobale;
    }
}
