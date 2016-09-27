<%@ include file="/common/taglibs.jsp"%>
<html>
    <head>
        <title>Exam</title>
        <link href="css/login.css" rel="stylesheet" type="text/css">
        <link href="css/row.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
            integrity="sha384-  
            BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
            crossorigin="anonymous">
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="js/parallex.js"></script>
        <script src="js/sweetalert2.min.js"></script>
        <link rel="stylesheet" href="css/sweetalert2.min.css">
        <script src="js/sweetalert2.js"></script>
        <link rel="stylesheet" href="css/sweetalert2.css">
        <script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="js/preventingrefresh.js"></script>
    </head>
    <body onload="updateClock(); setInterval('updateClock()', 1000 )" oncontextmenu="return false" onkeydown="return (event.keyCode != 116)" >
        <c:if test="${null != questionMessage}">
            <script>
                swal({ 
                 title: "Error",
                  text: "<c:out value="${questionMessage}"/>",
                   type: "error" 
                       },function(isConfirm){
                           alert('ok');
                       });
                       $('.swal2-confirm').click(function(){
                             window.location.href = 'gotouserpage';
                       });
                 
            </script>
        </c:if>
        <!-- <script type="text/javascript">
            $(window).on('beforeunload', function() {
            	  $(window).on('unload', function() {
            		window.location.href="logout";
            	  });
            	  return "submitted";
            	});
            </script> -->
        <div id="grid"></div>
        <div class="content">
            <div class="page-header">
                <h1 class="title" align="center">TechAssess</h1>
            </div>
            <h5>Time Remaining:</h5>
            <div id="countdown"></div>
            <div id="notifier"></div>
            <script type="text/javascript">
                function display(notifier, str) {
                	document.getElementById(notifier).innerHTML = str;
                }
                
                function myFunction() {
                	 swal({ 
                	  title: "Sorry!!",
                	   text: "Its Time Up..!!",
                	    type: "warning" 
                	  },function(isConfirm){
                               alert('ok');
                         });
                         $('.swal2-confirm').click(function(){
                       	  document.myform.submit();
                         });
                }
                
                function toMinuteAndSecond(x) {
                	return Math.floor(x / 60) + ":" + x % 60;
                }
                
                function setTimer(remain, actions) {
                	(function countdown() {
                		display("countdown", toMinuteAndSecond(remain));
                		actions[remain] && actions[remain]();
                		(remain -= 1) >= 0 && setTimeout(arguments.callee, 1000);
                	})();
                }
                
                setTimer(1500, {
                	10 : function() {
                		display("notifier", "Just 10 seconds to go");
                	},
                	5 : function() {
                		display("notifier", "5 seconds left");
                	},
                	0 : function() {
                		myFunction();
                	}
                });
            </script>
            <div class="usertab">
                <img src="img/userimage.png" alt="userimage">
                <h3>
                    <c:out value="${userName}" />
                </h3>
            </div>
            <div class="logout" style="float: right">
                <a href="logout" class="btn btn-danger" title="logout"><span
                    class="glyphicon glyphicon-log-out"></span></a>
            </div>
            <h4 style="text-align:center">
                <c:out value="${examName}" />
            </h4>
            <div class="questiondiv">
                <form:form action="resultcalculation" method="post"
                    modelAttribute="exam" name="myform">
                    <c:set var="count" value="1" scope="page" />
                    <input type="hidden" name="examId" value="${exam.getExamId() }">
                    <c:set var="count" value="1" scope="page" />
                    <c:forEach items="${exam.getAnswers()}" var="answer"
                        varStatus="status">
                        <c:set value="${exam.questions[status.index]}" var="que" />
                        <form:input type="hidden"
                            path="answers[${status.index}].questionId"
                            value="${que.getQuestionId()}" />
                        <br>
                        <br>
                        <div style="width:50%;">
                            <div style="width:80%;" class="question">
                                <c:out value="${count}" />
                                .
                                <c:out value="${que.getQuestionName()}" />
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="answerdiv">
                            <c:set var="count" value="${count + 1}" scope="page" />
                            <c:set value="${que.getTypeId()}" var="type" />
                            <c:forEach items="${que.getChoices()}" var="choice">
                                <c:if test="${type.getTypeId()==1}">
                                    <label>
                                        Answer:
                                        <form:input type="text"
                                            path="answers[${status.index}].userAnswer" />
                                    </label>
                                </c:if>
                                <c:if test="${type.getTypeId()==2}">
                                    <form:radiobutton path="answers[${status.index}].userAnswer"
                                        value="${choice.getChoiceName()}" />
                                    <c:out value="${choice.getChoiceName()}" />
                                    <br>
                                </c:if>
                                <c:if test="${type.getTypeId()==3}">
                                    <form:radiobutton path="answers[${status.index}].userAnswer"
                                        value="${choice.getChoiceName()}" />
                                    <c:out value="${choice.getChoiceName()}" />
                                    <br>
                                </c:if>
                            </c:forEach>
                        </div>
                        <br>
                        <hr>
                    </c:forEach>
                    <br>
                    <br>
                    <input id="button" type="submit" value="submit answers"
                        class="btn btn-primary" />
                </form:form>
            </div>
        </div>
    </body>
</html>


