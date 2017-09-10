package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    TextView mTextViewStory;
    int mStoryIndex;
    int mPosition;

    private Story[] mStoryBank = new Story[] {
            new Story(R.string.T1_Story, R.string.T1_Ans1,R.string.T1_Ans2),
            new Story(R.string.T2_Story, R.string.T2_Ans1,R.string.T2_Ans2),
            new Story(R.string.T3_Story, R.string.T3_Ans1,R.string.T3_Ans2),
            new Story(R.string.T4_End, -1,-1),
            new Story(R.string.T5_End, -1,-1),
            new Story(R.string.T6_End, -1,-1),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonTop=(Button)findViewById(R.id.buttonTop);
        mButtonBottom=(Button)findViewById(R.id.buttonBottom);
        mTextViewStory=(TextView)findViewById(R.id.storyTextView);

        // 1st Question
        mStoryIndex=1;
        DisplayQuestion(mStoryIndex);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        View.OnClickListener myListener=new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(v.getId()==mButtonTop.getId()) {
                    //buttonTop Clicked
                    if (mStoryIndex == 1 || mStoryIndex == 2) {
                        mStoryIndex = 3;
                        DisplayQuestion(mStoryIndex);
                    }else if (mStoryIndex == 3) {
                        mStoryIndex = 6;
                        DisplayQuestion(mStoryIndex);
                    }
                }
                else //buttonBottom Clicked
                {
                    if ( mStoryIndex == 1) {
                        mStoryIndex=2;
                        DisplayQuestion(mStoryIndex);
                    }else if (mStoryIndex==2 ) {
                        mStoryIndex=4;
                        DisplayQuestion(mStoryIndex);
                    }else if (mStoryIndex==3 ) {
                        mStoryIndex = 5;
                        DisplayQuestion(mStoryIndex);
                    }
                }
            }
        };

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonTop.setOnClickListener(myListener);
        mButtonBottom.setOnClickListener(myListener);
    }

    private void DisplayQuestion(int _mIndex) {
        _mIndex=_mIndex-1;
        Story _story = mStoryBank[_mIndex];
        mPosition = _story.getQuestionId();
        mTextViewStory.setText(mPosition);

        if (_story.getAnswer1() != -1) {
            mButtonTop.setVisibility(View.VISIBLE);
            mButtonBottom.setVisibility(View.VISIBLE);
            mButtonTop.setText(_story.getAnswer1());
            mButtonBottom.setText(_story.getAnswer2());
        } else {
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }
    }

}
