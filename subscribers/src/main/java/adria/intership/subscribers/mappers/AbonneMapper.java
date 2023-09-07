package adria.intership.subscribers.mappers;

import adria.intership.subscribers.dto.AbonneDto;
import adria.intership.subscribers.entities.Abonne;
import adria.intership.subscribers.entities.Compte;
import adria.intership.subscribers.entities.Contrat;
import adria.intership.subscribers.entities.Message;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AbonneMapper {

    private BOMapper boMapper;
//    private MessageMapper messageMapper;
//    private CompteMapper compteMapper;
//    private ContratMapper contratMapper;

    public AbonneDto abonneToDto(Abonne abonne) {
        AbonneDto abonneDto = new AbonneDto();
        if (abonne != null) {
            BeanUtils.copyProperties(abonne, abonneDto);

            if (abonne.getBo() != null) {
                abonneDto.setBo(boMapper.boToDto(abonne.getBo()));
            }

//            if (abonne.getMessages() != null) {
//                abonneDto.setMessages(messageMapper.messageToDto((Message) abonne.getMessages()));
//            }
//
//            if (abonne.getComptes() != null) {
//                abonneDto.setComptes(compteMapper.compteToDto((Compte) abonne.getComptes()));
//            }
//
//            if (abonne.getContrats() != null) {
//                abonneDto.setContrats(contratMapper.contratToDto((Contrat) abonne.getContrats()));
//            }
        }
        return abonneDto;
    }

    public Abonne abonneDtoToAbonne(AbonneDto abonneDto) {
        Abonne abonne = new Abonne();
        if (abonneDto != null) {
            BeanUtils.copyProperties(abonneDto, abonne);

            if (abonneDto.getBo() != null) {
                abonne.setBo(boMapper.boDtoTobo(abonneDto.getBo()));
            }

//            if (abonneDto.getMessages() != null) {
//                abonne.setMessages((List<Message>) messageMapper.messageDtoToMessage(abonneDto.getMessages()));
//            }
//
//
//            if (abonneDto.getComptes() != null) {
//                abonne.setComptes((List<Compte>) compteMapper.compteDtoToCompte(abonneDto.getComptes()));
//            }
//
//            if (abonneDto.getContrats() != null) {
//                abonne.setContrats((List<Contrat>) contratMapper.DtoTocontrat(abonneDto.getContrats()));
//            }
        }
        return abonne;
    }
}