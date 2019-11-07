package com.ceng319.listviewdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

// TODO 2: Define a List as ArrayList Collection Finished
    private RecyclerView recyclerView;
    private DataAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SampleData mSampleData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        processDataAdapter();

    }

    private void processDataAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        // Pass the data list to the adapter
        mAdapter = new DataAdapter(SampleData.dataItemList);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        enableSwipeToDeleteAndUndo();
        // TODO 5: set the listView click event. Finished
      /*  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MapleLeaf", Integer.toString(position));
                // Use intent to pass the activity and position of the click.
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("position", Integer.toString(position));
                startActivity(intent);
            }
        });*/
    }

    private void enableSwipeToDeleteAndUndo() {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                final int position = viewHolder.getAdapterPosition();
                final DataItem item = mAdapter.getData().get(position);
                ShowDialogBox(item, position);
            }
        };
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(recyclerView);
    }

    private void removeItem(DataItem item , int position) {
        final DataItem item_to_delete = item;
        final int position_to_delete = position;
        mAdapter.removeItem(position);
        Snackbar snackbar = Snackbar.make(findViewById(R.id.main_activity_layout),
                "Item was removed from the list.", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mAdapter.restoreItem(item_to_delete, position_to_delete);
                        recyclerView.scrollToPosition(position_to_delete);
                    }
                });
        snackbar.setActionTextColor(Color.YELLOW);
        snackbar.show();
    }

    private void ShowDialogBox(DataItem item, int position){
        final DataItem item_to_delete = item;
        final int position_to_delete = position;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure to delete this item?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Delete the item.
                removeItem(item_to_delete, position_to_delete);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Reset the recyclerView
                recyclerView.setAdapter(null);
                recyclerView.setLayoutManager(null);
                processDataAdapter();
                recyclerView.scrollToPosition(position_to_delete);
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
