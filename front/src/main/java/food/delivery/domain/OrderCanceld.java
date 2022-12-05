package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderCanceld extends AbstractEvent {

    private Long id;
    private String foodId;
    private List<String> options;
    private String address;
    private Integer qty;
    private String customerId;
    private String storeId;

    public OrderCanceld(Order aggregate){
        super(aggregate);
    }
    public OrderCanceld(){
        super();
    }
}
