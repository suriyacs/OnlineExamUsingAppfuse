package com.i2i.webapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.i2i.exception.DataException;
import com.i2i.model.Exam;
import com.i2i.model.Answer;
import com.i2i.model.User;
import com.i2i.service.ExamManager;
import com.i2i.service.QuestionManager;
import com.i2i.service.ResultManager;
import com.i2i.service.UserManager;
import com.i2i.util.FileUtil;

/**
 * <p>
 * This class passes provides interface between jsp page and Service classes.
 * performs Exam operations like result calculation and allocate question to
 * exam and varies page redirections
 * </p>
 * 
 * @author TechAssess
 *
 */
@Controller
public class ExamController { 
    private ExamManager examManager = null;
    private QuestionManager questionManager = null;
    private UserManager userManager = null;
    private ResultManager resultManager = null;
    
    @Autowired
    public void setExamManager(final ExamManager examManager) {
        this.examManager = examManager;
    }
    
    @Autowired
    public void setQuestionManager(final QuestionManager questionManager) {
        this.questionManager = questionManager;
    }
    
    @Autowired
    public void setUserManager(final UserManager userManager) {
        this.userManager = userManager;
    }
    
    @Autowired
    public void setResultManager(final ResultManager resultManager) {
        this.resultManager = resultManager;
    }
    
    /**
     * <p>
     * Method which redirect to loginpage.
     * </p>
     * 
     * @return string 
     *     Consist of name of the java server page to be loaded.
     */
    @RequestMapping("loginpage")
    public String goToLoginPage() {
        return "login";
    }

    /**
     * <p>
     * Method which accept request from the java server page whenever the admin
     * wants to add a exam for the user and request the examService to insert
     * the exam.
     * </p>
     * 
     * @param exam
     *     Consist of instance of Exam type which needs to be inserted on
     *     the database.
     * @param Message
     *     Contains message to be displayed on the java server page.
     * @return string 
     *     Contains name of the java server page in which the message
     *     get's displayed and prompts the user to add another exam.
     */
    @RequestMapping(value = "/addingexam", method = RequestMethod.POST)
    public String insertExam(@ModelAttribute Exam exam, ModelMap Message) {
        try {
            examManager.addExamDetails(exam);
            Message.addAttribute("SuccessMessage", "Added Successfully..!!");
        } catch (DataException e) {
            Message.addAttribute("InsertExamMessage", (e.getMessage().toString()));
            FileUtil.logError(e.toString());
        } 
        return "addexam";
    }

    /**
     * <p>
     * Method which redirect to jsp page named adminpage.jsp.
     * </p>
     * 
     * @return string 
     *    Contains name of the Java Server page to be redirected.
     */
    @RequestMapping(value = "/adminpage")
    public String goToAdminPage() {
        return "adminpage";
    }

    /**
     * <p>
     * Method which gets invoked when the admin add question to the exam, and it
     * request service's of exam and question to allocated question for that
     * specific exam.
     * </p>
     * 
     * @param model
     *     Contains messages to be displayed on the java server page such
     *     as allocation success or database connection failure message.
     * @param examId
     *     Contains id of the exam to be tracked for allocating the
     *     question.
     * @param fromQuestionId
     *     Contains starting id of the question to be allocated for the
     *     given exam.
     * @param toQuestionId
     *     Represents id of the question to be allocated.
     * @return string 
     *     Contains name of the java server page to be loaded.
     */
    @RequestMapping(value = "/allocating", method = RequestMethod.POST)
    public String allocateQuestionsToExam(ModelMap model, @RequestParam("examId") int examId,
            @RequestParam("fromQuestionId") int fromQuestionId, @RequestParam("toQuestionId") int toQuestionId) {
        try {
            examManager.checkIfExamExist(examId);
            questionManager.checkIfQuestionsExist(fromQuestionId, toQuestionId);
            examManager.allocateQuestionsToExam(examId, fromQuestionId, toQuestionId);
            model.addAttribute("allocateMessage", "AllocatedSuccessfully..!!");
        } catch (DataException e) {
            model.addAttribute("ErrorMessage", e.getMessage().toString());
            FileUtil.logError(e.toString());
        }
        return ("assignquestions");
    }

    /**
     * <p>
     * Method which gets invoked when the user wants to allocate question, it
     * request the question and exam service for retrieving the entire details
     * of the question and exam finally passes those list to assign question
     * java server page.
     * </p>
     * 
     * @param model
     *     Contains list type of question and exam or contains message of
     *     database connection failure.
     * @return string
     *     Contains name of the java server page which needs to be loaded.
     */
    @RequestMapping(value = "/allocatequestionpage")
    public String redirectToAssignQuestionPage(ModelMap model) {
        try {
            model.addAttribute("questionList", questionManager.getAllQuestions());
            model.addAttribute("examList", examManager.getAllExamDetails());
        } catch (DataException e) {
            model.addAttribute("ErrorMessage", e.getMessage().toString());
            FileUtil.logError(e.toString());
        }
        return ("assignquestions");
    }

    /**
     * <p>
     * Method which gets invoked when the user click login from the login
     * page.gets details of allexams from examService class and pass it to jsp
     * page named userpage.jsp.
     * </p>
     * 
     * @param model
     *     Used to store details of all the exam or to store the error
     *     message raised at the time of database connection.
     * @return string
     *     Contains name of the java server page to be loaded.
     */
    @RequestMapping(value = "/gotouserpage")
    public String goToUserPage(ModelMap model, final HttpServletRequest request) {
        try {
            model.addAttribute("userName", (userManager.getUserByUsername(request.getRemoteUser())).getUsername());
            model.addAttribute("exams", examManager.getAllExamDetails());
        } catch (DataException e) {
            model.addAttribute("ExamMessage", e.toString());
            FileUtil.logError(e.toString());
        }
        return "userpage";
    }

    /**
     * <p>
     * Method which redirects to add admin page when the admin clicks the
     * addadmin button on admin page.
     * </p>
     * 
     * @return string
     *     Contains name of the java server page to be loaded.
     */
    @RequestMapping(value = "/insertadmin")
    public String redirectToInsertAdminPage() {
        return "addadmin";
    }

    /**
     * <p>
     * Method which redirect to add exam java server page when the admin click
     * add exam button in admin page.
     * </p>
     * 
     * @param model
     *     Contains an instance of exam type.
     * @return string
     *     Contains name of the java server page which needs to be loaded.
     */
    @RequestMapping(value = "/insertexamdetails")
    public String redirectToInsertTestPage(ModelMap model) {
        Exam exam = new Exam();
        model.addAttribute("exam", exam);
        return "addexam";
    }

    /**
     * <p>
     * Method which redirect the incoming request to add question page once the
     * question is successfully inserted.
     * </p>
     * 
     * @return string
     *     Contains name of the mapping to be called.
     */
    @RequestMapping(value = "/reloadinsertQuestion")
    public String reloadInsertQuestionPage() {
        return ("redirect:insertquestion");
    }

    /**
     * <p>
     * Method which gets invoked when the user click the take start test button
     * on the user page. checks if user already attended this exam.if not then
     * gets the particular exam detials from examService class and pass it to
     * jsp page named questionpageforuser.jsp.
     * </p>
     * 
     * @param session
     *     Contains object of the session when the user logged in.
     * @param testId
     *     Contains id of the test the user wants to take.
     * @param model
     *     Used to store message stating that the user already attended
     *     the selected exam or to store the name of the user and exam as
     *     well as instance of an exam.
     * @return string
     *     Contains name of the java server page wuserNamehich needs to be loaded.
     */
    @RequestMapping(value = "/taketest")
    public String redirectToQuestionPage(final HttpServletRequest request,@RequestParam("test")String testId, ModelMap model) {
        User user = null;    
            
        try {
            user = userManager.getUserByUsername(request.getRemoteUser());
            if (examManager.checkIfUserAlreadyAttendedThisTest(testId, user)) {
                model.addAttribute("ExamMessage", "Sorry.!!you already attended this exam..!!");
                return "userpage";
            }
            examManager.addUserToExam(testId, user.getId());
            Exam exam = examManager.getExamById(Integer.parseInt(testId));
            for (int answerCount = 0; answerCount < Integer.parseInt(exam.getNoOfAllocatedQuestions()); answerCount++) {
                exam.addAnswer(new Answer());
            }
            model.addAttribute("userName", user.getUsername());
            model.addAttribute("examName", exam.getExamName());
            model.addAttribute("testId", testId);
            model.addAttribute("exam", exam);
        } catch (DataException e) {
            model.addAttribute("questionMessage", (e.getMessage().toString()));
            FileUtil.logError(e.toString());
        } catch (NumberFormatException e) {
            model.addAttribute("questionMessage",
                    "Error occured during conversion of testId" + " " + testId + " " + "while allocting the exam");
        }
        return "questionpageforuser";
    }

    /**
     * <p>
     * Method which calculates the result by calling the calculateResult method
     * of resultManager class.return the mark back to login page.
     * </p>
     * 
     * @param exam
     *     Contains instance of the exam object which the user attended.
     * @param result
     *     Contains binded object from the java server page.
     * @param model
     *     Contains an instance to store the mark obtain by the user.
     * @param examId
     *     Contains id of the exam attended by the user.
     * @param session
     *     Object contains information about the user who logged in to
     *     write the exam.
     * @return string
     *     Contains name of the java server page to be loaded.
     */
    @RequestMapping(value = "/resultcalculation", method = RequestMethod.POST)
    public String calculateResult(@ModelAttribute("exam") Exam exam, BindingResult result, ModelMap model,
            @RequestParam("examId") int examId, final HttpServletRequest request) {
        try {
            model.addAttribute("mark",resultManager.calculateResult(exam, examId, userManager.getUserByUsername(request.getRemoteUser())));
        } catch (DataException e) {
            model.addAttribute("mark", e.getMessage().toString());
            FileUtil.logError(e.toString());
        }
        return "userpage";
    }
}
