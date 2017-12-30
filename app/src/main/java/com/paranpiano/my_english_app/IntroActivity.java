package com.paranpiano.my_english_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    private static final String TAG = "MyEnglishApp";

    EditText editText_userName;
    TextView textView_userNameShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Log.d(TAG, "Start App");

        setEditText();

        //setSwitch();

        ExportMethod e = new ExportMethod(this);
        e.setSwitch();

    }

    /*private void setSwitch(){

        final Switch textviewSwitch = (Switch)findViewById(R.id.textView_switchButton);

        textviewSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    textviewSwitch.setText("유음: on. 현재 유음입니다.");
                }else{
                    textviewSwitch.setText("유음: off. 현재 무음입니다.");
                }
            }
        });
    }*/

    private void setEditText(){

        editText_userName = (EditText)findViewById(R.id.editText_userName);
        textView_userNameShow = (TextView)findViewById(R.id.textView_userNameShow);
        editText_userName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (keyEvent==null) {
                    if (i== EditorInfo.IME_ACTION_DONE) {
                        Log.d(TAG, "EditorInfo.IME_ACTION_DONE");

                        textView_userNameShow.setText("사용할 UserName은  "+editText_userName.getText()+"입니다.");

                    }
                    // Capture soft enters in a singleLine EditText that is the last EditText.
                    else if (i==EditorInfo.IME_ACTION_NEXT) {
                        Log.d(TAG, "EditorInfo.IME_ACTION_NEXT");
                    }
                    // Capture soft enters in other singleLine EditTexts
                    else return false;  // Let system handle all other null KeyEvents
                }
                else if (i==EditorInfo.IME_NULL) {
                    // Capture most soft enters in multi-line EditTexts and all hard enters.
                    // They supply a zero actionId and a valid KeyEvent rather than
                    // a non-zero actionId and a null event like the previous cases.
                    if (keyEvent.getAction()==KeyEvent.ACTION_DOWN){
                        Log.d(TAG, "KeyEvent.ACTION_DOWN");
                    }
                    // We capture the event when key is first pressed.
                    else  return true;   // We consume the event when the key is released.
                }
                else  return false;
                // We let the system handle it when the listener
                // is triggered by something that wasn't an enter.


                // Code from this point on will execute whenever the user
                // presses enter in an attached view, regardless of position,
                // keyboard, or singleLine status.

            /*    if (view==multiLineEditText)  multiLineEditText.setText("You pressed enter");
                if (view==singleLineEditText)  singleLineEditText.setText("You pressed next");
                if (view==lastSingleLineEditText)  lastSingleLineEditText.setText("You pressed done");*/
                return true;   // Consume the event

            }
        });
/*        editText_userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_userNameShow.setText("이미존재하는 ID입니다.");
            }
        });*/
    }

}
