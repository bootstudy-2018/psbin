package com.spring.dto;

import lombok.Data;

@Data
public class BoardDTO {

	private Long id;
	private String title;
	private String content;
	private Long hit;
	private String auth;
	private String createdAt;
	private String updatedAt;
	
}
