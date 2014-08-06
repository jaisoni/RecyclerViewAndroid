package com.example.recycleviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder>{
	private ArrayList<String> mDataset;
	private Activity mContext;

	// Provide a reference to the type of views that you are using
	// (custom viewholder)
	public static class ViewHolder extends RecyclerView.ViewHolder {
		public TextView mTextView;
		public ViewHolder(View v) {
			super(v);
			mTextView =(TextView) v.findViewById(R.id.textView);
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public RecycleAdapter(Activity context,ArrayList<String> myDataset) {
		mContext=context;
		mDataset = myDataset;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
		// create a new view
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.recycle_item, parent, false);

		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		holder.mTextView.setText(mDataset.get(position));
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mDataset.size();
	}

	@Override
	public long getItemId(int position) {
		return position; // I use the position as id
	}

	public void updateBounds(RecyclerView recycler) {
		// get the bottom of the screen
		int bottom = mContext.getResources().getDisplayMetrics().widthPixels;
		for(int i = 0; i < recycler.getChildCount(); i++) {
			Rect r = new Rect();
			View child = recycler.getChildAt(i);
			if(child.getGlobalVisibleRect(r)) {
				if(r.left <= bottom && bottom <= r.right) {
					int pos = (int)recycler.getChildItemId(child);
					if(pos > RecyclerView.NO_POSITION ) {
						//System.out.println("element at the position 'pos' "+pos);
						if(pos==mDataset.size()-1){
							System.out.println("*** need to load data ***");
							((MainActivity)mContext).addItems();
						}
					}
				}
			}
		}
	}
}
