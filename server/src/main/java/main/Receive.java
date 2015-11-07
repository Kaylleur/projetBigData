package main;

import amqp.Amqp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import responses.TaskResponse;
import util.Task;

import java.io.IOException;

/**
 * Created by Thomas on 01/11/2015.
 */
public class Receive{
    
    /**
     * Consumne messages from amqp
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Amqp.connect(Amqp.QUEUE_TASK);
        Channel channel = Amqp.getCurrentChannel();

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                ObjectMapper mapper = new ObjectMapper();
                Task task = new Task(mapper.readValue(body, TaskResponse.class));
                try {
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(" [x] Received '" + task + "'");
            }
        };
        channel.basicConsume(Amqp.QUEUE_TASK, true, consumer);

    }
}
