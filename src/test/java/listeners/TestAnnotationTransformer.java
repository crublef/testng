package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestAnnotationTransformer implements IAnnotationTransformer {
    @Override
    @AfterMethod
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {

        List<String> groupNames = Arrays.asList(annotation.getGroups());
        System.out.println(groupNames);
        //Value 'betaTest' can be read from many places like properties file, run time parameter etc...
        //For Simplicity, group is hardcoded in this program

        String groupNameToSkip = "betaTest";

        if(groupNames.contains(groupNameToSkip)){
            System.out.println("found group name");
            annotation.setEnabled(false);
        }
    }
}