<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车界面</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/BeAlert.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/cart.css">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<link href="${pageContext.request.contextPath}/css/nav-footer.css" rel="stylesheet" type="text/css">

<!-- <link rel="stylesheet" -->
<%-- 	href="${pageContext.request.contextPath}/css/bootcheck.css" /> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/function.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cart.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/BeAlert.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/velocity.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/icheck.min.js"></script>
</head>
<body>
	<%@ include file="/inc/nav.jsp"%>
	<span style="display: none;" id="sta">${status}</span>
	<div id="contain">
		<div id="head">
			<ul class="swicth-cart">
				<s:url namespace="/product" action="Product_cart" id="status1">
					<s:param name="status">1</s:param>
				</s:url>
				<s:a href="%{status1}">
					<li class="btn-swicth-cart  swicth-cart-0"
						onmouseover="changewarp('0')" style="width:"><font
						style="position: relative; color: #FF4400" id="font0">全部商品</font><font
						style="color: #FF4400" id="allitems">${allitems}</font><font
						style="position: relative; float: right;">|</font>
				</s:a>
				</li>
				<s:url namespace="/product" action="Product_cart" id="status0">
					<s:param name="status">0</s:param>
				</s:url>
				<s:a href="%{status0}">
					<li class="btn-swicth-cart swicth-cart-1"
						onmouseover="changewarp('1')"><font id="font1"
						style="color: #3C3C3C">已购买商品</font><font style="color: #FF4400" id="soldfont">${sold}</font>
				</s:a>
				</li>
			</ul>
			<div class="wrap-line">
				<div class="floater" style="width: 167px; left: -1px;" id="floater"></div>
			</div>
		</div>
		<div id="main">
			<div id="selectmenu"></div>
			<div id="table"">
				<table
			class="table  table-bordered table-condensed table-hover" style="background-color:rgba(250, 250, 250, 0.79) " id="tb">
					<thead>
						<tr>
							<th>商品名字</th>
							<th style="text-align: center">商品信息</th>
							<th>产品类型<s:property value="oId" /></th>
							<th>单价<s:property value="cId" /></th>
							<th>数量</th>
							<th>总价</th>
							<s:if test="#request.status=='0'.toString()">
							</s:if>
							<s:else>
								<th>操作</th>
							</s:else>
						</tr>
					</thead>
					<tbody id="tbody">

						<s:iterator value="#request.cart_list"> 
							<tr id="<s:property value="oid"/>tr">
								<!-- 商品名称 -->
								<td style="margin: auto "><s:if test="#request.status=='0'.toString()">
									</s:if> <s:else>
										<span style="display: inline-block;">
	   										<input type="checkbox" class="select checkbox"  style="display: inline-block; width:20px;float:left;"
											name="checkboxs" id="<s:property value="oid"/>" onclick="ChangeSum('<s:property value="oid" />')">		
																			
										</span>
									</s:else> <span style="display:inline-block;"><s:property value="cname" /></span></td>
								<!-- 商品信息 -->
								<td><span><img
										src="../img/<s:property value="Pic"/>" width="80px"
										height="80px"></span> <span><s:property value="Info" /></span>
									<br>&nbsp&nbsp&nbsp&nbsp <a style="color: red"> <span
										class="glyphicon glyphicon-home">商家:<s:property
												value="Merchant" /></span></a></td>
								<!-- 商品价格 -->
								<td><span><s:property value="classify" /> </span></td>
								<td><span><s:property value="cost" /></span></td>
								<!-- 加减商品个数 -->
								<s:if test="#request.status=='0'.toString()">
									<td><s:property value="num" /></td>
								</s:if>
								<s:else>
									<td><a
										onclick="reduce('<s:property value="oid"/>','<s:property value="cost"/>')">
											<span>-</span>
									</a> <span> <input id="<s:property value="oid"/>num"
											type="text" value="<s:property value="num"/>"
											style="width: 20px;"
											onblur="changenum('<s:property value='Oid'/>','<s:property value="cost" />')" />
									</span> <a
										onclick="add('<s:property value="oid"/>','<s:property value="cost"/>')">
											<span>+</span>
									</a></td>
								</s:else>
								<!-- 商品总金额 -->
								<td>￥<span id="<s:property value="oid"/>sp"><s:property
											value="SumPrice" /></span></td>
								<!-- 删除商品 -->
								<s:if test="#request.status=='0'.toString()">
								</s:if>
								<s:else>
									<td>
										<li id="<s:property value="oid"/>dl"
										onclick="deleteitem('<s:property value="oid"/>')"
										class="btn btn-danger btn-sm"><span
											class="glyphicon glyphicon-trash"></span> 删除</li>
									</td>
								</s:else>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
			<li
				style="position: relative; margin: 0px auto; width: 200px; list-style-type: none;">
				<a onclick="checkmore()" style="color: #666666">点击查看更多内容</a>
			</li>		
						
		</div>
	</div>
	<span id="flag" style="display: none;">${flag}</span>
	<s:if test="#request.status=='0'.toString()">
	</s:if>
	<s:else>
		<div id="float-bar-wrapper">
			<!-- 选择全部商品 -->
			<div id="select-all">
				<input type="button" class="btn btn-warning btn-lg "
					onclick="selectall()" value="全选" id="controlcheck">
			</div>
			<!-- 删除选择的商品 -->
			<div id="operation">
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<li class="btn btn-danger btn-lg " onclick="deleteall()">一键删除</li>
			</div>
			<!-- 对选择的商品操作 -->
			<div id="float-right">
				<span class="barspan">已选商品<font style="color: red" id="pfont">0</font>件
				</span>&nbsp&nbsp

				<spanclass="barspan">合计（不含运费）：<font id="sumfont"
					style="color: red;">0</font> <!-- 				//总金额 --> </span>&nbsp&nbsp
				<li class="btn btn-warning btn-lg" onclick="payall()">结算</li>
			</div>
	</s:else>
	</div>
	</div>
</body>

</html>