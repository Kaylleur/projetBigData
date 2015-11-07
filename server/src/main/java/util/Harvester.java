package util;

import main.Send;

/**
 * Created by Thomas on 06/11/2015.
 */
public class Harvester {

    public static void harvest(Object object) throws Exception {
        Send.run(object);
    }
}
