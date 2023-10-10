package adria.intership.subscribers.mappers;

import adria.intership.subscribers.dto.ContratDto;
import adria.intership.subscribers.entities.Contrat;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContratMapper {
    private BOMapper boMapper;

    public ContratDto contratToDto(Contrat contrat) {
        ContratDto contratDto = new ContratDto();
        if (contrat != null) {
            BeanUtils.copyProperties(contrat, contratDto);
            if (contrat.getBo() != null) {
                contratDto.setBo(boMapper.boToDto(contrat.getBo()));
            } else {
                contratDto.setBo(null);
            }
            return contratDto;
        }
        return null;

    }

    public Contrat DtoTocontrat(ContratDto contratDto) {
        Contrat contrat = new Contrat();
        if (contratDto != null) {
            BeanUtils.copyProperties(contratDto, contrat);
            if (contratDto.getBo() != null) {
                contrat.setBo(boMapper.boDtoTobo(contratDto.getBo()));
            } else {
                contrat.setBo(null);
            }
            return contrat;
        }
        return null;
    }
}
