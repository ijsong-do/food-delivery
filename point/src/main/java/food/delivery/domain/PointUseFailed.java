package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PointUseFailed extends AbstractEvent {

    private Long id;

    public PointUseFailed(Point aggregate){
        super(aggregate);
    }
    public PointUseFailed(){
        super();
    }
}
