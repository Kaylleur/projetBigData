package main;

import amqp.Amqp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import models.Task;
import responses.Response;

import java.io.IOException;

/**
 * Created by Thomas on 01/11/2015.
 */
public class Receive extends Amqp {
    
    /**
     * Consumne messages from amqp
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Channel channel = connect();

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                ObjectMapper mapper = new ObjectMapper();
                Task<Response> task = mapper.readValue(body, Task.class);
                try {
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(" [x] Received '" + task + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }
}