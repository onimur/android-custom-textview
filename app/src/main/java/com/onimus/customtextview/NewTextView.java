/*
 *
 *  * Created by Murillo Comino on 15/09/19 13:19
 *  * Github: github.com/MurilloComino
 *  * StackOverFlow: pt.stackoverflow.com/users/128573
 *  * Email: murillo_comino@hotmail.com
 *  *
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 14/09/19 12:01
 *
 */

package com.onimus.customtextview;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatTextView;
import android.util.AttributeSet;

import static com.onimus.customtextview.ConfigActivity.BASTAO;
import static com.onimus.customtextview.ConfigActivity.CASUAL;
import static com.onimus.customtextview.ConfigActivity.CURSIVA;
import static com.onimus.customtextview.ConfigActivity.FONTFAMILY;
import static com.onimus.customtextview.ConfigActivity.USER_FONTFAMILY;

public class NewTextView extends AppCompatTextView {
    private Context context;
    private String fontFamily;


    public NewTextView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public NewTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public NewTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {

        SharedPreferences preferences;
        preferences = context.getSharedPreferences(USER_FONTFAMILY, Context.MODE_PRIVATE);
        if (preferences != null) {
            fontFamily = preferences.getString(FONTFAMILY, null);

            if (fontFamily != null) {
                switch (fontFamily) {
                    case CASUAL: {
                        Typeface tf = Typeface.create("sans-serif", Typeface.NORMAL);
                        setTypeface(tf);
                        break;
                    }
                    case CURSIVA: {
                        Typeface tf = Typeface.create("serif-monospace", Typeface.NORMAL);
                        setTypeface(tf);
                        break;
                    }
                    case BASTAO: {
                        Typeface tf = Typeface.create("sans-serif-smallcaps", Typeface.NORMAL);
                        setTypeface(tf);
                        break;
                    }

                }
            }
        } else {
            //default
            Typeface tf = Typeface.create("sans-serif", Typeface.BOLD_ITALIC);
            setTypeface(tf);
        }

    }
}
