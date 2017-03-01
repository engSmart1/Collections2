package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hytham on 2/28/2017.
 */

public class DataProvider {
    private static List<Course> data = new ArrayList<>();

    public static List<Course> getData() {
        return data;
    }
    static {
        data.add( new Course( 10101 , " Designing a Basic Digital Character I " ,
                "This course cover the creation of a basic" , 3));
        data.add( new Course( 10102 , " Designing a Basic Digital Character II " ,
                "This course cover the creation of a basic , This course cover the creation of a basic" , 3));
        data.add( new Course( 10103 , " Designing a Basic Digital Character III " ,
                "This course cover the creation of a basic ,This course cover the creation of a basic " +
                        ",This course cover the creation of a basic" , 3));
    }
}
