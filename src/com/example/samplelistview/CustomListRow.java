package com.example.samplelistview;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomListRow extends RelativeLayout{
	private Context context;
	
	private ImageView imageView;
	private TextView corpInfo;
	private TextView corpInfo1;

	public CustomListRow(Context context) {
		super(context);
		this.context = context;
//		createView();
	}
	
	private void createView(){
		imageView = new ImageView(context);
		corpInfo  = new TextView(context);
		corpInfo1 = new TextView(context);
		corpInfo.setId(1);
	}
	
	public CustomListRow createViewXML(){
		LayoutInflater inflate = (LayoutInflater)
		        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflate.inflate(R.layout.listrow, this, true);
		return (CustomListRow)view;
	}
	
	/**
	 * ビューの初期化
	 * @param position listの位置
	 */
	public void init(int position){
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.BELOW, 1);
		addView(imageView);
		addView(corpInfo);
		addView(corpInfo1, params);
		viewUpdate(position);
	}
	
	/**
	 * ビューの更新処理
	 * @param position
	 */
	public void viewUpdate(int position){
		if(position == 0){
			setLineZeroView();
		}else if((position % 2) == 0){
			setLineOddView();
		}else if((position % 2) == 1){
			setLineEvenView();
		}
	}
	
	/**
	 * ０番目のviewの設定
	 */
	private void setLineZeroView(){
		this.setGravity(Gravity.LEFT);
	}
	
	/**
	 * 奇数番のviewの設定
	 */
	private void setLineEvenView(){
		this.setGravity(Gravity.RIGHT);
	}
	
	/**
	 * 偶数番のviewの設定
	 */
	private void setLineOddView(){
		this.setGravity(Gravity.LEFT);
	}
	
	/**
	 * 
	 * @param text
	 */
	public void setText(String text){
		TextView tv = (TextView)findViewById(R.id.corpInfo);
		tv.setText(text);
	}
}
