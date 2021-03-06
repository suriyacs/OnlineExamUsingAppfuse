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
    <link rel="stylesheet"	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <script src="js/parallex.js"></script>
    <script src="js/jquery-1.11.3.min.js"></script>
   <script type="text/javascript">
    $(window).load(function() {
	    $(".loader").fadeOut("slow");
    })
   </script>
    <title><decorator:title/></title>
    <t:assets type="css"/>
    <decorator:head/>
</head>
<div class="heading" style="border:none">
              <h1 class="title" style="color:white;"><fmt:message key="heading.name"/></h1>
</div>
<body class="default">
    <div id="grid"></div>
     <div class="content">
       
        <decorator:getProperty property="body.class" writeEntireProperty="true"/>
        <decorator:getProperty property="body.id" writeEntireProperty="true"/>
        <div class="loader"></div>
        <decorator:body/>
     </div>
</body>
</html>
