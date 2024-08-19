package com.walk.post.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Post {

	private int id;
	private int userId;
	private String subject;
	private String place;
	private String distance;
	private String time;
	private String date;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}