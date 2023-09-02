package adria.intership.subscribers.mappers;

import adria.intership.subscribers.dto.MessageDto;
import adria.intership.subscribers.entities.Message;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageMapper {

    private BOMapper boMapper;
    private AbonneMapper abonneMapper;

    public MessageDto messageToDto(Message message) {
        MessageDto messageDto = new MessageDto();
        if (message != null) {
            BeanUtils.copyProperties(message, messageDto);

            if (message.getBo() != null) {
                messageDto.setBo(boMapper.boToDto(message.getBo()));
            }

            if (message.getAbonne() != null) {
                messageDto.setAbonne(abonneMapper.abonneToDto(message.getAbonne()));
            }
        }
        return messageDto;
    }

    public Message messageDtoToMessage(MessageDto messageDto) {
        Message message = new Message();
        if (messageDto != null) {
            BeanUtils.copyProperties(messageDto, message);

            if (messageDto.getBo() != null) {
                message.setBo(boMapper.boDtoTobo(messageDto.getBo()));
            }

            if (messageDto.getAbonne() != null) {
                message.setAbonne(abonneMapper.abonneDtoToAbonne(messageDto.getAbonne()));
            }
        }
        return message;
    }
}
