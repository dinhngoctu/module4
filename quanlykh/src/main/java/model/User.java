package model;

import javax.persistence.*;

@Entity(name = "User")
@Table(name = "user")
public class User implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userName;
}
