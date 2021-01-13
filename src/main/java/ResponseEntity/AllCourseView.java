package ResponseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AllCourseView implements Serializable {

    List<String> courses;
    Integer id;
    String password;

    public AllCourseView(List<String> courses, Integer id) {
        this.courses = courses;
        this.id = id;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AllCourseView()
    {

    }



}
