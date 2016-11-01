package com.pinyin.cbl.pinyinsearch;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.SlidingDrawer;

import com.pinyin.cbl.pinyinadapter.SearchAdapter;

public class QuickSearchActivity extends Activity {
	private static final String tag = "QuickSearchActivity";
	private AutoCompleteTextView search;
	private SlidingDrawer mDrawer;

	public SearchAdapter adapter = null;//
	// 需要读取
	public String[] hanzi = new String[] {"hhhhh","ggggg","长江证券100002", "长江证券100001",
			"农业银行200001", "工商银行300001", "招商银行100001", "建设银行100001",
			"中国银行100002", "华夏银行500002", "上海银行100010", "浦发银行200009"
			};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initViews();
	}

	private void initViews() {
		search = (AutoCompleteTextView) findViewById(R.id.search);
		search.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// TODO Auto-generated method stub
				Log.d(tag, "onItemClick:" + position);
			}

		});

		search.setThreshold(1);

		adapter = new SearchAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, hanzi,
				SearchAdapter.ALL);//速度优先  
		search.setAdapter(adapter);//

//		mDrawer = (SlidingDrawer) findViewById(R.id.slidingdrawer);

	}

}