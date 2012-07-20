package ss.test;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;

public class CopyTextTest2Activity extends Activity implements OnTouchListener{

	private MyListAdapter myAdapter;
	private ListView lv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		lv = new ListView(this);
		lv.setOnTouchListener(this);
		
		String values;

		ArrayList<String> stringList = new ArrayList();
		for (int i = 0; i < 10; i++) {
			values = "" + i + "  sdfsfjskldfhsklhskdfsdhf"
					+ "fsdfaskhfkshdfkskdfskldf"
					+ "dfskdfhkshdfkshdkiuiouweoruweoruwoeruwoer"
					+ "opkspdfmmbb" +"dsfasdfsdfsdfsdferwre";
			stringList.add(values);
		}

		myAdapter = new MyListAdapter(this, stringList);
		lv.setAdapter(myAdapter);
		lv.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);

		ll.addView(lv, LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		// lv.setEnabled(false);
		setContentView(ll);

	}

//	@Override
//	public boolean dispatchTouchEvent(MotionEvent ev) {
//		if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//			onUserInteraction();
//		}
//		if (lv != null) {
//			return lv.dispatchTouchEvent(ev);
//		} else {
//			if (getWindow().superDispatchTouchEvent(ev)) {
//				return true;
//			}
//			return onTouchEvent(ev);
//		}
//
//	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (v!=null && v==lv && v.dispatchTouchEvent(event)) {
//			v.dispatch
			return true;
		}
		return false;
	}
}