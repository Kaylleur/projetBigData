import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by Thomas on 01/11/2015.
 */
public class Receive extends Amqp{


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
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);

        for (int i = 0; i < 1000; i++) {
            Thread.sleep(10);
            System.out.println( "Are we synchronous ?");
        }


    }
}
