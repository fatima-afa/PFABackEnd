package adria.internship.account.mappers;


import adria.internship.account.dto.DeviseDto;
import adria.internship.account.entities.Devise;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviseMapper {

    private AdminMapper adminMapper;
    public DeviseDto deviseToDto(Devise devise) {
        DeviseDto deviseDto = new DeviseDto();
            if(devise!=null){
                BeanUtils.copyProperties(devise, deviseDto);
                if(devise.getAdmin()!=null)
                    deviseDto.setAdminDto(adminMapper.adminToDto(devise.getAdmin()));
                else
                    deviseDto.setAdminDto(null);
                return deviseDto;
            }
            return null;
    }

    public Devise deviseDtoToDevise(DeviseDto deviseDto) {
        Devise devise = new Devise();
        if(deviseDto!=null){
            BeanUtils.copyProperties(deviseDto, devise);
            if(deviseDto.getAdminDto()!=null)
             devise.setAdmin(adminMapper.adminDtoToAdmin(deviseDto.getAdminDto()));
            else
                devise.setAdmin(null);
            return devise;
        }
        return null;

    }
}
