package util;

import resources.Resource;
import responses.TaskResponse;

/**
 * Created by Thomas on 04/11/2015.
 * A task is the class used to give order on collector
 * She execute a method and send to the harvester the result
 */
public class Task {
    private Class aClass;
    private String method;
    private Class[] parametersMethod;
    private Object[] parameters;

    private Task(Class aClass, String method, Class[] parametersMethod, Object... parameters) {
        this.aClass = aClass;
        this.method = method;
        this.parametersMethod = parametersMethod;
        this.parameters = parameters;
    }

    /**
     * To build Task before send into the amqp
     * @param taskResponse
     */
    public Task(TaskResponse taskResponse){
        this(taskResponse.aClass,taskResponse.method,taskResponse.parametersMethod,taskResponse.parameters);
    }

    /**
     * to build Task from json sent into the amqp
     * @param resource
     */
    public Task(Resource resource){
        this(resource.getaClass(), resource.getMethod(), resource.getParametersType(), resource.getParameters());
    }

    public void run() throws Exception {
//        System.out.println("Task.run() launched with : " + aClass.toString() + " / " + method + " / " + parametersMethod.length + " item in parametersMethod  / " + parameters.length + " parameters ");
        Harvester.harvest(aClass.getMethod(method, parametersMethod).invoke(null, parameters));
    }
}
