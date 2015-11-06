package resources;

import java.util.List;

/**
 * Created by Thomas on 03/11/2015.
 */
//TODO We have to check dependency into ressource
public abstract class Resource {
    protected static List<Resource> instances;

    protected Class aClass;
    protected String method;
    protected Class[] parametersType;
    protected Object[] parameters;

    protected Resource(Class aClass, String method, Class[] parametersType, Object[] parameters) {
        this.aClass = aClass;
        this.method = method;
        this.parametersType = parametersType;
        this.parameters = parameters;
    }

    protected Resource(Class aClass, String method){
        this(aClass,method,null,null);
    }

    public Class getaClass() {
        return aClass;
    }

    public String getMethod() {
        return method;
    }

    public Class[] getParametersType() {
        return parametersType;
    }

    public Object[] getParameters() {
        return parameters;
    }
}
