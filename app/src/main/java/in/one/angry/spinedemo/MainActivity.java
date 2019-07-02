package in.one.angry.spinedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView wheel;
    // We create a Random instance to make our wheel spin randomly
    private static final Random RANDOM = new Random();
    private int degree = 0, degreeOld = 0;
    // We have 37 sectors on the wheel, we divide 360 by this value to have angle for each sector
    // we divide by 2 to have a half sector
    //private static final float HALF_SECTOR = 360f / 37f / 2f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUI();
    }

    private void setUpUI() {
        Toast.makeText(this, "click to spin", Toast.LENGTH_SHORT).show();
        wheel=findViewById(R.id.spinner);
        wheel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.spinner:{
                degreeOld = degree % 360;
                // we calculate random angle for rotation of our wheel
                degree = RANDOM.nextInt(360) + 1080;
                // rotation effect on the center of the wheel
                RotateAnimation rotateAnim = new RotateAnimation(degreeOld, degree,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotateAnim.setDuration(3600);
                rotateAnim.setFillAfter(true);
                rotateAnim.setInterpolator(new DecelerateInterpolator());
                rotateAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // clear previous text
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //set new text
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        //do nothing
                    }
                });
                // we start the animation
                wheel.startAnimation(rotateAnim);
                break;
            }
        }
    }
}
