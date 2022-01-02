package com.example.Taskin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Question {


	@Id
	@SequenceGenerator(
			name = "question_sequence",
			sequenceName = "question_sequence",
			allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_sequence")
	@Column(name = "question_id")
	private Integer questionID;

	@Column(name = "question_title", nullable = false, length = 200)
	private String questionTitle;

	@Column(name = "question_description", nullable = false, length = 3000)
	private String questionDescription;

	@Column(name = "question_asked_date")
	private Date questionAskedDate;

	@Column(name = "question_answer_count")
	private Integer questionAnswerCount = 0;

	@Column(name = "question_view_count")
	private Integer questionViewCount = 1;

	@Column(name = "question_vote_count")
	private Integer questionVoteCount = 0;

	@ManyToOne(cascade = CascadeType.ALL)
	private Users user;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Comment> questionComments;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Answer> questionAnswer;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "question_tag_map",
			joinColumns = @JoinColumn(
					name = "question_id",
					referencedColumnName = "question_id"
			),
			inverseJoinColumns = @JoinColumn(
					name = "question_tag_id",
					referencedColumnName = "question_tag_id"
			)
	)
	private List<QuestionTag> questionTags;


	public Question(String questionTitle, String questionDescription, Users user, Date questionAskedDate, List<QuestionTag> questionTags) {
		this.questionTitle = questionTitle;
		this.questionDescription = questionDescription;
		this.questionAskedDate = questionAskedDate;
		this.questionTags = questionTags;
		this.user = user;

		this.questionAnswerCount = 0;
		this.questionViewCount = 1;
		this.questionVoteCount = 0;

	}

	public Question() {
	}

	public Integer getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public Date getQuestionAskedDate() {
		return questionAskedDate;
	}

	public void setQuestionAskedDate(Date questionAskedDate) {
		this.questionAskedDate = questionAskedDate;
	}

	public Integer getQuestionAnswerCount() {
		return questionAnswerCount;
	}

	public void setQuestionAnswerCount(Integer questionAnswerCount) {
		this.questionAnswerCount = questionAnswerCount;
	}

	public Integer getQuestionViewCount() {
		return questionViewCount;
	}

	public void setQuestionViewCount(Integer questionViewCount) {
		this.questionViewCount = questionViewCount;
	}

	public Integer getQuestionVoteCount() {
		return questionVoteCount;
	}

	public void setQuestionVoteCount(Integer questionVoteCount) {
		this.questionVoteCount = questionVoteCount;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Comment> getQuestionComments() {
		return questionComments;
	}

	public void setQuestionComments(List<Comment> questionComments) {
		this.questionComments = questionComments;
	}

	public List<Answer> getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(List<Answer> questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public List<QuestionTag> getQuestionTags() {
		return questionTags;
	}

	public void setQuestionTags(List<QuestionTag> questionTags) {
		this.questionTags = questionTags;
	}

	@Override
	public String toString() {
		return "Question{" +
				"questionID=" + questionID +
				", questionTitle='" + questionTitle + '\'' +
				", questionDescription='" + questionDescription + '\'' +
				", questionAskedDate=" + questionAskedDate +
				", questionAnswerCount=" + questionAnswerCount +
				", questionViewCount=" + questionViewCount +
				", questionVoteCount=" + questionVoteCount +
				", user=" + user +
				", questionComments=" + questionComments +
				", questionAnswer=" + questionAnswer +
				", questionTags=" + questionTags +
				'}';
	}

}
