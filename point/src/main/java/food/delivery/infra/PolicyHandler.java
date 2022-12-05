package food.delivery.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import food.delivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import food.delivery.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired PointRepository pointRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Paid'")
    public void wheneverPaid_UsePoint(@Payload Paid paid){

        Paid event = paid;
        System.out.println("\n\n##### listener UsePoint : " + paid + "\n\n");


        

        // Sample Logic //
        Point.usePoint(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceld'")
    public void wheneverOrderCanceld_Compensate(@Payload OrderCanceld orderCanceld){

        OrderCanceld event = orderCanceld;
        System.out.println("\n\n##### listener Compensate : " + orderCanceld + "\n\n");


        

        // Sample Logic //
        Point.compensate(event);
        

        

    }

}


