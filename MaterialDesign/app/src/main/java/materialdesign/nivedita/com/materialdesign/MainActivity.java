package materialdesign.nivedita.com.materialdesign;

import android.app.ActivityOptions;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button rippleEffect, explode,explodeByXML, slideByJava, slideXML, fadeUp, fadeXML;
    private ImageView imgLogo, imgProfilePic;
    private TextView txvShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rippleEffect = (Button)findViewById(R.id.ripple_effect);
        rippleEffect.setOnClickListener(new ButtonClickListener());

        explode = (Button)findViewById(R.id.explodeTransitionByCode);
        explode.setOnClickListener(new ButtonClickListener());

        explodeByXML = (Button)findViewById(R.id.explodeTransitionByXML);
        explodeByXML.setOnClickListener(new ButtonClickListener());

        slideByJava = (Button)findViewById(R.id. slideTransitionByCode);
        slideByJava.setOnClickListener(new ButtonClickListener());

        slideXML = (Button)findViewById(R.id.slideTransitionByXML);
        slideXML.setOnClickListener(new ButtonClickListener());

        fadeUp = (Button)findViewById(R.id.fadeTransitionByCode);
        fadeUp.setOnClickListener(new ButtonClickListener());

        fadeXML = (Button)findViewById(R.id.fadeTransitionByXML);
        fadeXML.setOnClickListener(new ButtonClickListener());

        imgLogo = (ImageView) findViewById(R.id.imgSmartherdLogo);
        imgProfilePic = (ImageView) findViewById(R.id.imgAnnie);
        txvShared = (TextView) findViewById(R.id.txvSharedElement);

        setUpWindowAnimations();

    }

    private void setUpWindowAnimations(){

        // Re-enter transition is executed when returning back to this activity
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT); // Use START if using right - to - left locale
        slideTransition.setDuration(1000);

        getWindow().setReenterTransition(slideTransition);  // When MainActivity Re-enter the Screen
        getWindow().setExitTransition(slideTransition);     // When MainActivity Exits the Screen

        // For overlap of Re Entering Activity - MainActivity.java and Exiting TransitionActivity.java
        getWindow().setAllowReturnTransitionOverlap(false);

    }
    private class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view){

            switch (view.getId()){

                case R.id.ripple_effect:
                     startActivity(new Intent(MainActivity.this, RippleActivity.class));
                     break;
                case R.id.explodeTransitionByCode:
                     explodeTransitionByCode();
                     break;
                case R.id.explodeTransitionByXML:
                     explodeTransitionByXML();
                     break;
                case R.id.slideTransitionByCode:
                     slideTransitionByCode();
                     break;
                case R.id.slideTransitionByXML:
                     slideTransitionByXML();
                     break;
                case R.id.fadeTransitionByCode:
                     fadeTransitionByJava();
                     break;
                case R.id.fadeTransitionByXML:
                     fadeTransitionByXML();
                     break;



            }
        }
    }

    /*Implementing android shared element transition*/
    public void sharedElementTransition(View view) {

        Pair[] pair = new Pair[3];
        pair[0] = new Pair<View, String>(imgLogo, "logo_shared");
        pair[1] = new Pair<View, String>(txvShared, "smartherd_shared");
        pair[2] = new Pair<View, String>(imgProfilePic, "profile_pic_shared");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent i = new Intent(MainActivity.this, SharedElementActivity.class);
        startActivity(i, options.toBundle());
    }

    public void explodeTransitionByCode() {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeJava);
        i.putExtra(Constants.KEY_TITLE, "Explode By Java");
        startActivity(i, options.toBundle());

    }

    public void explodeTransitionByXML() {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeXML);
        i.putExtra(Constants.KEY_TITLE, "Explode By Xml");
        startActivity(i, options.toBundle());

    }

    public void slideTransitionByCode() {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideJava);
        i.putExtra(Constants.KEY_TITLE, "Slide By Java Code");
        startActivity(i, options.toBundle());
    }

    public void slideTransitionByXML() {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideXML);
        i.putExtra(Constants.KEY_TITLE, "Slide By XML");
        startActivity(i, options.toBundle());
    }

    public void fadeTransitionByJava() {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeJava);
        i.putExtra(Constants.KEY_TITLE, "Fade By Java");
        startActivity(i, options.toBundle());

    }

    public void fadeTransitionByXML() {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, TransitionActivity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.FadeXML);
        i.putExtra(Constants.KEY_TITLE, "Fade By XML");
        startActivity(i, options.toBundle());

    }
}
