import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Object object = new Object();

        // First way
        List objects1 = new ArrayList<Object>();
        objects1.add(object);

        // second way
        List<Object> objects2 = Arrays.asList(object);

        // Third way
        List<Object> objects3 = Collections.singletonList(object);
    }
}