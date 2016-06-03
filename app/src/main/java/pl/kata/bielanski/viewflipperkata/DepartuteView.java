package pl.kata.bielanski.viewflipperkata;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

public class DepartuteView extends TextView {

	public static final int TEXT_SIZE = 90;

	public DepartuteView(Context context, String departure) {
		super(context);
		setText(departure, BufferType.NORMAL);
		setTextSize(TEXT_SIZE);
		setTextColor(Color.parseColor("#FFFFFF"));
		setGravity(Gravity.CENTER);
	}
}
