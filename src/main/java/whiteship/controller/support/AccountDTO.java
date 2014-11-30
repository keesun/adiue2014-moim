package whiteship.controller.support;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Keeun Baik
 */
@Data
public class AccountDTO {

    @NotEmpty
    @Size(min = 5)
    protected String username;

    @NotEmpty
    protected String email;

    @Data
    public static class RequestToCreate extends AccountDTO {

        private String password;

    }

    @Data
    public static class Response extends AccountDTO {

        private Long id;

        private Date joined;
    }

}
