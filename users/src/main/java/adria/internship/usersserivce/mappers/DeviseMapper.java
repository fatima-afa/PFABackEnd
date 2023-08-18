package adria.internship.usersserivce.mappers;

import adria.internship.usersserivce.dto.DeviseDto;
import adria.internship.usersserivce.entities.Devise;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviseMapper {

    private AdminMapper adminMapper;
    public DeviseDto deviseToDto(Devise devise) {
        DeviseDto deviseDto = new DeviseDto();

        BeanUtils.copyProperties(devise, deviseDto);
        deviseDto.setAdminDto(adminMapper.adminToDto(devise.getAdmin()));
        return deviseDto;
    }

    public Devise deviseDtoToDevise(DeviseDto deviseDto) {
        Devise devise = new Devise();
        BeanUtils.copyProperties(deviseDto, devise);
        devise.setAdmin(adminMapper.adminDtoToAdmin(deviseDto.getAdminDto()));
        return devise;
    }
}
