<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
 
<header class="header-section">
	 	<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-2 text-center text-lg-left">
						<!-- logo -->
						<a href="<c:url value='/' />" class="site-logo">
							<img src="/apparel/img/logo.png" alt="" />
						</a>
					</div>

					<div class="col-xl-4 col-lg-1">
						<form class="header-search-form">
							<input type="text" placeholder="Search on divisima ...." />
							<button><i class="flaticon-search"></i></button>
						</form>
					</div>
					<div class="col-xl-6 col-lg-5"  max-width="40%">
						<div class="user-panel">
								<div class="up-item">
									<i class="flaticon-profile"></i>
									<a href="<c:url value='/user/login' />">Sign In</a> or <a href="<c:url value='/user/register' />">Create Account</a>
								</div>

							<div class="up-item">
								<div class="shopping-card">
									<i class="flaticon-bag"></i>
<%--									<span if="${  cartAmount != null && miniCart.id != null}"><block text="${miniCart.totalQuantity}" /></span>--%>
<%--									<span > <%= request.getParameter("totalAmount")%> </span>--%>
									<span >${totalAmount.total}TL</span>
								</div>
								<a href="<c:url value='/cart/detail' />" >Shopping Cart</a>
								<div style="margin-left: 10px" class="up-item">
									<i class="flaticon-credit-card"></i>
									<a href="<c:url value='/orders'/>" />My Orders</a>
								</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		<nav class="main-navbar">
			<div class="container">
				<!-- menu -->
				<ul class="main-menu">
					<li><a href="<c:url value='/' />" >Home</a></li>
					<li><a href="<c:url value='/c/1' />">Women</a></li>
					<li><a href="<c:url value='/c/2' />">Men</a></li>
					<li><a href="<c:url value='/c/3' />">Child
						<span class="new">New</span>
					</a></li>
				</ul>
			</div>
		</nav>
	</header>
  


 
