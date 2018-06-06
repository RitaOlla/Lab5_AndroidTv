package com.example.rita_ola.tvphotogallery;

import android.support.v17.leanback.widget.HeaderItem;


public class IconHeaderItem extends HeaderItem {
    public static final int ICON_NONE = -1;
    private int mIconResId = ICON_NONE;

    public IconHeaderItem(long id, String name, int iconResId) {
        super(id, name);
        mIconResId = iconResId;
    }

    public int getIconResId() {
        return mIconResId;
    }

}
