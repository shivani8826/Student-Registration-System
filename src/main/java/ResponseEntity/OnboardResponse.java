package ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import net.minidev.json.JSONObject;
import org.codehaus.jackson.map.util.JSONPObject;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class   OnboardResponse implements Serializable {

    private Integer id;
    private Object message;

    public OnboardResponse(Integer id, Object message) {
        this.message = message;
        this.id = id;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public static OnboardResponse buildResp(Integer id, Object message) {
        return new OnboardResponse(id, message);
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
