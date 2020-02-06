<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Connexion</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/magnific-popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/themify-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nice-select.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/gijgo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/slick.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/slicknav.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    
</head>

<body>

    <!-- header-start -->
    <header>
        <div class="header-area ">
		            <div id="sticky-header" class="main-header-area">
		                <div class="container-fluid ">
		                    <div class="header_bottom_border">
		                        <div class="row align-items-center">
		                            <div class="col-xl-3 col-lg-2">
		                                <div class="logo">
		                                    
		                                </div>
		                            </div>
		                            <div class="col-xl-6 col-lg-7">
		                                <div class="main-menu  d-none d-lg-block">
		                                    <nav>
		                                        <ul id="navigation">
		                                        </ul>
		                                    </nav>
		                                </div>
		                            </div>
		                            <div class="col-xl-3 col-lg-3 d-none d-lg-block">
		                                <div class="Appointment">
		                                    <div class="d-none d-lg-block">
		                                    	<p></p>
		                                        <a class="boxed-btn4" href="logout.jsp">D�connexion</a>
		                                    </div>
		                                </div>
		                            </div>
		                            <div class="col-12">
		                                <div class="mobile_menu d-block d-lg-none"></div>
		                            </div>
		                        </div>
		                    </div>
		
		                </div>
		            </div>
		        </div>
    </header>
    <!-- header-end -->

      <!-- bradcam_area  -->
      <div class="bradcam_area bradcam_bg_3">
        <div class="container">
            <div class="row">
                <div class="col-lg-10">
                    <div class="bradcam_text">
                        <h3>Espace Administrateur</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/ bradcam_area  -->
    
    <!-- apply_form_area -->
    <div class="apply_form_area">
    	<div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6" align="center">
                	<form class="apply_form" >
                    <button type="button" class="btn btn-outline-success" onclick="window.location.href='EditUser';">G�rer les utilisateurs</button>
                    <p><br></p>
                    <button type="button" class="btn btn-outline-success" onclick="window.location.href='AjoutQuestionnaire';">Ajouter un questionnaire</button>
                    </form>
                </div>
            </div>
            </div>
    </div>
    <!--/ apply_form_area -->


    <!-- footer start -->
    <footer class="footer">
        <div class="copy-right_text wow fadeInUp" data-wow-duration="1.4s" data-wow-delay=".3s">
            <div class="container">
                <div class="footer_border"></div>
                <div class="row">
                    <div class="col-xl-12">
                        <p class="copy_right text-center">
							Copyright &copy;
							<script>document.write(new Date().getFullYear());</script> 
							All rights reserved
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--/ footer end  -->

    <!-- link that opens popup -->
    <!-- JS here -->
    <script src="${pageContext.request.contextPath}/js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/isotope.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ajax-form.js"></script>
    <script src="${pageContext.request.contextPath}/js/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.counterup.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/imagesloaded.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/scrollIt.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.scrollUp.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.slicknav.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/js/gijgo.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/slick.min.js"></script>



    <script src="${pageContext.request.contextPath}/js/contact.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ajaxchimp.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/mail-script.js"></script>


    <script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>

</html>