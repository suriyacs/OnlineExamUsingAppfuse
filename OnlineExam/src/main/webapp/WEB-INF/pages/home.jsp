<%@ include file="/common/taglibs.jsp"%>
<%@ page import="org.appfuse.Constants" %>
<head>
    <title><fmt:message key="home.title"/></title>
    <meta name="menu" content="Home"/>
    <link rel="icon" href="img/c-finger-pointing.png">
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
 <div class="logout" style="float: right">
            <a href="logout" class="btn btn-danger" title="logout"><span
                class="glyphicon glyphicon-log-out"></span></a>
 </div>
 <div class="header">
    <h1 class="title">Tech Assess</h1>
 </div>
<ul class="glassList">
    <li>
        <a href="<c:url value='/userform'/>"><fmt:message key="menu.user"/></a>
    </li>
    <li>
        <a href="<c:url value='/fileupload'/>"><fmt:message key="menu.selectFile"/></a>
    </li>
</ul>
 <li> <a href="${cookie['username'].value}"/><fmt:message key="menu.selectFile"/></a> </li>
<% if (request.isUserInRole(Constants.ADMIN_ROLE)) {%>
 <div class="container">
            <div class="row">
                <a href="insertadmin" class="firstcolumn">
                    <div class="col-xs-2 row-height">
                        <h3>Add Admin</h3>
                    </div>
                </a>
                <div class="col-xs-1"></div>
                <a href="insertquestion" class="firstcolumn">
                    <div class="col-xs-2 middle">
                        <h3>Add Question</h3>
                    </div>
                </a>
                <div class="col-xs-1"></div>
                <a href="insertexamdetails" class="firstcolumn">
                    <div class="col-xs-2 row-height">
                        <h3>Add NewTest</h3>
                    </div>
                </a>
                <div class="col-xs-1"></div>
                <a href="allocatequestionpage" class="firstcolumn">
                    <div class="col-xs-3 row-height">
                        <h3>Assign Questions</h3>
                    </div>
                </a>
            </div>
</div>
<% } %>
</body>
