package com.example.samplelistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		List<String> list = setList();
		ListView listview = (ListView)findViewById(R.id.listview);
		CustomAdapter<String> adapter = new CustomAdapter<String>(MainActivity.this, -1);
		adapter.setList(list);
		listview.setAdapter(adapter);
	}
	
	private List setList(){
		List<String> list = new ArrayList<String>();
		list.add("line1");
		list.add("line2");
		list.add("line3");
		list.add("line4");
		list.add("line1");
		list.add("line2");
		list.add("line3");
		list.add("line4");
		list.add("line1");
		list.add("line2");
		list.add("line3");
		list.add("line4");
		list.add("line1");
		list.add("line2");
		list.add("line3");
		list.add("line4");
		list.add("line1");
		list.add("line2");
		list.add("line3");
		list.add("line4");
		list.add("line1");
		list.add("line2");
		list.add("line3");
		list.add("line4");
		list.add("line1");
		list.add("line2");
		list.add("line3");
		list.add("line4");
		list.add("line1");
		list.add("line2");
		list.add("line3");
		list.add("line4");
		list.add("line1");
		list.add("line2");
		list.add("line3");
		list.add("line4");
		list.add("line1");
		list.add("line2");
		list.add("line3");
		list.add("line4");
		return list;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public class CustomAdapter<T> extends ArrayAdapter<T>{
		private Context mContext;
		private List<T> mList;

		public CustomAdapter(Context context, int textViewResourceId) {
			super(context, textViewResourceId);
			mContext = context;
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if(convertView == null){
				holder = new ViewHolder();
				CustomListRow listRow = new CustomListRow(MainActivity.this);
				listRow.init(position);
				
				holder.listRowView = listRow;
				convertView = listRow;
				convertView.setTag(holder);
			}else{
				holder = (ViewHolder)convertView.getTag();
			}
			holder.listRowView.setText((String)getItem(position));
			holder.listRowView.viewUpdate(position);
			return convertView;
		}
		
		@Override
		public T getItem(int position) {
			return mList.get(position);
		}
		
		@Override
		public int getCount() {
			if(mList.size() == 0) return 0;
			return mList.size();
		}
		
		private void setList(List list){
			mList = list;
		}
		
		
	}
	
	static class ViewHolder{
		CustomListRow listRowView;
	}

}
