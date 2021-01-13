package ResponseEntity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.helper.dao.StudentCourseInfo;
import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewListResponse implements Serializable {


    String message;
    List<CourseListResponse> courseListResponse;


    public ViewListResponse(String message, List<CourseListResponse> courseListResponse) {
        this.message = message;
        this.courseListResponse = courseListResponse;
    }

    public ViewListResponse(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CourseListResponse> getCourseListResponse() {
        return courseListResponse;
    }

    public void setCourseListResponse(List<CourseListResponse> courseListResponse) {
        this.courseListResponse = courseListResponse;
    }
}
