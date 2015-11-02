package Main; /**
 * Created by Thomas on 01/11/2015.
 */

import AMQP.Amqp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;

public class Send extends Amqp {

    /**
     * Main.Send a "Hello World message"
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //Connection to the amqp server
        Channel channel = connect();

        //Create a new task with parameter the class should be attacked and the method to invoke !
        Task task = new Task<Game>(Game.class,"getGames");

        //Json mapper to convert to JSON
        ObjectMapper mapper = new ObjectMapper();
        String message = mapper.writeValueAsString(task);

        //publish the json to the queue and write it !
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + task + " - " + message + "'");
        System.exit(0);
    }
}
