package com.example.recycleviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends Activity{
	private RecyclerView mRecyclerView;
    private RecyclerView.Adapter<RecycleAdapter.ViewHolder> mAdapter;
    private LayoutManager mLayoutManager;
    ArrayList<String> list=new ArrayList<String>();
    
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		prepareList();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // improve performance if you know that changes in content
        // do not change the size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
         
        // use a linear layout manager
        mLayoutManager = new LayoutManager(this);
        // Set list orientation  
        mLayoutManager.setOrientation(LayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

		// specify an adapter (see also next example)
        mAdapter = new RecycleAdapter(this,list);
        mAdapter.setHasStableIds(true);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(int newState) {
            	((RecycleAdapter) mAdapter).updateBounds(mRecyclerView);
            }

            @Override
            public void onScrolled(int dx, int dy) {
            	((RecycleAdapter) mAdapter).updateBounds(mRecyclerView);
            }
        });
	}
	
	public void prepareList(){
		list.add(list.size()+". ----------");
		list.add(list.size()+". ----------");
		list.add(list.size()+". Abbaye de Belloc");
		list.add(list.size()+". Abbaye du Mont des Cats");
		list.add(list.size()+". Abertam");
		list.add(list.size()+". ----------");
		list.add(list.size()+". Abondance");
		list.add(list.size()+". ----------");
		list.add(list.size()+". Ackawi");
		list.add(list.size()+". Acorn");
		list.add(list.size()+". Adelost");
		list.add(list.size()+". Affidelice au Chablis");
		list.add(list.size()+". Afuega'l Pitu");
		list.add(list.size()+". Airag");
		list.add(list.size()+". ----------");
		list.add(list.size()+". Airedale");
		list.add(list.size()+". Aisy Cendre");
		list.add(list.size()+". ----------");
		list.add(list.size()+". Allgauer Emmentaler");
		list.add(list.size()+". ----------");
		list.add(list.size()+". Alverca");
		list.add(list.size()+". Ambert");
		list.add(list.size()+". American Cheese");
		list.add(list.size()+". Ami du Chambertin");
		list.add(list.size()+". ----------");
		list.add(list.size()+". ----------");
		list.add(list.size()+". Anejo Enchilado");
		list.add(list.size()+". Anneau du Vic-Bilh");
		list.add(list.size()+". ----------");
		
	}
	
	public void addItems(){
		list.add(list.size()+". ----------");
		list.add(list.size()+". ----------");
		list.add(list.size()+". Henry IV (1)");
		list.add(list.size()+". Henry V");
		list.add(list.size()+". Henry VIII");
		list.add(list.size()+". ----------");
		list.add(list.size()+". Richard II");
		list.add(list.size()+". Richard III");
		list.add(list.size()+". Merchant of Venice");
		list.add(list.size()+". Othello");
		list.add(list.size()+". King Lear");
		mAdapter.notifyDataSetChanged();
		Toast.makeText(MainActivity.this, "new item added", Toast.LENGTH_LONG).show();
	}
}
