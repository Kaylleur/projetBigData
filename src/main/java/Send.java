/**
 * Created by Thomas on 01/11/2015.
 */

import com.rabbitmq.client.Channel;

public class Send extends Amqp {

    /**
     * Send a "Hello World message"
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Channel channel = connect();
        String message = "Hello World!";
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [" + i + "] Sent '" + message + "'");
        }
        System.exit(0);
    }
}
