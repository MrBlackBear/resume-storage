import model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume();

        Field field = resume.getClass().getDeclaredFields()[0];
        System.out.println(field.getName());
        field.get(resume);
        System.out.println(resume);

        //Homework
        Class example = Class.forName("model.Resume");
        Method method = example.getMethod("toString");
        String simple = (String)method.invoke(resume);
    }
}
