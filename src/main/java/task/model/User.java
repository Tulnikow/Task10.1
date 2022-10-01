package task.model;
import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_LASTNAME")
    private String userLastName;

    @Column(name = "USER_MAIL")
    private String userMail;

    @Column(name = "USER_AGE")
    private int userAge;

    public User() {
    }

    public User(int id, String userName, String userLastName, String userMail, int userAge) {
        this.id = id;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userMail = userMail;
        this.userAge = userAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastname() {
        return userLastName;
    }

    public void setUserLastname(String userLastname) {
        this.userLastName = userLastname;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userLastname='" + userLastName + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}

