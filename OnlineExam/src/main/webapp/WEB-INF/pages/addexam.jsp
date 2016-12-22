<%@ include file="/common/taglibs.jsp"%>
<html>
    <head>
        <title>
            <fmt:message key="addexam.title"/>
        </title>
        <link rel="icon" href="img/c-finger-pointing.png">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
            integrity="sha384-   
            BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
            crossorigin="anonymous" />
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="css/bothtable.css">
        <link href='css/fonts.css' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/sweetalert2.css">
        <link rel="stylesheet" href="css/sweetalert2.min.css">
        <script src="js/sweetalert2.min.js"></script>
        <script src="js/sweetalert2.js"></script>
        <script src="js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="js/jssor.slider-21.1.5.mini.js"></script>
        <script src="js/parallex.js"></script>
        <script src="js/addexamform.validate.js"></script>
    </head>
    <body>
        <c:if test="${ null != SuccessMessage }">
            <script>
                swal({
                	title : "GoodJob!",
                	text : "<c:out value="${SuccessMessage}"/>",
                	type : "success"
                }, function(isConfirm) {
                	alert('ok');
                });
                $('.swal2-confirm').click(function() {
                	window.location.href = 'insertexamdetails';
                });
            </script>
        </c:if>
        <c:if test="${null !=  InsertExamMessage  }">
            <script>
                swal({
                	title : "Error",
                	text : "<c:out value="${InsertExamMessage}"/>",
                	type : "error"
                });
            </script>
        </c:if>
        <div class="header">
            <div class="logout" style="float: right">
                <a href="logout" class="btn btn-danger" title="logout"><span class="glyphicon glyphicon-log-out"></span></a>
            </div>
            <div class="logout" style="float: left">
                <a href="/home" class="btn btn-success" title="logout">
                    <fmt:message key="button.mainpage"/>
                </a>
            </div>
        </div>
        <center>
        <div class="center">
            <div class="inputform">
                <div class="form">
                    <div class="tab-content" style="margin: 25px">
                        <div id="signup">
                            <h1 style="color: #FFFFFF">
                                <fmt:message key="addexam.heading"/>
                            </h1>
                            <form:form action="addingexam" method="post" role="form"
                                class="form" modelAttribute="exam" name="addExam" onsubmit="return validateAssignQuestionForm()">
                                <div class="top-row">
                                    <div class="field-wrap">
                                        <label>
                                            <fmt:message key="exam.name"/>
                                            <span class="req">*</span>
                                        </label>
                                        <form:input path="examName" name="examname"
                                            class="form-control"
                                            title="Enter words only"></form:input>
                                    </div>
                                    <div class="field-wrap">
                                        <label>
                                            <fmt:message key="exam.duration"/>
                                            <span class="req">*</span>
                                        </label>
                                        <form:input path="examDuration" name="duration"
                                            required="required" class="form-control"></form:input>
                                    </div>
                                </div>
                                <div class="field-wrap">
                                    <label>
                                        <fmt:message key="exam.questions"/>
                                        <span class="req">*</span>
                                    </label>
                                    <form:input path="NoOfTotalQuestions" name="TotalQuestions"
                                        required="required" class="form-control"></form:input>
                                </div>
                                <button type="submit" class="button button-block" />
                                    <fmt:message key="button.createexam"/>
                                </button>
                            </form:form>
                        </div>
                        <div id="login"></div>
                    </div>
                    <!-- tab-content -->
                </div>
                <!-- /form -->
                <script src='js/form.js'></script>
                <script src="js/index.js"></script>
            </div>
            <!--- input-form -->
    </body>
</html>




