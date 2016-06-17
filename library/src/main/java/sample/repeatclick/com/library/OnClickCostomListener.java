package sample.repeatclick.com.library;

import android.view.View;

/**
 * Created by liuchao on 2015/9/2.
 * 通用自定义View处理点击事件
 */
public abstract class OnClickCostomListener extends BaseClickListener {

    @Override
    public void onClick(View view) {
        super.onClick(view);

        if (isCorrect()) {
            onCorrentClick(view);
        } else {
            onNoCorrentClick(view);
        }
    }

    /**
     * 判断是否逻辑通过
     * @return
     */
    public abstract boolean isCorrect();

    /**
     * 判断正确之后执行的逻辑请求
     * @param v
     */
    public abstract void onCorrentClick(View v);

    /**
     * 判断失败之后执行的逻辑请求
     * @param v
     */
    public abstract void onNoCorrentClick(View v);
}
