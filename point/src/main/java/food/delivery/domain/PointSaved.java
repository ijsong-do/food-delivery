package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PointSaved extends AbstractEvent {

    private Long id;

    public PointSaved(Point aggregate){
        super(aggregate);
    }
    public PointSaved(){
        super();
    }
}
