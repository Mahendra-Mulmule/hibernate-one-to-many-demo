package code;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import student_Certificate.Certificate;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long StudentId;

    @Column(name = "student_name")
    private String Stud_name;

    @Column(name = "student_college")
    private String college;

    @Column(name = "student_phone")
    private String phone;

    @Column(name = "Student_fathername")
    private String Fathername;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Certificate> certificate = new ArrayList<>();


    // Getters and Setters
    public long getStudentId() { return StudentId; }
    public void setStudentId(long studentId) { StudentId = studentId; }

    public String getStud_name() { return Stud_name; }
    public void setStud_name(String stud_name) { Stud_name = stud_name; }

    public String getCollege() { return college; }
    public void setCollege(String college) { this.college = college; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getFathername() { return Fathername; }
    public void setFathername(String fathername) { Fathername = fathername; }

    public List<Certificate> getCertificate() { return certificate; }
    public void setCertificate(List<Certificate> certificate) { this.certificate = certificate; }

    @Override
    public String toString() {
        return "Student [ID=" + StudentId + ", Name=" + Stud_name + ", College=" + college +
               ", Phone=" + phone + ", Father's Name=" + Fathername + ", Certificates=" + certificate + "]";
    }
}
