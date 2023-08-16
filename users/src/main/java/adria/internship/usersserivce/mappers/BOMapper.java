package adria.internship.usersserivce.mappers;

import adria.internship.usersserivce.dto.BODto;
import adria.internship.usersserivce.entities.BO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BOMapper {
    public BODto boToDto(BO candidat){

        BODto boDto = new BODto();
        BeanUtils.copyProperties(candidat, boDto);

        return boDto;
    }

    public BO boDtoTobo(BODto boDto){

        BO bo = new BO();
        BeanUtils.copyProperties(boDto, bo);

        return bo;
    }

}
