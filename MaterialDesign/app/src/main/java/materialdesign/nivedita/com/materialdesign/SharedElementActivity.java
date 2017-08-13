package materialdesign.nivedita.com.materialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by PUNEETU on 13-08-2017.
 */

public class SharedElementActivity extends AppCompatActivity {

    private RelativeLayout revealDemo;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);

        initPage();
    }

    private void initPage() {

        getSupportActionBar().setTitle("Shared Element Transition");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        revealDemo = (RelativeLayout) findViewById(R.id.click_reveal);
        revealDemo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                makeCircularRevealAnimation(revealDemo);
            }
        });
        Button btnExit = (Button) findViewById(R.id.exit_button);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }

    private void makeCircularRevealAnimation(View view) {

        final TextView textDesc = (TextView)findViewById(R.id.textDesc);

        int centerX = (view.getLeft() + view.getRight())/2;
        int centerY = (view.getTop() + view.getBottom())/2;

        float radius = Math.max(textDesc.getWidth(), textDesc.getHeight()) * 2.0f;

        if (textDesc.getVisibility() == View.INVISIBLE) {
            textDesc.setVisibility(View.VISIBLE);
            textDesc.setText(R.string.description);

            ViewAnimationUtils.createCircularReveal(textDesc, centerX, centerY, 0, radius).start();
        } else {
            Animator reveal = ViewAnimationUtils.createCircularReveal(textDesc, centerX, centerY, radius, 0);
            reveal.addListener(new AnimatorListenerAdapter(){
                public void onAnimationEnd(Animator animation) {
                    textDesc.setVisibility(View.INVISIBLE);
                }
            });
            reveal.start();
        }
    }
}
