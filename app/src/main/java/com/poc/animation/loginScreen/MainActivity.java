package com.poc.animation.loginScreen;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private View viewDummyBtn;
    private Button btnLogin;
    private LinearLayout lnrLoggingIn;
    private RelativeLayout rltTick;
    private View sliderView;

    private static final int LOADING_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_login);

        viewDummyBtn = findViewById(R.id.view_dummy_btn);
        rltTick = (RelativeLayout) findViewById(R.id.rlt_tick);
        lnrLoggingIn = (LinearLayout) findViewById(R.id.lnr_logging_in);
        sliderView = findViewById(R.id.slider_view);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginClick();
            }
        });
    }

    /**
     * perform your validation here and call <i>startAnimation()</i> after validation.
     */
    private void onLoginClick() {
        btnLogin.setVisibility(View.GONE);
        lnrLoggingIn.setVisibility(View.VISIBLE);

        startAnimation();
    }

    /**
     * start animation when fields are proper.
     */
    private void startAnimation() {
        ViewCompat.animate(lnrLoggingIn)
                .alpha(0)
                .scaleX(0.5f)
                .scaleY(0.5f)
                .setDuration(500)
                .setStartDelay(LOADING_TIME)
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {

                    }

                    @Override
                    public void onAnimationEnd(View view) {

                    }

                    @Override
                    public void onAnimationCancel(View view) {

                    }
                });

        ViewCompat.animate(viewDummyBtn)
                .scaleY(30)
                .setDuration(400)
                .setStartDelay(LOADING_TIME + 400);

        ViewCompat.animate(sliderView)
                .translationX(100)
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {
                        rltTick.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        rltTick.setVisibility(View.GONE);

                        revertBack();
                        performAction();
                    }

                    @Override
                    public void onAnimationCancel(View view) {

                    }
                })
                .setDuration(300)
                .setStartDelay(LOADING_TIME + 900);
    }

    private void revertBack() {
        ViewCompat.animate(viewDummyBtn)
                .scaleY(1)
                .setDuration(1)
                .setStartDelay(1);

        ViewCompat.animate(lnrLoggingIn)
                .alpha(1)
                .scaleX(1)
                .scaleY(1)
                .setDuration(1)
                .setStartDelay(1)
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {

                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        btnLogin.setVisibility(View.VISIBLE);
                        lnrLoggingIn.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(View view) {

                    }
                });

        ViewCompat.animate(sliderView)
                .translationX(0)
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {

                    }

                    @Override
                    public void onAnimationEnd(View view) {

                    }

                    @Override
                    public void onAnimationCancel(View view) {

                    }
                })
                .setDuration(1)
                .setStartDelay(1);
    }

    /**
     *perform your after validation things here.
     */
    private void performAction() {

    }
}
