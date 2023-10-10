package adria.internship.account.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Operateurdto {
    private  int id;
    private String nomOper;
    private String logo;
//   private List<RechargeTele> rechargeTeles;
}
