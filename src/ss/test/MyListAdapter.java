package ss.test;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MyListAdapter extends BaseAdapter {

	private ArrayList<String> entitys;
	private Context context;

	public MyListAdapter(Context context, ArrayList<String> entitys) {
		this.context = context;
		this.entitys = entitys;
	}

	@Override
	public int getCount() {
		if (entitys == null)
			return 0;
		return entitys.size();
	}

	@Override
	public Object getItem(int position) {
		if (entitys == null)
			return null;
		return entitys.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		String entity = entitys.get(position);
		MyEditText myTextView = (MyEditText) View.inflate(context,
				R.layout.list_item, null);
		myTextView.setText(entity);
		return myTextView;
	}
	
	public boolean dispatchTouchEvent(MotionEvent ev) {
       
        if (((Activity) context).getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return false;
    }

}
