package food.delivery.domain;

import food.delivery.domain.PointUsed;
import food.delivery.domain.PointUseFailed;
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

    @PostPersist
    public void onPostPersist(){


        PointUsed pointUsed = new PointUsed(this);
        pointUsed.publishAfterCommit();



        PointUseFailed pointUseFailed = new PointUseFailed(this);
        pointUseFailed.publishAfterCommit();

    }

    public static PointRepository repository(){
        PointRepository pointRepository = PointApplication.applicationContext.getBean(PointRepository.class);
        return pointRepository;
    }




    public static void usePoint(Paid paid){

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
    public static void compensate(OrderCanceld orderCanceld){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceld.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

        
    }


}
