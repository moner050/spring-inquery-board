package com.fastcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastcampus.domain.Post;
import com.fastcampus.domain.Reply;
import com.fastcampus.domain.User;
import com.fastcampus.security.jpa.UserDetailsImpl;
import com.fastcampus.service.PostService;
import com.fastcampus.service.ReplyService;
import com.fastcampus.service.UserService;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	// 댓글 등록
	@PostMapping("/post/insertReply/{id}")
	public @ResponseBody String insertReply(@PathVariable int id
			, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl
			, @RequestBody Reply reply) {
		
		String username = userDetailsImpl.getUsername();
		Post post = postService.getPost(id);
		User user = userService.getUser(username);
		
		reply.setPost(post);
		reply.setUser(user);
		
		replyService.insertReply(reply);
		
		return "댓글 등록이 완료되었습니다.";
	}
	
	// 댓글 삭제
	@DeleteMapping("/post/deleteReply/{id}")
	public @ResponseBody String deleteReply(@PathVariable int id) {
		replyService.deleteReply(id);

		return "댓글 삭제가 완료되었습니다.";
	}
	
}
