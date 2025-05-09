package com.rubypaper.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder @AllArgsConstructor @NoArgsConstructor
public class BoardVO {
	private int seq;
	private String title;
	private String writer;

}
