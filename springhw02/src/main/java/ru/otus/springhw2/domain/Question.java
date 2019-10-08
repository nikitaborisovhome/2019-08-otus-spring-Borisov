package ru.otus.springhw2.domain;


import java.util.ArrayList;
import java.util.List;

public class Question {

    private String questionText;
    private List<Answer> answers;

    public Question(){
        answers = new ArrayList<Answer>();
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }

    public List<Answer> getAnswers(){
        return answers;
    }

    public void setQuestionText(String questionText){
        this.questionText = questionText;
    }

    public String getQuestionText(){
        return questionText;
    }


}
