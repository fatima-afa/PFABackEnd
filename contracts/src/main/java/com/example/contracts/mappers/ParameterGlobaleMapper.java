package com.example.contracts.mappers;

import com.example.contracts.dto.ParameterGlobaleDto;
import com.example.contracts.entities.ParameterGlobale;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
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
