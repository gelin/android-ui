package ru.gelin.android.example.contextaction;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class ContextActionActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(new PonyListAdapter());
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new PonyMultiChoiceModeListener());
    }

    private class PonyMultiChoiceModeListener implements AbsListView.MultiChoiceModeListener {

        String name;

        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
            if (checked) {
                name = getResources().getStringArray(R.array.pony_names)[position];
            }
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.contextmenu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Toast.makeText(ContextActionActivity.this, name + " is " + item.getTitle(), Toast.LENGTH_LONG).show();
            mode.finish();
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
        }

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
