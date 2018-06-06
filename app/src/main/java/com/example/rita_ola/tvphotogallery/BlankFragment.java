package com.example.rita_ola.tvphotogallery;


import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;


public class BlankFragment extends BrowseFragment {

    private ArrayObjectAdapter mRowsAdapter;
    private static SimpleBackgroundManager simpleBackgroundManager = null;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupUIElements();
        loadRows();
        setupEventListeners();
        simpleBackgroundManager = new SimpleBackgroundManager(getActivity());

    }

    private void setupEventListeners() {
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item,
                                   RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof String) {
                simpleBackgroundManager.clearBackground();
            } else if (item instanceof Picture) {
                simpleBackgroundManager.updateBackground(MainActivity.context.getDrawable(((Picture) item).getImage()));
            }

        }
    }
    private void setupUIElements() {
        setTitle(MainActivity.context.getString(R.string.hello));

        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        setBrandColor(getResources().getColor(R.color.fastlane_background));

        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));

        setHeaderPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object o) {
                return new IconHeaderItemPresenter();
            }
        });
    }


    private void loadRows() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        /* GridItemPresenter */
        IconHeaderItem gridItemPresenterHeader = new IconHeaderItem(0, MainActivity.context.getString(R.string.peppa),R.drawable.pepa);
        IconHeaderItem gridItemPresenterHeader1 = new IconHeaderItem(1, MainActivity.context.getString(R.string.paw),R.drawable.paw);
        IconHeaderItem gridItemPresenterHeader2 = new IconHeaderItem(2, MainActivity.context.getString(R.string.shaun),R.drawable.shaun);

        CardPresenter cardPresenter = new CardPresenter();
        ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);
        ArrayObjectAdapter cardRowAdapter1 = new ArrayObjectAdapter(cardPresenter);
        ArrayObjectAdapter cardRowAdapter2 = new ArrayObjectAdapter(cardPresenter);

        setA(cardRowAdapter);
        setA1(cardRowAdapter1);
        setA2(cardRowAdapter2);


        mRowsAdapter.add(new ListRow(gridItemPresenterHeader, cardRowAdapter));
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader1,cardRowAdapter1));
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader2, cardRowAdapter2));

        /* set */
        setAdapter(mRowsAdapter);
    }

    public void setA(ArrayObjectAdapter a) {
        Picture picture = new Picture( MainActivity.context.getString(R.string.peppa1),R.drawable.pepa1);
        picture.setTitle(picture.getTitle());
        Picture picture1 = new Picture(MainActivity.context.getString(R.string.peppa2),R.drawable.pepa2);
        picture.setTitle(picture1.getTitle());
        Picture picture2 = new Picture(MainActivity.context.getString(R.string.peppa3),R.drawable.pepa3);
        picture.setTitle(picture2.getTitle());
        a.add(picture);
        a.add(picture1);
        a.add(picture2);
    }

    public void setA1(ArrayObjectAdapter a1) {
        Picture picture = new Picture(MainActivity.context.getString(R.string.paw1),R.drawable.paw1);
        picture.setTitle(picture.getTitle());
        Picture picture1 = new Picture(MainActivity.context.getString(R.string.paw2),R.drawable.paw2);
        picture.setTitle(picture1.getTitle());
        Picture picture2 = new Picture(MainActivity.context.getString(R.string.paw3),R.drawable.paw3);
        picture.setTitle(picture2.getTitle());
        a1.add(picture);
        a1.add(picture1);
        a1.add(picture2);
    }
    public void setA2(ArrayObjectAdapter a1) {
        Picture picture = new Picture(MainActivity.context.getString(R.string.shaun1),R.drawable.shaun1);
        picture.setTitle(picture.getTitle());
        Picture picture1 = new Picture(MainActivity.context.getString(R.string.shaun2),R.drawable.shaun2);
        picture.setTitle(picture1.getTitle());
        Picture picture2 = new Picture(MainActivity.context.getString(R.string.shaun3),R.drawable.shaun3);
        picture.setTitle(picture2.getTitle());
        a1.add(picture);
        a1.add(picture1);
        a1.add(picture2);
    }



}
