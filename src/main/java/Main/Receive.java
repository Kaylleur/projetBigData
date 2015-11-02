package Main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by Thomas on 01/11/2015.
 */
public class Receive extends AMQP.Amqp {


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
                Task message = mapper.readValue(body, Task.class);
                try {
                    message.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }
}
