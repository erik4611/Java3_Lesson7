package ru.geekbrains.Java3_Lesson7;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StartTest {
    public static void start(CalculatorTest test){
        try {
            Class someClass = test.getClass();
            CalculatorTest class1 = (CalculatorTest) someClass.newInstance();
            runAllMethodsWithBeforeBeforeSuite(class1);
            runAllMethodsWithTest(class1);
            runAllMethodsWithBeforeAfterSuite(class1);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void runAllMethodsWithBeforeBeforeSuite(CalculatorTest test) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = test.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(BeforeSuite.class)){
                methods[i].invoke(test);
            }
        }
    }

    public static void runAllMethodsWithTest(CalculatorTest test) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = test.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(Test.class)){
                if(methods[i].getAnnotation(Test.class).priority() == 1){
                    System.out.println(methods[i].invoke(test,3,8,11));
                }
                else if(methods[i].getAnnotation(Test.class).priority() == 2){
                    System.out.println(methods[i].invoke(test,10,5,5));
                }
                else if(methods[i].getAnnotation(Test.class).priority() == 3){
                    System.out.println(methods[i].invoke(test,100,2,200));
                }
                else if(methods[i].getAnnotation(Test.class).priority() == 4){
                    System.out.println(methods[i].invoke(test,30,10,3));
                }
            }
        }
    }

    public static void runAllMethodsWithBeforeAfterSuite(CalculatorTest test) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = test.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].isAnnotationPresent(AfterSuite.class)){
                methods[i].invoke(test);
            }
        }
    }

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        start(test);
    }
}