package test.src.testframework;

import logger.src.logger.*;

import restaurant.src.restaurant.*;

//import restaurant.SaveProductSell;

import java.lang.reflect.Method;

public class RunTest {
    private static Logger logger = LoggerFactory.getLogger("RunTest");
    private static int nbTest[] = new int[2];

    private static void classTest(String name) {
        try {
            Class<?> clazz = Class.forName(name);
            try {
                Object instance = clazz.newInstance();
                for(Method method : clazz.getDeclaredMethods()) {
                    methodTest(method, instance, clazz);
                }
            } catch (InstantiationException | IllegalAccessException e) {
                logger.error("OUTPUT", "Impossible to instanciante or illegal access to the class " + clazz.getName() + ".");
            }
        } catch (ClassNotFoundException e) {
            logger.error("OUTPUT", "The class " + name + " wasn't found.");
        }
    }

    private static void methodTest(Method method, Object instance, Class<?> clazz) {
        boolean error = false;
        long time = System.currentTimeMillis();
        try {
            method.invoke(instance);
        } catch (Exception e) {
            logger.error("OUTPUT", "--> Error " + clazz.getName() + "." + method.getName() + " : " + e.getMessage());
            error = true;
        }
        time = System.currentTimeMillis() - time;
        nbTest[error ? 0:1]++;
        if(!error) logger.info("OUTPUT","OK : " + clazz.getName() + "." + method.getName() + " en " + time + " ms.");
        else logger.info("OUTPUT","KO : " + clazz.getName() + "." + method.getName() + " en " + time + " ms.");
    }


    public static void main(String args[]){

        long time = System.currentTimeMillis();
        nbTest[0] = nbTest[1] = 0;
        for(String name: args) {
            classTest(name);
        }
        int sumTest = nbTest[0] + nbTest[1];
        time = System.currentTimeMillis() - time;
        logger.info("OUTPUT", "-----------");
        logger.info("OUTPUT", "Number of tests : " + sumTest);
        logger.info("OUTPUT", "OK = " + nbTest[1] + " (" + (float)nbTest[1]/sumTest*100 + "%)");
        logger.info("OUTPUT", "KO = " + nbTest[0] + " (" + (float)nbTest[0]/sumTest*100 + "%)");
        logger.info("OUTPUT","Duration = " + time + " ms");

        NoteTest.calculateCheckTest();
        NoteTest.addNewProductTest();


    }

}
