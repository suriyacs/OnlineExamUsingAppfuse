<%@ include file="/common/taglibs.jsp" %>

<head>
    <title><fmt:message key="login.title"/></title>
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
<body id="login">
<div id="grid"></div>
 <div class="content">
        <div>
            <div>
                <h1 class="title">Tech Assess</h1>
            </div>
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
        </div>
<form method="post" id="loginForm" action="<c:url value='/j_security_check'/>"
    onsubmit="saveUsername(this);return validateForm(this)" class="form-signin" autocomplete="off">
    <h2 class="form-signin-heading">
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
        <fmt:message key="login.rememberMe"/></label>
</c:if>

    <button type="submit" class="btn btn-lg btn-success" name="login" tabindex="4">
        <fmt:message key='button.login'/>
    </button>
    <button type="reset" class="btn btn-lg btn-warning">Reset</button>
</form>

<p>
    <fmt:message key="login.signup">
        <fmt:param><c:url value="/signup"/></fmt:param>
    </fmt:message>
</p>

<c:set var="scripts" scope="request">
<%@ include file="/scripts/login.js"%>
</c:set>

<p><fmt:message key="login.passwordHint"/></p>

<p><fmt:message key="updatePassword.requestRecoveryTokenLink"/></p>
</div>
</body>
