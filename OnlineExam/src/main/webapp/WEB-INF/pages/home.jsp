<%@ include file="/common/taglibs.jsp"%>
<%@ page import="org.appfuse.Constants" %>
<head>
    <title>
        <fmt:message key="home.title"/>
    </title>
    <meta name="menu" content="Home"/>
    <link rel="icon" href="img/c-finger-pointing.png">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
        integrity="sha384-   
        BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous" />
</head>
<body style="border:3px solid white">
    <% if (!(request.isUserInRole(Constants.ADMIN_ROLE))) {%>
    <c:redirect url="/gotouserpage"/>
    <% } %>
    <% if (request.isUserInRole(Constants.ADMIN_ROLE)) {%>
    <div class="logout">
                        <a href="logout" class="btn btn-danger" title="logout"><span
                            class="glyphicon glyphicon-log-out"></span></a>
    </div>
     <div class="wrapper">
    </div>
    <div class="container">
        <div class="row">
            <a href="userform?method=Add&from=list" class="firstcolumn">
                <div class="col-xs-2 row-height">
                    <h3>
                        <fmt:message key="home.addadmin"/>
                    </h3>
                </div>
            </a>
            <div class="col-xs-1"></div>
            <a href="insertquestion" class="firstcolumn">
                <div class="col-xs-2 middle">
                    <h3>
                        <fmt:message key="home.addquestion"/>
                    </h3>
                </div>
            </a>
            <div class="col-xs-1"></div>
            <a href="insertexamdetails" class="firstcolumn">
                <div class="col-xs-2 row-height">
                    <h3>
                        <fmt:message key="home.addexam"/>
                    </h3>
                </div>
            </a>
            <div class="col-xs-1"></div>
            <a href="allocatequestionpage" class="firstcolumn">
                <div class="col-xs-3 row-height">
                    <h3>
                        <fmt:message key="home.assignquestion"/>
                    </h3>
                </div>
            </a>
        </div>
    </div>
    <% } %>
</body>


