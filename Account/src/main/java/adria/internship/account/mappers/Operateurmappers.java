package adria.internship.account.mappers;

import adria.internship.account.dto.Operateurdto;
import adria.internship.account.entities.Operateur;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Operateurmappers {

    public Operateurdto operatorToDto(Operateur operateur){
        Operateurdto operateurdto=new Operateurdto();
        if(operateur !=null){
            BeanUtils.copyProperties(operateur,operateurdto);
            return operateurdto;
        }
        return null;
    }

    public Operateur operateurDtoToOperateur(Operateurdto operateurdto){
        Operateur operateur=new Operateur();
        if(operateurdto!=null){
            BeanUtils.copyProperties(operateurdto,operateur);
            return operateur;
        }
        return null;
    }
}
