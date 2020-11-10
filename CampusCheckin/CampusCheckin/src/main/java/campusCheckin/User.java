package campusCheckin;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class User {

    private @Id @GeneratedValue Long id;
    private String name;
    private String studentID;
    private String email;
    private String password; //this needs to change in future with protection

    User() {
    }

    User(String name, String studentID, String email, String password) {

        this.name = name;
        this.studentID = studentID;
        this.email = email;
        this.password = password;
    }

    
    public String getName() {
   	 	return this.name;
    }
    public void setName(String name) {
    	 this.name = name;
    }

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentID() {
        return this.studentID;
    }
    
    public void setStudentID(String StudentID) {
        this.studentID = StudentID;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return Objects.equals(this.id, user.id) && Objects.equals(this.name, user.name) && Objects.equals(this.studentID, user.studentID)
                && Objects.equals(this.email, user.email)  && Objects.equals(this.password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.studentID, this.email, this.password);
    }
    
    //Not gonna output password
    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.name + '\'' + ", studentID='" + this.studentID + '\'' + ", email='" + this.email + '\'' + '}';
    }
}
