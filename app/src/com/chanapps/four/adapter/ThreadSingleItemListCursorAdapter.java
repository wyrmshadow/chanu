package com.chanapps.four.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.chanapps.four.activity.R;
import com.chanapps.four.component.ThemeSelector;
import com.chanapps.four.data.ChanPost;
import com.chanapps.four.viewer.ThreadViewHolder;

/**
 * Created with IntelliJ IDEA.
 * User: johnarleyburns
 * Date: 9/8/13
 * Time: 8:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadSingleItemListCursorAdapter extends ThreadListCursorAdapter {

    protected static final String TAG = ThreadSingleItemListCursorAdapter.class.getSimpleName();
    protected static final boolean DEBUG = false;

    protected ThreadSingleItemListCursorAdapter(Context context, int layout, ViewBinder viewBinder, String[] from, int[] to) {
        super(context, layout, viewBinder, from, to);
    }

    public ThreadSingleItemListCursorAdapter(Context context, ViewBinder viewBinder, boolean showContextMenu) {
        super(context, viewBinder, showContextMenu);
    }

    @Override
    protected View newView(ViewGroup parent, int tag, int position) {
        if (DEBUG) Log.d(TAG, "Creating " + tag + " layout for " + position);
        int id = getItemViewLayout(tag);
        ViewGroup v = (ViewGroup)mInflater.inflate(id, parent, false);
        ThreadViewHolder viewHolder = new ThreadViewHolder(v);
        v.setTag(R.id.VIEW_TAG_TYPE, tag);
        v.setTag(R.id.VIEW_HOLDER, viewHolder);
        View inner = v.getChildAt(0);
        if ((tag == TYPE_HEADER || tag == TYPE_IMAGE_ITEM || tag == TYPE_TEXT_ITEM) && inner != null) {
            if (DEBUG) Log.i(TAG, "setting background to null inner=" + inner);
            int bg = ThemeSelector.instance(parent.getContext()).isDark()
                    ? R.color.PaletteDarkCardBg
                    : R.color.PaletteCardBg;
            inner.setBackgroundResource(bg);
        }
        return v;
    }

}