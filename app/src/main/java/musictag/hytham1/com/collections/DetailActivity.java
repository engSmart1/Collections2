package musictag.hytham1.com.collections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import data.Course;
import data.DataProvider;

public class DetailActivity extends AppCompatActivity {
    protected String courseTitle;
    protected String courseDesc;
    protected int courseNum;
    protected String courseCredit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        courseTitle = getIntent().getStringExtra(MainActivity.COURSE_TITLE);
        TextView textView = (TextView) findViewById(R.id.tvDetail);
        textView.setText(courseTitle);

        courseDesc = getIntent().getStringExtra(MainActivity.COURSE_Desc);
        TextView tvDesc = (TextView) findViewById(R.id.tvDescription);
        tvDesc.setText(courseDesc);

        courseNum = getIntent().getIntExtra(MainActivity.COURSE_Num ,0);

        ImageView iv = (ImageView) findViewById(R.id.imageIcon);

        int res = getResources().getIdentifier("image_" + courseNum , "drawable" , getPackageName());

        iv.setImageResource(res);
    }


}



