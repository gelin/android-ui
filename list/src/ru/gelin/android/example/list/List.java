package ru.gelin.android.example.list;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class List extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(new PonyListAdapter());
    }

    private class PonyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return getResources().getStringArray(R.array.pony_names).length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = createView(viewGroup);
            }
            bindView(view, i);
            return view;
        }

        View createView(ViewGroup viewGroup) {
            return getLayoutInflater().inflate(R.layout.person, viewGroup, false);
        }

        void bindView(View view, int i) {
            String[] names = getResources().getStringArray(R.array.pony_names);
            TextView name = (TextView)view.findViewById(R.id.name);
            name.setText(names[i]);
            TypedArray photos = getResources().obtainTypedArray(R.array.pony_photos);
            ImageView photo = (ImageView)view.findViewById(R.id.photo);
            photo.setImageDrawable(photos.getDrawable(i));
        }

    }

}
