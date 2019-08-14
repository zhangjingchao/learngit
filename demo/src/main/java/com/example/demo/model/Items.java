package com.example.demo.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Items {
	String id;
	String name;
	int age;
	List<String> scores;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getScores() {
		return scores;
	}
	public void setScores(List<String> scores) {
		this.scores = scores;
	}
}
