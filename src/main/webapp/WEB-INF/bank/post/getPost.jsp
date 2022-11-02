<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container-fluid mt-3">
	<div class="card">
		<div class="card-body">
			<h1 class="card-title">${post.title }</h1>
			<br>
			<h2>${post.content }</h2>
			<div>
				포스트 번호 : <span id="id"><i>${post.id }</i></span> <br> 
				작성자 : <span id="username"><i>${post.user.username }</i></span>
			</div>
			<br>
			<hr>
			<button type="button" class="btn btn-secondary" onclick="history.back()">돌아가기</button>
			<c:if test="${post.user.username == principal.username }">
				<a href="/post/updatePost/${post.id }" class="btn btn-warning">수정하기</a>
				<button type="button" class="btn btn-danger" onclick="deletePost(${post.id})">삭제하기</button>
			</c:if>
		
			<table class="table table-hover">
			    <thead>
			      <tr>
			        <th class="col-sm-10">내용</th>
			        <th class="col-sm-1">작성자</th>
				    <th class="col-sm-1">삭제</th>
			      </tr>
			    </thead>
			    <tbody>
 		    		<c:if test="${!empty replyList }">
						<c:forEach var="reply" items="${replyList }">
						<tr>
							<td>${reply.comment }</td>
							<td>${reply.user.username }</td>
							<c:if test="${reply.user.username == principal.username }">
								<td>
								<button type="button" class="btn btn-light" onclick="deleteReply(${reply.id})">삭제</button>
								</td>
							</c:if>
							<c:if test="${reply.user.username != principal.username }">
								<td><button type="button" class="btn btn-light" disabled>삭제</button></td>
							</c:if>
						</tr>
						</c:forEach>
					</c:if>
			    </tbody>
<%-- 			    <ul class="pagination justify-content-end">
				  <li class="page-item <c:if test="${replyList.first }">disabled</c:if> "><a class="page-link" href="?page=${replyList.number - 1 }">이전 페이지</a></li>
				  <li class="page-item <c:if test="${replyList.last }">disabled</c:if>"><a class="page-link" href="?page=${replyList.number + 1 }">다음 페이지</a></li>
				</ul> --%>
		  	</table>
		  	<br>
		  	  <form>
			    <div class="mb-3 mt-3">
			      <textarea class="form-control" rows="1" id="comment" name="text"></textarea>
			    </div>
			    <button type="button" class="btn btn-primary" onclick="insertReply(${post.id})">덧글등록</button>
			  </form>
	  		
	  	</div>
  	</div>
</div>

<script src="/js/post.js"></script>
<script>
function deletePost(id){

	// Ajax를 이용한 비동기 호출
	$.ajax({
		type: "POST", // 요청 방식
		url: "/post/deletePost/" + id, // 요청 path
	}).done(function() {
		// 메인 페이지로 이동한다.
		location = "/";
	});
}
</script>
<script>
function insertReply(id){
	alert("댓글 등록 요청됨");

	let reply = {
		comment : $("#comment").val()
	}	
	// Ajax를 이용한 비동기 호출
	$.ajax({
		type: "POST", // 요청 방식
		url: "/post/insertReply/" + id, // 요청 path
		data: JSON.stringify(reply), // reply Object를 JSON으로 변환
		// HTTP 바디에 설정되는 데이터의 마임타입설정 
		contentType: "application/json; charset=utf-8"
		// done() : 요청 처리에 성공했을 때 실행될 코드를 작성한다.
		// 응답으로 들어온 JSON 데이터를 response로 받는다. 
	}).done(function(response) {
		alert(response);
		location.reload(); // 현재 새로고침
	});
}
</script>
<script>
function deleteReply(id){
	alert("댓글 삭제 요청됨");
	// Ajax를 이용한 비동기 호출
	$.ajax({
		type: "DELETE", // 요청 방식
		url: "/post/deleteReply/" + id, // 요청 path
	}).done(function(response) {
		alert(response);
		location.reload(); // 현재 새로고침
	});
}
</script>


<%@ include file="../layout/footer.jsp"%>
