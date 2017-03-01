package data;

/**
 * Created by Hytham on 2/28/2017.
 */

public class Course {
    private int courseNumber;
    private String title;
    private String description;
    private double credits;

    public Course (int courseNumber ,String title , String description , double credits){
        this.courseNumber = courseNumber;
        this.title = title;
        this.description = description;
        this.credits = credits;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
