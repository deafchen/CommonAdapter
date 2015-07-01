package com.xhb.edsq.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommonAdapter<T> extends BaseAdapter {
	
	private Context mContext;
	private List<T> mDatas;
	private int mItemLayoutId;
	
	public CommonAdapter(Context context, List<T> datas, int itemLayoutId) {
		mContext = context;
		mDatas = datas;
		mItemLayoutId = itemLayoutId;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public T getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = ViewHolder.get(mContext, convertView, parent, mItemLayoutId);
		convert(viewHolder, mDatas.get(position), position);
		return viewHolder.getConvertView();
	}
	
	public void add(T t) {
		mDatas.add(t);
		notifyDataSetChanged();
	}
	
	public void addAll(List<T> list) {
		mDatas.addAll(list);
		notifyDataSetChanged();
	}
	
	public void clear() {
		mDatas.clear();
		notifyDataSetChanged();
	}
	
	public void remove(T t) {
		mDatas.remove(t);
		notifyDataSetChanged();
	}
	
	public abstract void convert(ViewHolder viewHolder, T t, int position);

}
