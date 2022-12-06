package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class EarningPointed extends AbstractEvent {

    private Long id;

    public EarningPointed(Point aggregate){
        super(aggregate);
    }
    public EarningPointed(){
        super();
    }
}
