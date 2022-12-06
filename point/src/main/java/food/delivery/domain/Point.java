package food.delivery.domain;

import food.delivery.domain.EarningPointed;
import food.delivery.domain.EarningCancelPointed;
import food.delivery.PointApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Point_table")
@Data

public class Point  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private String point;

    @PostPersist
    public void onPostPersist(){


        EarningPointed earningPointed = new EarningPointed(this);
        earningPointed.publishAfterCommit();



        EarningCancelPointed earningCancelPointed = new EarningCancelPointed(this);
        earningCancelPointed.publishAfterCommit();

    }

    public static PointRepository repository(){
        PointRepository pointRepository = PointApplication.applicationContext.getBean(PointRepository.class);
        return pointRepository;
    }




    public static void earningPoints(Paid paid){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

        
    }
    public static void cancellationOfEarningPoints(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

        
    }


}
