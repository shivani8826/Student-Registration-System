package ResponseEntity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseListResponse {

    List<Integer> courseId;
   // String courseName;
   @JsonFormat(pattern = "mm-dd-yyyy")
    Date dateOfRegistration;


    public CourseListResponse(List<Integer> courseId,  Date dateOfRegistration) {
        this.courseId = courseId;
      //  this.courseName = courseName;
        this.dateOfRegistration = dateOfRegistration;
    }

    public CourseListResponse()
    {

    }

    public List<Integer> getCourseId() {
        return courseId;
    }

    public void setCourseId(List<Integer> courseId) {
        this.courseId = courseId;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}
