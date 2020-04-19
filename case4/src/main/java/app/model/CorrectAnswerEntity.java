package app.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "correct_answer", schema = "datacase4", catalog = "")
public class CorrectAnswerEntity {
    private long id;
    private long quizId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quizId")
    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorrectAnswerEntity that = (CorrectAnswerEntity) o;
        return id == that.id &&
                quizId == that.quizId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quizId);
    }
}
