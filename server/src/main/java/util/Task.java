package util;

import resources.Resource;
import responses.TaskResponse;

/**
 * Created by Thomas on 04/11/2015.
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

    public Task(TaskResponse taskResponse){
        this(taskResponse.aClass,taskResponse.method,taskResponse.parametersMethod,taskResponse.parameters);
    }

    public Task(Resource resource){
        this(resource.getaClass(), resource.getMethod(), resource.getParametersType(), resource.getParameters());
    }

    public void run() throws Exception {
//        System.out.println("Task.run() launched with : " + aClass.toString() + " / " + method + " / " + parametersMethod.length + " item in parametersMethod  / " + parameters.length + " parameters ");
        Harvester.harvest(aClass.getMethod(method, parametersMethod).invoke(null, parameters));
    }
}
