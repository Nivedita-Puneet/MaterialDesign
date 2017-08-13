package materialdesign.nivedita.com.materialdesign;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by PUNEETU on 10-08-2017.
 */

public class RippleActivity extends AppCompatActivity implements View.OnClickListener {

    TextView ripple, ripple_noBorder, customRipple, customRipple_noBorder;


    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ripple_activity);

        getSupportActionBar().setTitle(R.string.ripple_effects);
        ripple = (TextView)findViewById(R.id.bordered_ripple);
        ripple.setOnClickListener(this);
        ripple_noBorder = (TextView)findViewById(R.id.ripple_no_border);
        ripple_noBorder.setOnClickListener(this);
        customRipple = (TextView)findViewById(R.id.cutom_ripple_border);
        customRipple.setOnClickListener(this);
        customRipple_noBorder = (TextView)findViewById(R.id.ripple_no_border);
        customRipple_noBorder.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.ripple_effect:
                 break;
            case R.id.ripple_no_border:
                 break;
            case R.id.cutom_ripple_border:
                 break;
            case R.id.custom_ripple_no_border:
                 break;
        }
    }
}
