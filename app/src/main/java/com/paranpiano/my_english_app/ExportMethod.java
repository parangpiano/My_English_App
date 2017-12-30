package com.paranpiano.my_english_app;

import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

/**
 * Created by Administrator on 2017-12-30.
 */

public class ExportMethod {
    AppCompatActivity a;
    public ExportMethod(AppCompatActivity a){
        this.a = a;
    }

    public void setSwitch(){

        final Switch textviewSwitch = (Switch)a.findViewById(R.id.textView_switchButton);

        textviewSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    textviewSwitch.setText("현재 유음");
                }else{
                    textviewSwitch.setText("현재 무음");
                }
            }
        });
    }
}
