package com.fastcampus.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post {
	@Id // 식별자 변수(== Primary Key) 선언
	// 1부터 시작하여 자동으로 1씩 값이 증가하도록 설정한다. 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 회원 일련번호
	
	@Column(nullable = false, length = 100)
	private String title;
	
	// MB단위의 아주 긴 문자데이터를 저장할수있는 어노테이션
	@Lob
	@Column(nullable = false)
	private String content;
	
	@CreationTimestamp // 현재 시간 정보가 자동으로 설정된다.
	private Timestamp createDate;
	
	// OneToMany Lazy 가 default
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID") // FK
	private User user;
    
    @OneToMany(fetch = FetchType.EAGER ,mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Reply> replyList = new ArrayList<>();

}








