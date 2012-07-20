package ss.test;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.widget.EditText;

public class MyEditText extends EditText {

	public MyEditText(Context context) {
		super(context);
		initialize();
	}

	public MyEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize();
	}

	public MyEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}

	private void initialize() {
		setBackgroundColor(Color.WHITE);
	}

	@Override
	protected void onCreateContextMenu(ContextMenu menu) {
		// avoid to pop out the context menu
	}

	@Override
	public boolean getDefaultEditable() {
		return false;
	}

	private int offset;

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		Layout layout = getLayout();
		int line = 0;
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			line = layout.getLineForVertical(getScrollY() + (int) event.getY());
			offset = layout.getOffsetForHorizontal(line, (int) event.getX());
			Selection.setSelection(getEditableText(), offset);
			break;
		case MotionEvent.ACTION_MOVE:
		case MotionEvent.ACTION_UP:
			line = layout.getLineForVertical(getScrollY() + (int) event.getY());
			int curOff = layout
					.getOffsetForHorizontal(line, (int) event.getX());
			Selection.setSelection(getEditableText(), offset, curOff);
			break;
		}
		return true;
	}

}