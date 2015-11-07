package amqp;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by Thomas on 01/11/2015.
 * Class to connect to our AMQP
 * we should use a json file to queue's name
 * We
 */
public class Amqp {

    private final static String QUEUE_TASK = "task";
    private final static String QUEUE_MODEL = "models";

    private static Channel currentChannel;
    private static Connection connection;

    public static void connect(String queueName)throws Exception{
        if(connection == null){
            //get variable
            String uri = System.getenv("cloud_amqp").split(";")[0];
            String username = System.getenv("cloud_amqp").split(";")[1];
            String password = System.getenv("cloud_amqp").split(";")[2];

            //initialize channel
            ConnectionFactory factory = new ConnectionFactory();
            factory.setUri(uri);
            factory.setUsername(username);
            factory.setPassword(password);
            connection = factory.newConnection();
        }

        Channel channel = connection.createChannel();

        channel.queueDeclare(queueName, false, false, false, null);
        currentChannel = channel;
    }

    public static Channel getCurrentChannel() {
        return currentChannel;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static String getQUEUE_TASK() {
        return QUEUE_TASK;
    }

    public static String getQUEUE_MODEL() {
        return QUEUE_MODEL;
    }
}
