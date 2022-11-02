<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
	<c:if test="${post == null }">
		<form>
			<div class="mb-3">
				<label for="title">Title:</label> 
				<input type="text" class="form-control" id="title" placeholder="Enter title">
				<div class="mb-3">
					<label for="content">Content:</label>
					<textarea class="form-control" rows="5" id="content"></textarea>
				</div>
			</div>
		</form>
		<button id="btn-insert" class="btn btn-secondary">포스트등록</button>
	</c:if>
	
	<c:if test="${post != null }">
		<form>
			<div class="mb-3">
				<label for="title">Title:</label> 
				<input type="text" class="form-control" id="title" placeholder="Enter title" value="${post.title }">
				<div class="mb-3">
					<label for="content">Content:</label>
					<textarea class="form-control" rows="5" id="content" >${post.content }</textarea>
				</div>
			</div>
		</form>
		<button type="button" class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		<button type="button" class="btn btn-warning" onclick="updatePost(${post.id})">포스트 수정</button>
	</c:if>


	<script>
		$(document).ready(function() {
			$("#content").summernote({
				height : 300
			});
		});
	</script>

</div>

<script src="/js/post.js"></script>
<script>
function updatePost(id){
	let post = {
		title : $("#title").val(),
		content : $("#content").val(),
	}		

	// Ajax를 이용한 비동기 호출
	$.ajax({
		type: "POST", // 요청 방식
		url: "/post/updatePost/" + id, // 요청 path
		data: JSON.stringify(post), // user Object를 JSON으로 변환
		// HTTP 바디에 설정되는 데이터의 마임타입설정 
		contentType: "application/json; charset=utf-8"
		// done() : 요청 처리에 성공했을 때 실행될 코드를 작성한다.
		// 응답으로 들어온 JSON 데이터를 response로 받는다. 
	}).done(function() {
		// 메인 페이지로 이동한다.
		location = "/";
	});
}
</script>
<%@ include file="../layout/footer.jsp"%>
