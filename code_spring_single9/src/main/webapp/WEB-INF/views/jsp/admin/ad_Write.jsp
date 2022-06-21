<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>ad_Write</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.js"></script>
<script>

	function postBoard() {
		
		if($("#category").val()) {
			var category = $("#category").val();
		} else {
			alert("카테고리를 입력해주세요!");
			 $('.category').focus();
			return;
		}
		
		if($("#title").val()) {
			var title = $("#title").val();
		} else {
			alert("제목을 입력해주세요!");
			 $('.title').focus();
			return;
		}
		
		if($("#contents").val()) {
			var contents = $("#contents").val();
		} else {
			alert("내용을 입력해주세요!");
			$('.contents').focus();
			return;
		}
		
		if($("#price").val()) {
			var price = $("#price").val();
		} else {
			alert("가격을 입력해주세요!");
			return;
		}
		
		var formData = new FormData(document.getElementById("product_register_form"));
		
		$.ajax({
			type : "POST",
			url : "/admin/ad_Write",
			enctype : "multipart/form-data",
			processData : false,
			contentType : false,
			data : formData,
			success : function() {
				alert("게시글이 등록되었습니다.");
				location.href="operator_main_paging_search";
			},
			error : function(err) {
				alert("ERROR : " + err);
			}
		});
	
	}
    
</script>

</head>
<body>
	<form:form commandName="productDto" mehtod="post" id="product_register_form">
		<table border="1">
			<tr>
				<th><form:label path="category">카테고리</form:label></th>
				<td>
					<form:input path="category" class="category" placeholder="카테고리를 입력하세요." />
					<form:errors path="category" />
				</td>
			</tr>
			<tr>
				<th><form:label path="title">제목</form:label></th>
				<td>
					<form:input path="title" class="title" placeholder="제목을 입력하세요." />
					<form:errors path="title" />
				</td>
			</tr>
			<tr>
				<th><form:label path="contents">내용</form:label></th>
				<td>
					<form:textarea path="contents" class="contents" placeholder="내용을 입력하세요." />
					<form:errors path="contents" />
				</td>
			</tr>
			<tr>
				<th><form:label path="price">가격</form:label></th>
				<td>
					<form:input path="price" class="price" placeholder="가격을 입력하세요." />
					<form:errors path="price" />
				</td>
			</tr>
			<%-- <tr>
				<th><form:label path="view_count">상품조회수</form:label></th>
				<td>
					<form:input path="view_count" />
					<form:errors path="view_count" />
				</td>
			</tr>
			<tr>
				<th><form:label path="display_yn">상품노출</form:label></th>
				<td>
					<form:input path="display_yn" />
					<form:errors path="display_yn" />
				</td>
			</tr> --%>
			<%-- <tr>
				<th><form:label path="create_date">상품입고일</form:label></th>
				<td>
					<form:input path="create_date" />
					<form:errors path="create_date" />
				</td>
			</tr> --%>
			<tr>
				<th><form:label path="writer">상품등록자</form:label></th>
				<td>
					<form:input path="writer" />
					<form:errors path="writer" />
				</td> 
			</tr>
			<tr>
				<th><form:label path="title_photo">등록용</form:label></th>
				<td>
					<form:input path="title_photo" />
					<form:errors path="title_photo" />
				</td>
			</tr>
		</table>
		<div>
			<button type="button" onclick="postBoard()">등록</button>
			<!-- <input type="submit" value="등록"> -->
			<button><a href="<c:url value="/admin/operator_main_paging_search" />">목록</a></button>
		</div>
	</form:form>
	


</body>
</html>