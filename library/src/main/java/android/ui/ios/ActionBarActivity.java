package android.ui.ios;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jay on 2017/3/9 下午11:11
 * 1.设置自定义View替换原标题View，用于显示原标题View的文本
 * 2.处理返回按钮点击事件
 */

class ActionBarActivity extends AppCompatActivity {

    private ActionBar mSupportActionBar;
    private TextView mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
    }

    private void setupActionBar() {
        mSupportActionBar = getSupportActionBar();
        if(isSettingNavigationBarCustomView())return;
        mSupportActionBar.setCustomView(R.layout.ios_action_bar_title);
        mTitle = (TextView) findViewById(android.R.id.title);
    }

    /**
     * 是否设置导航栏(ActionBar)自定View
     * @return 结果为true，则不会显示标题栏，标题栏原有位置将显示{@link #setNavigationBarCustomView(int)}
     * 方法设置的视图
     */
    protected boolean isSettingNavigationBarCustomView() {
        return false;
    }

    /**
     * 设置导航栏(ActionBar)自定View视图
     * @param resId 自定义视图资源id
     */
    protected void setNavigationBarCustomView(@LayoutRes int resId) {
        mSupportActionBar.setCustomView(resId);
    }

    /**
     * @return {@link #setNavigationBarCustomView(int)}设置的视图View
     */
    protected View getNavigationBarCustomView() {
        return mSupportActionBar.getCustomView();
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (!isSettingNavigationBarCustomView()){
            mTitle.setText(title);
            if (color != 0)mTitle.setTextColor(color);
        }
    }

    /**
     * 处理ActionBar返回按钮事件，回调{@link #onBackPressed()}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
