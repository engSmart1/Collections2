package musictag.hytham1.com.collections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.List;

import data.Course;
import data.DataProvider;

public class MainActivity extends AppCompatActivity {
    public static final String COURSE_TITLE = "courseTitle";
    public static final String COURSE_Desc = "courseDesc";
    public static final String COURSE_Num = "courseNum";
    public static final String COURSE_Credit = "courseCredit";
    public static final int DETAIL_REQUEST_CODE = 1001;
    List<Course> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = DataProvider.getData();

        ArrayAdapter<Course> courseArrayAdapter = new CourseArrayAdapter(this ,0, data);
        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(courseArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Course course = data.get(position);
                detailCourse(course);
            }
        });

    /*    Iterator<Course> iterator = data.iterator();

        StringBuilder builder = new StringBuilder();

        while (iterator.hasNext()){
            Course course = iterator.next();
            builder.append(course.getTitle()).append("\n");

        }
        TextView textView =(TextView) findViewById(R.id.tvCourseList);
        textView.setText(builder.toString());*/
    }

    private void detailCourse(Course course) {
        Intent intent = new Intent(this , DetailActivity.class);
        intent.putExtra(COURSE_TITLE , course.getTitle());
        intent.putExtra(COURSE_Desc , course.getDescription());
        intent.putExtra(COURSE_Num , course.getCourseNumber());
        intent.putExtra(COURSE_Credit , course.getCredits());
        startActivityForResult(intent , DETAIL_REQUEST_CODE);

    }
    class CourseArrayAdapter extends ArrayAdapter<Course>{
        private Context context;
        private List<Course> objects;

        public CourseArrayAdapter(Context context, int resource, List<Course> objects) {
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;

        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Course course = objects.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.custimize_item , null);
            TextView tv = (TextView) view.findViewById(R.id.tvTitle);
            tv.setText(course.getTitle());

            ImageView iv = (ImageView) view.findViewById(R.id.imageCourse);
            int res = context.getResources().getIdentifier("image_" + course.getCourseNumber() ,"drawable" ,
                    context.getPackageName());
            iv.setImageResource(res);

            return view;
        }
    }

}
