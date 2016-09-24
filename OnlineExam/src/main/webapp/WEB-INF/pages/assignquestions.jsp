<%@ include file="/common/taglibs.jsp"%>
<html>
    <head>
        <title>Assign Question to Exam</title>
        <link rel="icon" href="img/c-finger-pointing.png">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" integrity="sha384-   
            BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
        <link rel="stylesheet" href="css/login.css">
        <link rel="stylesheet" href="css/bothtable.css">
        <link href='css/fonts.css' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/sweetalert2.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/sweetalert2.min.css">
        <script type="text/javascript" src="js/jssor.slider-21.1.5.mini.js"></script>
        <script src="js/sweetalert2.min.js"></script>
        <script src="js/sweetalert2.js"></script>
        <script src="js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="js/jssor.slider-21.1.5.mini.js"></script>
        <script src="js/parallex.js"></script>
        <script src="js/assignquestion.js"></script>
    </head>
    <body>
        <c:if test="${null != ErrorMessage }">
            <script>
                swal({ 
                title: "Error",
                text: "<c:out value="${ErrorMessage}"/>",
                type: "error" 
                },function(isConfirm){
                          alert('ok');
                    });
                    $('.swal2-confirm').click(function(){
                          window.location.href = 'allocatequestionpage';
                    });
                 
            </script>
        </c:if>
        <c:if test="${null != allocateMessage }">
            <script>
                swal({ 
                title: "GoodJob!",
                 text: "<c:out value="${allocateMessage}"/>",
                  type: "success" 
                },function(isConfirm){
                            alert('ok');
                      });
                      $('.swal2-confirm').click(function(){
                            window.location.href = 'allocatequestionpage';
                      });
                 
            </script>
        </c:if>
        <div id="grid"></div>
        <div class="content">
            <div class="container">
                <div class="head">
                    <h1 class="title">TechAssess</h1>
                </div>
                <div class="wrapper">
                <div class="mainpage">
                    <a href="adminpage" class="btn btn-success" title="mainpage">Main Page</a>
                </div>
                <div class="logout">
                    <a href="logout" class="btn btn-danger" title="logout"><span
                        class="glyphicon glyphicon-log-out"></span></a>
                </div>
               </div>
            </div>
            <br><br>
            <div class="center">
               <div class="table">
                <div class="questiontable">
                    <table border="1" class="table table-striped">
                      <thead>
                        <tr style="text-align: center" class="qtable">
                            <th>Question Id</th>
                            <th>Question Name</th>
                            <th>Question Type</th>
                        </tr>
                      </thead>
                        <tbody>
                            <c:if test="${questionList != null}">
                                <c:forEach items="${questionList}" var="question">
                                    <tr class="qtable">
                                        <td class="filterable-cell">
                                            <c:out value="${question.getQuestionId()}" />
                                        </td>
                                        <td class="filterable-cell">
                                            <c:out value="${question.getQuestionName()}" />
                                        </td>
                                        <td class="filterable-cell">
                                            <c:out value="${question.getTypeId().getTypeName()}" />
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                    </table>
                </div>
                <div class="allexams" style="float: right">
                    <table border="1"class="table table-striped">
                      <thead>
                        <tr style="text-align: center">
                            <th>Exam Id</th>
                            <th>Exam Name</th>
                            <th>Duration</th>
                            <th>Total Questions</th>
                            <th>Allocated Questions</th>
                        </tr>
                       </thead>
                        <tbody>
                            <c:if test="${examList != null}">
                                <c:forEach items="${examList}" var="exam">
                                    <tr>
                                        <td class="filterable-cell">
                                            <c:out value="${exam.getExamId()}" />
                                        </td>
                                        <td class="filterable-cell">
                                            <c:out value="${exam.getExamName()}" />
                                        </td>
                                        <td class="filterable-cell">
                                            <c:out value="${exam.getExamDuration()}" />
                                        </td>
                                        <td class="filterable-cell">
                                            <c:out value="${exam.getNoOfTotalQuestions()}" />
                                        </td>
                                        <td class="filterable-cell">
                                            <c:choose>
                                                <c:when test="${exam.getNoOfAllocatedQuestions() != null}">
                                                    <c:out value="${exam.getNoOfAllocatedQuestions()}" />
                                                </c:when>
                                                <c:otherwise>
                                                    <c:out value="0" />
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                    </table>
                </div>
                </div> 
                <br> <br> <br> <br> <br> <br> <br>
                <br> <br> <br> <br>
                <center>
                <div class="form">
                    <div class="tab-content" style="margin: 25px">
                        <div id="signup">
                            <h1 style="color: black">Allocate Question</h1>
                            <form name="addQuestion" action="allocating" method="post" onsubmit="return validateAssignQuestionForm()">
                                <div class="field-wrap">
                                    <label> Enter Exam Id<span class="req">*</span>
                                    </label> <input type="text" name="examId" autocomplete="off" />
                                </div>
                                <div class="field-wrap">
                                    <label> Form QuestionId ToAllocate<span class="req">*</span>
                                    </label> <input type="text" name="fromQuestionId"
                                        autocomplete="off" />
                                </div>
                                <div class="field-wrap">
                                    <label> To QuestionId ToAllocate<span class="req">*</span>
                                    </label> <input type="text" name="toQuestionId"
                                        autocomplete="off" />
                                </div>
                                <button type="submit" class="button button-block">
                                Allocate
                                </button>
                            </form>
                        </div>
                        <div id="login"></div>
                    </div>
                    <!-- tab-content -->
                </div>
                <!-- /form -->
                </center>
                <script src='js/form.js'></script>
                <script src="js/index.js"></script>
            </div>
        </div>
    </body>
</html>

