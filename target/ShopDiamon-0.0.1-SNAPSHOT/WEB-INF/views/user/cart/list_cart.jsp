<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	 <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" 
   prefix="decorator"%> 
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>  

<head>
<title>List cart</title>
</head>
<body>
	<div class="row">
		<div class="span12">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a> <span class="divider">/</span></li>
				<li class="active">Check Out</li>
			</ul>
			<div class="well well-small">
				<h1>
					Giỏ hàng<small class="pull-right">  ${TotalQuantyCart } sản phẩm trong giỏ hàng </small>
				</h1>
				<hr class="soften" />

				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
							<th>Hình ảnh</th>
							<th>Mô tả</th>
							<th>Màu sắc</th>							
							<th>Giá bán</th>
							<th>Số lượng</th>
							<th>Chỉnh sửa </th>
			                  <th>Xóa </th>
			                  <th>Tổng tiền</th>
							
						</tr>
					</thead>
					<tbody>
				
            			<c:forEach var="item" items="${ Cart }">
			 			<tr>
							<td><img width="100" src="<c:url value="/assets/user/img/${ item.value.productDto.img }"/>" alt=""></td>
							<td>${item.value.productDto.title}</td>														
							<td><span class="shopBtn" style="background-color: ${item.value.productDto.code_color};"> 
							<span class="icon-ok"></span></span>
							</td>
							<td> <fmt:formatNumber type="number" groupingUsed="true" value="${item.value.productDto.price} " /> ₫</td>
							<td>
								<input type="number" min="0" max="1000" class="span1" style="max-width: 34px"
								placeholder="1" id="quanty-cart-${item.key }" size="16" type="text"
								value="${item.value.quanty }">
								</td>
								<td>
	                  	<button  data-id="${item.key }" class="btn btn-mini btn-danger edit-cart" type="button" >
	                  		<span class="icon-edit"></span>
	                  	</button>
	                  </td>
	                  <td>
	                  	<a href="<c:url value="/DeleteCart/${item.key }"/>" class="btn btn-mini btn-danger" type="button">
	                  		<span class="icon-remove"></span>
	                  	</a>
	                  </td>
							<td> <fmt:formatNumber type="number" groupingUsed="true" value="${item.value.totalPrice }" /> ₫</td>
						</tr>			
						</c:forEach>
            	
					
														
					</tbody>
				</table>
				<br />
			
				
				<a href="products.html" class="shopBtn btn-large"><span
					class="icon-arrow-left"></span> Tiếp tục mua sản phẩm </a> <a
					href="login.html" class="shopBtn btn-large pull-right">Thanh toán <span
					class="icon-arrow-right"></span></a>

			</div>
		</div>
	</div>
	<content tag="script">
		<script >			
				$(".edit-cart").on("click", function(){
				/* 	alert($(this).data("id")); */
				// lay id cua sp theo  data-id
					var id= $(this).data("id");
					var quanty = $("#quanty-cart-" + id).val();
					window.location = "EditCart/" + id + "/"+ quanty;
					alert(quanty);
				})			
	</script>
	</content>
	
	
</body>
