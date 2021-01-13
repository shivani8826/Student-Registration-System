package ResponseEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class EachStudentCourseCred {

    // localDate dateOfReg;
    Integer studentId;
    Integer[] courseId;

    @JsonFormat(pattern = "mm-dd-yyyy")
    Date dateOfRegistration;
    Integer validityInDays;


    public EachStudentCourseCred(Integer studentId, Integer validityInDays, Integer[] courseId, Date dateOfRegistration) {
        this.studentId = studentId;
        this.validityInDays = validityInDays;
        this.courseId=courseId;
        this.dateOfRegistration=dateOfRegistration;
    }

    public EachStudentCourseCred()
    {

    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getValidityInDays() {
        return validityInDays;
    }

    public void setValidityInDays(Integer validityInDays) {
        this.validityInDays = validityInDays;
    }

    public Integer[] getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer[] courseId) {
        this.courseId = courseId;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration=dateOfRegistration;
    }
}
