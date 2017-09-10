package com.londonappbrewery.destini;

/**
 * Created by arlen on 9/10/2017.
 */

public class Story {

    private int mQuestionId;
    private int mAnswer1;
    private int mAnswer2;

    public  Story(int _mQuestionId,int _mAnswer1,int _mAnswer2)
    {
        mQuestionId=_mQuestionId;
        mAnswer1=_mAnswer1;
        mAnswer2=_mAnswer2;
    }

    public int getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(int questionId) {
        mQuestionId = questionId;
    }

    public int getAnswer1() {
        return mAnswer1;
    }

    public void setAnswer1(int answer1) {
        mAnswer1 = answer1;
    }

    public int getAnswer2() {
        return mAnswer2;
    }

    public void setAnswer2(int answer2) {
        mAnswer2 = answer2;
    }
}
