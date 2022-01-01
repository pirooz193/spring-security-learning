package com.mycompany.onlineexam.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "answer_table")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "content", nullable = false, unique = true)
    private String content;

    public Answer() {
    }

    public Answer(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id.equals(answer.id) &&
                content.equals(answer.content);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
