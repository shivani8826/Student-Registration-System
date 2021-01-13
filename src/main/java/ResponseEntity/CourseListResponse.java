package ResponseEntity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseListResponse {

    Integer courseId;
   // String courseName;
   @JsonFormat(pattern = "mm-dd-yyyy")
    Date dateOfRegistration;


    public CourseListResponse(Integer courseId,  Date dateOfRegistration) {
        this.courseId = courseId;
      //  this.courseName = courseName;
        this.dateOfRegistration = dateOfRegistration;
    }

    public CourseListResponse()
    {

    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

   /* public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
*/
    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}
