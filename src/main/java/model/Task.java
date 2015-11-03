package model;

import ressources.Resource;

/**
 * Created by Thomas on 02/11/2015.
 * The T parameter just indicate that the class will work with T
 *
 */
//@TODO This class is not amqp we should use a class named TaskResponse to convert from Json then create a Task from the TaskResponse !
public class Task<T> {

    public Class<T> aClass;
    public String method;
    public Class[] parametersMethod;
    public Object[] parameters;

    /**
     * Keep the empty constructor for conversion json to the object
     */
    public Task() {
    }

    private Task(Class<T> aClass, String method, Class[] parametersMethod, Object... parameters) {
        this.aClass = aClass;
        this.method = method;
        this.parametersMethod = parametersMethod;
        this.parameters = parameters;
    }

    public Task(Resource resource){
        this(resource.getaClass(), resource.getMethod(), resource.getParametersType(), resource.getParameters());
    }

    public T run() throws Exception {
        aClass.getMethod(method, parametersMethod).invoke(null, parameters);
        return (T) aClass;
    }
}
