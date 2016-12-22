<%@ include file="/common/taglibs.jsp"%>
<html>
    <head>
        <title>Exam Details</title>
        <link rel="icon" href="img/c-finger-pointing.png">
        <link href="css/login.css" rel="stylesheet" type="text/css">
        <link href="css/userpage.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
            integrity="sha384-  
            BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
            crossorigin="anonymous">
        <link rel="stylesheet" href="css/sweetalert2.css">
        <link rel="stylesheet" href="css/sweetalert2.min.css">
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="js/sweetalert2.min.js"></script>
        <script src="js/sweetalert2.js"></script>
        <script src="js/parallex.js"></script>
        <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script
            src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:if test="${ null != ExamMessage}">
            <script>
                swal({ 
                  title: "Error",
                   text: "<c:out value="${ExamMessage}"/>",
                    type: "error" 
                  },function(isConfirm){
                              alert('ok');
                        });
                        $('.swal2-confirm').click(function(){
                              window.location.href = 'gotouserpage';
                     });
            </script>
        </c:if>
        <c:if test="${ null != mark }">
            <script type="text/javascript">
                swal({ 
                  title: "Your Mark",
                   text: "<c:out value="${mark}"/>",
                    type: "success" 
                    }, function(isConfirm) {
                    	alert('ok');
                    });
                    $('.swal2-confirm').click(function() {
                    	window.location.href = 'gotouserpage';
                    });
            </script>
        </c:if>
            <div id="header">
                <div class="usertab">
                    <img src="img/userimage.png" alt="userimage">
                    <h3 class="headertag">
                        <c:out value="${userName}" />
                    </h3>
                </div>
                <div class="logout" style="float: right">
                    <a href="logout" class="btn btn-danger" title="logout"><span
                        class="glyphicon glyphicon-log-out"></span></a>
                </div>
                <h2 class="headertag">Exam to be Attended</h2>
            </div>
            <div class="content-container">
                <div id="content"></div>
                <c:set var="count" value="1"/>
                <div class="well">
                    <table class="buttontable">
                        <c:forEach items="${exams}" var="exam">
                            <tr>
                                <td>
                                    <a id="load_home" href="#demo<c:out value="${Choice ? '' : count}"/>" class="btn btn-info btn-lg"
                                         data-toggle="collapse">
                                    <c:out value="${exam.getExamName()}" />
                                    </a>
                                </td>
                            </tr>
                            <c:set var="count" value="${count + 1}"/>
                        </c:forEach>
                    </table>
                </div>
                <c:set var="count" value="1"/>
                <div id="form">
                    <c:forEach items="${exams}" var="exam">
                        <form id="demo<c:out value="${Choice ? '' : count}"/>" action="taketest" class="collapse" method="post">
                            <table class="table borderless">
                                <thead>
                                    <tr class='borderless'>
                                        <th class="theader">Instructions:</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr><td>1.Examinations will be conducted during
                                        the allocated times shown in the examination timetable.</td></tr>
                                    <tr class='borderless'><td>2.Handphones brought into the examination hall
                                        must be switched off at ALL times.</td></tr>
                                    <tr class='borderless'><td>3.Photography is NOT allowed in the examination hall at
                                        ALL times.</td></tr>
                                    <tr class='borderless'><td>4.All materials and/or devices which are
                                        found in violation of any examination regulations will be
                                        confiscated.</td></tr>
                                    <tr class='borderless'><td>5.The examination hall will be open for
                                        admission 10 minutes before the time scheduled for the
                                        commencement of the examination.</td></tr>
                                    <tr class='borderless'><td>6. You will not be admitted for the examination 
                                        after one hour of the commencement of the examination.</td></tr>
                                    <tr class='borderless'><td>7.Do NOT continue to write after the
                                        examination has ended. You are to remain seated quietly whileCreate
                                        your answer scripts are being collected and counted.</td></tr>
                                    <tr class='borderless'><td>8.No reference materials, in whatever format, are allowed.</td></tr>
                                    <tr class='borderless'><td>9.You are to stay in the examination hall until the Chief
                                        Invigilator has given the permission to leave. Do NOT talk until
                                        you are outside of the examination hall.</td></tr>
                                    <tr class='borderless'><td>10. You may bring into the examination hall only 
                                        those calculators that have been approved by the School.</td></tr>
                                </tbody>
                            </table>
                        <input type="checkbox" id="checkbox">Agreed and im ready tostart the test<br> 
                        <label>
                            <input type="hidden" name="test" value="<c:out value="${exam.getExamId()}"/>"/>
                        </label>
                        <br>
                        <input id="button" type="submit" value="START" class="btn btn-primary"/>
                        </form>
                        <c:set var="count" value="${count + 1}"/>
                    </c:forEach>
                </div>
            </div>
    </body>
</html>


