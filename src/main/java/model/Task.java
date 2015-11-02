package model;

/**
 * Created by Thomas on 02/11/2015.
 * The T parameter just indicate that the class will work with T
 */
public class Task<T> {

    public Class<T> aClass;
    public String method;

    public Task() {
    }

    public Task(Class<T> aClass, String method) {
        this.aClass = aClass;
        this.method = method;
    }

    public T run() throws Exception {
        aClass.getMethod(method).invoke(null);
        return (T) aClass;
    }
}
