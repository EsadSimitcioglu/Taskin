package com.example.Taskin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionTag {

	@Id
	@SequenceGenerator(
			name = "question_tag_sequence",
			sequenceName = "question_tag_sequence",
			allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_tag_sequence")
	@Column(name = "question_tag_id", nullable = false)
	private Integer questionTagID;

	@Column(name = "question_tag_name", nullable = false, length = 30)
	private String questionTagName;

	@JsonIgnore
	@ManyToMany(mappedBy = "questionTags", cascade = CascadeType.ALL)
	private List<Question> questions;

	public QuestionTag() {
	}

	public Integer getQuestionTagID() {
		return questionTagID;
	}

	public void setQuestionTagID(Integer questionTagID) {
		this.questionTagID = questionTagID;
	}

	public String getQuestionTagName() {
		return questionTagName;
	}

	public void setQuestionTagName(String questionTagName) {
		this.questionTagName = questionTagName;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "QuestionTag{" +
				"questionTagID=" + questionTagID +
				", questionTagName='" + questionTagName + '\'' +
				", questions=" + questions +
				'}';
	}
}
