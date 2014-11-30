package whiteship.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Keeun Baik
 */
@Data
@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    private Date joined;

}
