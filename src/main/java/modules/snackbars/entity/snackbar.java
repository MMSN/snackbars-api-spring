package modules.snackbars.entity;

import javax.persistence.*;

@Entity
@Table(name = "snackbar")
public class snackbar {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "snackbar_name")
    public String snackbar_name;
}
