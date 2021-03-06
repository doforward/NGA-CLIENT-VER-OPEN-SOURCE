package sp.phone.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import sp.phone.fragment.BoardCategoryFragment;
import sp.phone.interfaces.PageCategoryOwner;

public class BoardPagerAdapter extends FragmentStatePagerAdapter {

    private final int mWidthPercentage;

    private PageCategoryOwner mPageCategoryOwner;

    public BoardPagerAdapter(FragmentManager fm, PageCategoryOwner pageCategoryOwner, int width) {
        super(fm);
        mPageCategoryOwner = pageCategoryOwner;
        mWidthPercentage = width;

    }

    @Override
    public Fragment getItem(int index) {
        return BoardCategoryFragment.newInstance(mPageCategoryOwner.getCategory(index));
    }

    @Override
    public int getCount() {

        return mPageCategoryOwner.getCategoryCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPageCategoryOwner.getCategoryName(position);
    }

    @Override
    public float getPageWidth(int position) {
        return mWidthPercentage / 100.0f;
    }


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
