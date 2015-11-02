/**
 * Created by Thomas on 01/11/2015.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;

public class Send extends Amqp {

    /**
     * Send a "Hello World message"
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Channel channel = connect();
        Task task = new Task().setaClass("testClass").setMethod("testMethod");
        ObjectMapper mapper = new ObjectMapper();
        String message = mapper.writeValueAsString(task);
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + task + " - " + message + "'");
        System.exit(0);
    }
}
