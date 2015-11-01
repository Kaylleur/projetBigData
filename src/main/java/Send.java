/**
 * Created by Thomas on 01/11/2015.
 */

import com.rabbitmq.client.Channel;

public class Send extends Amqp {


    public static void main(String[] args) throws Exception {
        Channel channel = connect();
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        System.exit(0);
    }
}
