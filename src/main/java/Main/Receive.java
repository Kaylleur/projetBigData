package Main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import model.Task;

import java.io.IOException;

/**
 * Created by Thomas on 01/11/2015.
 */
public class Receive extends AMQP.Amqp {


    /**
     * Consumne messages from AMQP
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
                Task task = mapper.readValue(body, Task.class);
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
