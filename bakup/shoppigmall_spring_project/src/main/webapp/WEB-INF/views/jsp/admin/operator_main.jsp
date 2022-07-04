<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/jsp/main/ad_header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
.h-no{
	width:150px;
}
#contentSpace{
	justify-content:center;
}
</style> 
<div class='container'>
	<h3>admin page</h3>
	<div class='row'>
		<div class='col-sm-10'></div>
		<div class='col-sm-2'>
			<button type='button' class='btn btn-outline-secondary' id='writeQna'>
			<a href="../admin/ad_Write">등록하기</a></button>
		</div>
	</div>
	<div class='row' style='height:30px'></div>
	<div class='row' style="height:500px">
		<table border="1">
		<thead>
		<tr>
			<th class='seq'>상품번호</th>
			<th class='category'>카테고리</th>
			<th class='title'>상품제목</th>
			<th class='contents'>상품상세정보</th>
			<th class='price'>상품정가</th>
			<th class='view_count'>상품조회수</th>
			<th class='display_yn'>상품노출</th>
			<th class='create_date'>상품입고일</th>
			<th class='writer'>상품등록자</th>
			<th class='photo'>상품사진</th>
			<th class='title_photo'>상품썸네일</th>
		</tr>
		</thead>
		<tbody id='contentSpace'>
		</tbody>

			<tbody>

				<c:choose>
					<c:when test="${empty plist }">
						<tr>
							<td colspan="5" align="center">데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${!empty plist}">
						<c:forEach var="list" items="${plist}">
							<tr>
								<td><c:out value="${list.seq}" /></td>
								<td><c:out value="${list.category}" /></td>
								<td><a href="<c:url value="/admin/detail/${list.seq}" />"><c:out value="${list.title}" /></a></td>
								<td><c:out value="${list.contents}" /></td>
								<td><c:out value="${list.price}" /></td>
								<td><c:out value="${list.view_count}" /></td>
								<td><c:out value="${list.display_yn}" /></td>
								<td><c:out value="${list.create_date}" /></td>
								<td><c:out value="${list.writer}" /></td>
								<td><c:out value="${list.photo}" /></td>
								<td><c:out value="${list.title_photo}" /></td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</tbody>
 
		</table>
	</div>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>