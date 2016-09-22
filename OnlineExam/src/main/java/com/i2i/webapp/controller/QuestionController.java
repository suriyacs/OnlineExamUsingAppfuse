package com.i2i.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*import exception.DataException;
import com.i2i.model.Choice;
import com.i2i.model.Question;
import com.i2i.service.choiceManager;*/
import com.i2i.service.QuestionManager;
import com.i2i.model.Question;
import com.i2i.model.Choice;
import com.i2i.service.ChoiceManager;

/**
 * <p>
 * This class provides interface between jsp page and service class. passess
 * question details from jso page to service class
 * </p>
 * 
 * @author suriyakumar
 *
 */
@Controller
public class QuestionController {
    private QuestionManager questionManager;
    private ChoiceManager choiceManager;

    @Autowired
    public void setQuestionManager(final QuestionManager questionManager) {
        this.questionManager = questionManager;
    }

    public QuestionManager getQuestionManager() {
        return this.questionManager;
    }
    
    @Autowired
    public void setChoiceManager(final ChoiceManager choiceManager) {
        this.choiceManager = choiceManager;
    }

    public ChoiceManager getChoiceManager() {
        return this.choiceManager;
    }
    
    /**
     * <p>
     * Method which add the multiple answer and choose the correct answer
     * question.which gets question and its choices in object format named
     * question.first add the question and map the added question into its
     * questiontype by calling allocateQuestionType method of questionManager
     * class. then add the choices of this question one by one then map the
     * choice to this question by calling allocateQuestion method of
     * choiceManager class.
     * </p>
     * 
     * @param question
     *     Contains instance of Question type with values entered by the
     *     admin to insert a question.
     * @param model
     *     Used to store insertion success or failure message or
     *     exception message occured at the time of database connection.
     * @param questionType
     *     Contains instance of question type the question was created.
     * @return string contains name of the java server page to be loaded.
     */
    @RequestMapping(value = "/choosethebest", method = RequestMethod.POST)
    public String addQuestionForChooseTheBest(@ModelAttribute("Question") Question question, ModelMap model,
            @RequestParam("questionType") String questionType) {
        try {
            int questionId = questionManager.addQuestion(question.getQuestionName());
            //questionManager.allocateQuestionType(Integer.parseInt(questionType), questionId);
            for (Choice choice : question.getChoices()) {
                choiceManager.allocateQuestion(choiceManager.addChoice(choice.getChoiceName(), (choice.getIsCorrect())),
                        questionId);
            }
            model.addAttribute("SuccessMessage", "Added Successfully..!!");
        } catch (Exception e) {
            model.addAttribute("insertQuestionMessage", (e.toString()));
        } /*catch (NumberFormatException e) {
            model.addAttribute("insertQuestionMessage", "Error occured during conversion of" + " " + questionType);
        }*/
        return ("addquestion");

    }

    /**
     * <p>
     * Method which add number of choice object to the list created in the form
     * of choice type and redirect to add question page once the admin click
     * insert question button.
     * </p>
     * 
     * @param model
     *     Contains instance of question.
     * @return string contains name of the java server page which need's to be
     *         loaded.
     */
    @RequestMapping(value = "/insertquestion")
    public String redirectToInsertQuestionPage(ModelMap model) {
        Question question = new Question();
        question.add(new Choice());
        question.add(new Choice());
        question.add(new Choice());
        question.add(new Choice());
        model.addAttribute("Question", question);
        return "addquestion";
    }

    /**
     * <p>
     * Method which gets invoked when the request from add question page is
     * received it stores the question and answer of the type fill in the blanks
     * into the database.
     * </p>
     * 
     * @param questionName
     *     Contains name of the question entered on insert question page.
     * @param answer
     *     Contains choice of answer's for that given answer.
     * @param correctAnswer
     *     Contains correct answer for this question.
     * @param model
     *     Contains model object for storing the insertion successor
     *     failure message or exception message created during the
     *     database connection.
     * @return string contains name of the java server page to be loaded.
     */
    @SuppressWarnings("finally")
    @RequestMapping(value = "/fillintheblanks")
    public String addQuestionForFillup(@RequestParam("questionname") String questionName,
            @RequestParam("answer") String answer, @RequestParam("checkbox") String correctAnswer, ModelMap model) {
        try {
            int questionId = questionManager.addQuestion(questionName);
            int choiceId = choiceManager.addChoice(answer, Integer.parseInt(correctAnswer));
            //questionManager.allocateQuestionType(1, questionId);
            choiceManager.allocateQuestion(choiceId, questionId);
            model.addAttribute("SuccessMessage", correctAnswer + " " + "InserTion Success");
        } catch (Exception e) {
            model.addAttribute("insertQuestionMessage", (e.toString()));
        } /*catch (NumberFormatException e) {
            model.addAttribute("insertQuestionMessage",
                    "Error occured during conversion of" + " " + correctAnswer + " " + "in insert fill up page");
        } */ finally {
            return ("redirect:insertquestion");
        }
    }
}
