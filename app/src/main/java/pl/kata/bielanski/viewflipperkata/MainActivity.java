package pl.kata.bielanski.viewflipperkata;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewFlipper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

	@Bind(R.id.viewFlipper)
	ViewFlipper viewFlipper;

	private GestureDetectorCompat gestureDetectorCompat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		gestureDetectorCompat = new GestureDetectorCompat(this, new DepartureGestureListener());
		viewFlipper.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetectorCompat.onTouchEvent(event);
			}
		});
	}

	private class DepartureGestureListener extends GestureDetector.SimpleOnGestureListener {

		public static final int MIN_DISTANCE = 30;
		public static final int MIN_VELOCITY = 10;

		@Override
		public boolean onDown(MotionEvent e) {
			return true;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			if(isSlideLeft(e1, e2, velocityX))
				return animateLeft();
			else if (isSlideRight(e1, e2, velocityX))
				return animateRight();

			return false;
		}

		private boolean isSlideRight(MotionEvent e1, MotionEvent e2, float velocityX) {
			return e2.getX() - e1.getX() > MIN_DISTANCE && Math.abs(velocityX)> MIN_VELOCITY;
		}

		private boolean isSlideLeft(MotionEvent e1, MotionEvent e2, float velocityX) {
			return e1.getX() - e2.getX() > MIN_DISTANCE && Math.abs(velocityX)> MIN_VELOCITY;
		}
	}

	private boolean animateRight() {
		return false;
	}


	private boolean animateLeft() {
		return false;
	}
}
