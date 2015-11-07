package resources;


/**
 * Created by Thomas on 03/11/2015.
 * Resources are summary for method per model
 */
//TODO We have to check dependency into resource
public abstract class Resource {

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
