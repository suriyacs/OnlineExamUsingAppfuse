<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add question</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
            integrity="sha384-   
            BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
            crossorigin="anonymous" />
        <link rel="stylesheet" href="css/form-basic.css">
        <link rel="stylesheet" href="css/sweetalert2.min.css">
        <link rel="stylesheet" href="css/sweetalert2.css">
        <link rel="stylesheet" href="css/login.css">
        <script src="js/sweetalert2.min.js"></script>
        <script src="js/sweetalert2.js"></script>
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="js/questionvalidation.js"></script>
        <script src="js/checkifcorrect.js"></script>
        <script>
            $(function() {
            	$('#colorselector').change(function() {
            		$('.colors').hide();
            		$('#' + $(this).val()).show();
            	});
            });
        </script>
    </head>
    <body>
        <c:if test="${null != SuccessMessage }">
            <script>
                swal({ 
                  title: "Good job!",
                   text: "<c:out value="${SuccessMessage}"/>",
                    type: "success" 
                    },function(isConfirm){
                       alert('ok');
                      });
                       $('.swal2-confirm').click(function(){
                        window.location.href="insertquestion";
                  });
            </script>
        </c:if>
        <c:if test="${null != insertQuestionMessage }">
            <script>
                swal({ 
                  title: "Error",
                  text: "<c:out value="${insertQuestionMessage}"/>",
                    type: "error" 
                  });
            </script>
        </c:if>
        <div class="content">
            <div class="header">
                <div class="head">
                    <h1 class="title">TechAssess</h1>
                </div>
                <div class="mainpage">
                    <a href="adminpage" class="btn btn-success" title="mainpage">Main Page</span></a>
                </div>
                <div class="logout">
                    <a href="logout" class="btn btn-danger" title="logout"><span
                        class="glyphicon glyphicon-log-out"></span></a>
                </div>
            </div>
            <br>
            <br>
            <br>
            <center>
                <div class="bs-docs-example">
                    <select id="colorselector" class="form-control"data-style="btn-primary" style="width: 20%;">
                        <option selected="selected">Select Question Type</option>
                        <option value="fill">Fill In The Blanks</option>
                        <option value="choose">Choose The Best Answer</option>
                        <option value="Multiple">Multiple Answer Question</option>
                    </select>
                </div>
            </center>
            <div id="fill" class="colors" style="display: none">
                <div class="well">
                    <form name="fillup" method="post" action="fillintheblanks" onsubmit="return validatefillupform()">
                        <table class="table">
                            <tr>
                                <th><span>Question</span></th>
                                <td><textarea name="questionname"></textarea></td>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <th><span>Answer</span></th>
                                <td><input type="text" name="answer"></td>
                                <td><input type="hidden" name="checkbox" value="1"></td>
                            </tr>
                            <tr>
                                <td><button type="submit" class="btn btn-primary">Add</button></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
            <div id="choose" class="colors" style="display: none">
                <div class="well">
                    <table class="table">
                        <form:form method="post" action="choosethebest"
                            modelAttribute="Question">
                            <tr>
                                <th><span>Question</span></th>
                                <td>
                                    <form:textarea path="questionName" required="required"></form:textarea>
                                </td>
                                <td>
                                <th><span>Click The Check Box If Corresponding Choice
                                    is Correct Answer.</span>
                                </th>
                                </td>
                            </tr>
                            <c:set var="count" value="1" scope="page" />
                            <c:forEach items="${Question.choices}" var="choice"
                                varStatus="status">
                                <tr>
                                    <th>
                                        <span>Choice</span> 
                                        <c:out
                                            value="${Choice ? '' : count}" />
                                    </th>
                                    <td><input name="choices[${status.index}].choiceName"
                                        value="${choice.choiceName}" required="required"></td>
                                    <th><span>IsCorrect</span></th>
                                    <td><input name="checkboxofchoose" type="checkbox" id="<c:out value='${count}'/>"
                                        onchange="correct()"></td>
                                    <td><input type="hidden"
                                        name="choices[${status.index}].isCorrect"
                                        value="${choice.isCorrect}"
                                        id="choose<c:out value='${count}'/>"></td>
                                </tr>
                                <c:set var="count" value="${count + 1}" scope="page" />
                            </c:forEach>
                            <tr>
                                <td><button type="submit" class="btn btn-primary" onclick="return checkChooseCheckBoxes()">Add</button></td>
                                <td><input type="hidden" name="questionType" value="2"></td>
                            </tr>
                        </form:form>
                    </table>
                </div>
            </div>
            <div id="Multiple" class="colors" style="display: none">
                <div class="well">
                    <table class="table">
                        <form:form method="post" action="choosethebest"
                            modelAttribute="Question">
                            <tr>
                                <th><span>Question</span></th>
                                <td>
                                    <form:textarea path="questionName" required="required"></form:textarea>
                                </td>
                                <td>
                                <th><span>Click The Check Box If Corresponding Choice
                                    is Correct Answer.</span>
                                </th>
                                </td>
                            </tr>
                            <c:set var="count" value="1" scope="page" />
                            <c:forEach items="${Question.choices}" var="choice"
                                varStatus="status">
                                <tr>
                                    <th>
                                        <span>Choice</span> 
                                        <c:out
                                            value="${Choice ? '' : count}" />
                                    </th>
                                    <td><input name="choices[${status.index}].choiceName"
                                        value="${choice.choiceName}" required="required"></td>
                                    <th><span>IsCorrect</span></th>
                                    <td><input name="multipleCheckBox" type="checkbox" id="<c:out value='${count}'/>"
                                        onchange="correct()">
                                    <td><input type="hidden"
                                        name="choices[${status.index}].isCorrect"
                                        value="${choice.isCorrect}"
                                        id="multiple<c:out value='${count}'/>"></td>
                                </tr>
                                <c:set var="count" value="${count + 1}" scope="page" />
                            </c:forEach>
                            <tr>
                                <td><button type="submit" class="btn btn-primary" onclick="return checkMultipleCheckBoxes()">Add</button></td>
                                <td><input type="hidden" name="questionType" value="3"></td>
                            </tr>
                        </form:form>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>


