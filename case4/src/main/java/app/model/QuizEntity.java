package app.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "quiz", schema = "datacase4", catalog = "")
public class QuizEntity {
    private long id;
    private String content;
    private String subjectName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "subjectName")
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public QuizEntity(String content,String subject) {
        this.content = content;
        this.subjectName = subject;
    }

    public QuizEntity(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizEntity that = (QuizEntity) o;
        return id == that.id &&
                Objects.equals(content, that.content) &&
                Objects.equals(subjectName, that.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, subjectName);
    }
}
