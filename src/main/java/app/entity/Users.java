package app.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "users",schema = "Amcef")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @NotNull
    @Column(name = "USER_ID")
    private int userId;

    @NotBlank(message = "Title is Required")
    @Column(name = "TITLE")
    private String title;

    @NotBlank(message = "Body is Required")
    @Column(name = "BODY")
    private String body;

}
