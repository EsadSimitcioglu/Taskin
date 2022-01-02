package com.example.Taskin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {

	@Id
	@SequenceGenerator(
			name = "user_sequence",
			sequenceName = "user_sequence",
			allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@Column(name = "user_id", nullable = false)
	private Integer userID;

	@Column(name = "user_name", nullable = false, length = 30)
	private String userName;

	@Column(name = "user_password", nullable = false, length = 50)
	private String userPassword;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Question> questionList;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Comment> commentList;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Answer> answerList;

	public Users(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public Users() {

	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	@Override
	public String toString() {
		return "Users{" +
				"userID=" + userID +
				", userName='" + userName + '\'' +
				", userPassword='" + userPassword + '\'' +
				", questionList=" + questionList +
				", commentList=" + commentList +
				", answerList=" + answerList +
				'}';
	}
}
