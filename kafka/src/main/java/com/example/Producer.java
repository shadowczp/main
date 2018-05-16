package com.example;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer extends Thread {
    private Logger logger = LoggerFactory.getLogger(App.class);
    private  KafkaProducer<Integer,String> prod;
    private  String topic;
    private Boolean isAsync;

    public Producer(String topic , Boolean isAsync){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"kafka1:9092");
        props.put("client.id","DemoProducer");
        props.put("key.serializer","org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        prod = new KafkaProducer<Integer, String>(props);
        this.topic=topic;
        this.isAsync=isAsync;
    }

    @Override
    public void run() {

        int num=1;
        while (true){
            String msg="Message_"+num;
            if(isAsync){
                prod.send(new ProducerRecord<Integer, String>(topic, num, msg),
                        new Callback() {
                            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                                System.out.println("#offset:"+recordMetadata.offset());
                            }
                        });
            }else {
                try {
                    prod.send(new ProducerRecord<Integer, String>(topic,num,msg)).get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            num++;
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
