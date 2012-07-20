package ss.test;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;

public class CopyTextTest2Activity extends Activity{

	private MyListAdapter myAdapter;
	private ListView lv;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout ll = new LinearLayout(this);
		lv = new ListView(this);
		
		String itemText;

		ArrayList<String> stringList = new ArrayList();
		for (int i = 0; i < 10; i++) {
			itemText = "" + i + "  sdfsfjskldfhsklhskdfsdhf"
					+ "fsdfaskhfkshdfkskdfskldf"
					+ "dfskdfhkshdfkshdkiuiouweoruweoruwoeruwoer"
					+ "opkspdfmmbb" +"dsfasdfsdfsdfsdferwre";
			stringList.add(itemText);
		}

		myAdapter = new MyListAdapter(this, stringList);
		lv.setAdapter(myAdapter);
		lv.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);

		ll.addView(lv, LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		// lv.setEnabled(false);
		setContentView(ll);

	}
}