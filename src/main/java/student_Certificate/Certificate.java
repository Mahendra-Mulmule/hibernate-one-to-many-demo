package student_Certificate;

import jakarta.persistence.*;
import code.Student;

@Entity
@Table(name = "Student_certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long certificate_id;

    private String title;
    private String about;
    private String Link;

    @ManyToOne
    private Student student;

    // Getters & Setters
    public long getCertificate_id() { return certificate_id; }
    public void setCertificate_id(long certificate_id) { this.certificate_id = certificate_id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAbout() { return about; }
    public void setAbout(String about) { this.about = about; }

    public String getLink() { return Link; }
    public void setLink(String link) { Link = link; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    @Override
    public String toString() {
        return "[Title=" + title + ", About=" + about + ", Link=" + Link + "]";
    }
}
