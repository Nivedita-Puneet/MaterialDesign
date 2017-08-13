package materialdesign.nivedita.com.materialdesign;

import android.app.ActivityOptions;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button rippleEffect;
    private ImageView imgLogo, imgProfilePic;
    private TextView txvShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rippleEffect = (Button)findViewById(R.id.ripple_effect);
        rippleEffect.setOnClickListener(new ButtonClickListener());

        imgLogo = (ImageView) findViewById(R.id.imgSmartherdLogo);
        imgProfilePic = (ImageView) findViewById(R.id.imgAnnie);
        txvShared = (TextView) findViewById(R.id.txvSharedElement);

    }

    private class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view){

            switch (view.getId()){

                case R.id.ripple_effect:
                     startActivity(new Intent(MainActivity.this, RippleActivity.class));
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

}
