<%@ include file="/common/taglibs.jsp" %>
<head>
    <title>
        <fmt:message key="login.title"/>
    </title>
    <meta name="menu" content="Login"/>
    <link rel="icon" href="img/userimage.png">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
        integrity="sha384-   
        BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous" />
    <link rel="stylesheet" href="css/login.css">
    <link href='css/fonts.css' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/style1.css">
    <link rel="stylesheet" href="css/sweetalert2.min.css">
    <link rel="stylesheet" href="css/sweetalert2.css">
    <link rel="stylesheet"	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/imageslider.js"></script>
    <script type="text/javascript" src="js/jssor.slider-21.1.5.mini.js"></script>
    <script src="js/sweetalert2.min.js"></script>
    <script src="js/loginvalidation.js"></script>
    <script src="js/sweetalert2.js"></script>
    <script src="js/parallex.js"></script>
</head>
<body>           
            <div id="jssor_1" class="jsso">
                <div data-u="slides" class="slides">
                    <div data-p="225.00" style="display: none;">
                        <img data-u="image" src="img/red.jpg" />
                    </div>
                    <div data-p="225.00" style="display: none;">
                        <img data-u="image" src="img/purple.jpg" />
                    </div>
                    <div data-p="225.00" data-po="80% 55%" style="display: none;">
                        <img data-u="image" src="img/blue.jpg" />
                    </div>
                    <div data-p="225.00" data-po="80% 55%" style="display: none;">
                        <img data-u="image" src="img/b6.jpg" />
                    </div>
                    <div data-p="225.00" data-po="80% 55%" style="display: none;">
                        <img data-u="image" src="img/c-slide-1.jpg" />
                    </div>
                </div>
                <!-- Bullet Navigator -->
                <div data-u="navigator" class="jssorb05"
                    style="bottom: 16px; right: 16px;" data-autocenter="1">
                    <!-- bullet navigator item prototype -->
                    <div data-u="prototype" style="width: 16px; height: 16px;"></div>
                </div>
                <!-- Arrow Navigator -->
                <span data-u="arrowleft" class="jssora22l"
                    style="top: 0px; left: 12px; width: 35px; height: 58px;"
                    data-autocenter="2"></span> <span data-u="arrowright"
                    class="jssora22r"
                    style="top: 6px; right: 12px; width: 35px; height: 58px;"
                    data-autocenter="2"></span>
            </div>
        <div class="center">
            <div class="inputform" style="float: right">
                <div class="form">
                    <form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"
                        onsubmit="saveUsername(this);return validateForm(this)" class="form-signin" autocomplete="off">
                        <h2 class="form-signin-heading" style="color:white">
                            <fmt:message key="login.heading"/>
                        </h2>
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger alert-dismissable">
                                <fmt:message key="errors.password.mismatch"/>
                            </div>
                        </c:if>
                        <input type="text" name="j_username" id="j_username" class="form-control"
                            placeholder="<fmt:message key="label.username"/>" required tabindex="1"><br>
                        <input type="password" class="form-control" name="j_password" id="j_password" tabindex="2"
                            placeholder="<fmt:message key="label.password"/>" required>
                        <c:if test="${appConfig['rememberMeEnabled']}">
                            <label for="rememberMe" class="checkbox">
                                <input type="checkbox" name="_spring_security_remember_me" id="rememberMe" tabindex="3"/>
                                <fmt:message key="login.rememberMe"/>
                            </label>
                        </c:if>
                        <button type="submit" class="btn btn-lg btn-success" name="login" tabindex="4">
                            <fmt:message key='button.login'/>
                        </button>
                        <button type="reset" class="btn btn-lg btn-warning">Reset</button>
                    </form>
                    <p>
                        <fmt:message key="login.signup">
                            <fmt:param>
                                <c:url value="/signup"/>
                            </fmt:param>
                        </fmt:message>
                    </p>
                    <c:set var="scripts" scope="request">
                        <%@ include file="/scripts/login.js"%>
                    </c:set>
                    <p>
                        <fmt:message key="login.passwordHint"/>
                    </p>
                    <p>
                        <fmt:message key="updatePassword.requestRecoveryTokenLink"/>
                    </p>
                </div>
                <!-- form -->
            </div>
            <!-- input form-->
            <div class="socket" style="float: left">
                <div class="gel center-gel">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c1 r1">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c2 r1">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c3 r1">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c4 r1">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c5 r1">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c6 r1">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c7 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c8 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c9 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c10 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c11 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c12 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c13 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c14 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c15 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c16 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c17 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c18 r2">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c19 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c20 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c21 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c22 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c23 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c24 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c25 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c26 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c28 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c29 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c30 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c31 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c32 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c33 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c34 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c35 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c36 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
                <div class="gel c37 r3">
                    <div class="hex-brick h1"></div>
                    <div class="hex-brick h2"></div>
                    <div class="hex-brick h3"></div>
                </div>
            </div>
            <script src="js/index1.js"></script>
        </div>
    <!-- content -->
    <section class="footer">
        <div class="container">
            <br>
            <div class="address" style="float: left;margin:auto;">
                <i class="fa fa-map-marker" style="font-size: 48px; color: white"></i><br>
                <p>
                    <span>21 RR Towers5,TVK Industrial Estate</span> Gundy,Chennai
                </p>
            </div>
            <div style="float: left; width: 30%">
                <i class="fa fa-phone" style="font-size: 30px; color: white;"></i>
                <p>+917502169393</p>
                <p>+918807277030</p>
            </div>
            <div class="footer-right">
                <div class="footer-icons">
                    <div style="float: left; width: 10%">
                        <a href="#"><i class="fa fa-facebook"
                            style="font-size: 30px; color:white"></i></a>
                    </div>
                    <div style="float: left; width: 10%">
                        <a href="#"><i class="fa fa-twitter"
                            style="font-size: 30px; color:white"></i></a>
                    </div>
                    <div style="float: left; width: 10%">
                        <a href="#"><i class="fa fa-linkedin"
                            style="font-size: 30px; color:white"></i></a>
                    </div>
                    <div style="float: left; width: 10%">
                        <a href="#"><i class="fa fa-github"
                            style="font-size: 30px; color:white"></i></a>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="copyright">
                <p>
                    2016 TechAssess. All Rights Reserved | Design by <a href="#"
                        target="_blank">Tech Assess</a>
                </p>
            </div>
        </div>
    </section>
</body>
</html>


