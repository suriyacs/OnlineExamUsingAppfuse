<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>
<html lang="en">
<head>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <met a http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="<c:url value="/images/favicon.ico"/>"/>
    <link rel="stylesheet" href="css/login.css">
    <title><decorator:title/></title>
    <t:assets type="css"/>
    <decorator:head/>
</head>
 <div class="head">
     <h1 class="title">Tech Assess</h1>
</div>
<body>
    <decorator:getProperty property="body.class" writeEntireProperty="true"/>
    <decorator:getProperty property="body.id" writeEntireProperty="true"/>
    <decorator:body/>
</body>
</html>
