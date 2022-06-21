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
	<h3>admin paging search</h3>
	<div class='row'>
		<div class='col-sm-10'></div>
		<div class='col-sm-2'>
			<button type='button' class='btn btn-outline-secondary' id='writeQna'><a href="../admin/ad_Write">등록하기</a></button>
		</div>
	</div>
	<div class='row' style='height:30px'></div>
	<div>
  		<form name="searchForm" action="<c:url value="/admin/operator_main_paging_search" />" method="GET" >
  			<select name="searchType">
  				<%-- <option value="all" <c:out value="${searchType =='all'? 'selected':'' }"/>>카테고리+제목+내용</option> --%>
  				<option value="category" <c:out value="${searchType =='category'? 'selected':'' }"/>>카테고리</option>
  				<option value="title" <c:out value="${searchType =='title'? 'selected':'' }"/>>제목</option>
  				<option value="contents" <c:out value="${searchType =='contents'? 'selected':'' }"/>>내용</option>
  			</select>
  			<input type="text" name="keyword" value="${keyword}" placeholder="검색">
  			<input id="submit" type="submit" value="검색">
  		</form>
  	</div>
  	<br>
  	<b>${count}</b>개의 게시물이 있습니다.
  	<br><br>
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
					<c:when test="${empty searchList}">
						<tr>
							<td colspan="5" align="center">데이터가 없습니다.</td>
						</tr>
					</c:when>
					<c:when test="${!empty searchList}">
						<c:forEach var="list" items="${searchList}" varStatus="loop">
							<tr>
							<%-- 	<td>${loop.count}</td> --%>
								<td><c:out value="${list.seq}" /></td>
								<td><c:out value="${list.category}" /></td>
								<td><a href="<c:url value="/admin/detail/${list.seq}${pageMaker.makeSearch(pageMaker.cri.page)}" />"><c:out value="${list.title}" /></a></td>
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
		<table>
		<tr>
		    <c:if test="${pageMaker.prev}">
		    <td>
		        <a href='<c:url value="operator_main_paging_search?${pageMaker.makeSearch(pageMaker.startPage-1)}"/>'>&laquo;</a>
		    </td>
		    </c:if>
		    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
		    <td>
		        <a href='<c:url value="operator_main_paging_search${pageMaker.makeSearch(idx)}"/>'>${idx}</a>
		    </td>
		    </c:forEach>
		    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		    <td>
		        <a href='<c:url value="operator_main_paging_search${pageMaker.makeSearch(pageMaker.endPage+1)}"/>'>&raquo;</a>
		    </td>
		    </c:if>
		</tr>
	</table>
	</div>
</div>
<%@ include file="/WEB-INF/views/jsp/main/footer.jsp" %>