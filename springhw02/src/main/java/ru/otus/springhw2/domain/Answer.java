package ru.otus.springhw2.domain;

public  class Answer {
    private int id;
    private String answerText;
    private boolean isCorrect;

       /* public Answer(byte id, String answerText,boolean isCorrect){
            this.id=id;
            this.answerText=answerText;
            this.isCorrect=isCorrect;
        } */

    public int getId(){
        return id;
    }

    public String getAnswerText(){
        return answerText;
    }

    public boolean getIsCorrect(){
        return isCorrect;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public void setId(int id) {
        this.id = id;
    }
}