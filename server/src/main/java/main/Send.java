package main;
/**
 * Created by Thomas on 01/11/2015.
 */

import amqp.Amqp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;

public class Send {

    /**
     * main.Send
     * Send is called to parse an object into json
     * then she send him into the amqp file
     * ----
     * There is no control here !
     */
    public static void run(Object object) throws Exception {
        //Connection to the amqp server
        Amqp.connect(Amqp.getQUEUE_MODEL());
        Channel channel = Amqp.getCurrentChannel();

        //TODO TO IMPLEMENT TO SEND AFTER RECEIVE
        //publish the json to the queue and write it !
        ObjectMapper mapper = new ObjectMapper();
        String jsonToSend = mapper.writeValueAsString(object);
        channel.basicPublish("", Amqp.getQUEUE_MODEL(), null, jsonToSend.getBytes());

    }
}
