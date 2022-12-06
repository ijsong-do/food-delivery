package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class EarningCancelPointed extends AbstractEvent {

    private Long id;

    public EarningCancelPointed(Point aggregate){
        super(aggregate);
    }
    public EarningCancelPointed(){
        super();
    }
}
