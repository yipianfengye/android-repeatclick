package sample.repeatclick.com.android_repeatclick;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import sample.repeatclick.com.library.OnClickCostomListener;
import sample.repeatclick.com.library.OnClickFastListener;
import sample.repeatclick.com.library.OnClickLoginedListener;
import sample.repeatclick.com.library.OnClickNetworkListener;

/**
 * 测试重复点击,网络拦截,是否登录等操作
 */
public class MainActivity extends AppCompatActivity {

    public Activity mContext = null;
    /**
     * 测试快速点击按钮
     */
    @InjectView(R.id.main_fastbutton)
    public Button fastButton;

    /**
     * 测试网络点击按钮
     */
    @InjectView(R.id.main_networkbutton)
    public Button networkButton;

    /**
     * 测试登录点击按钮
     */
    @InjectView(R.id.main_loginbutton)
    public Button loginButton;

    /**
     * 测试定制化点击按钮
     */
    @InjectView(R.id.main_costombutton)
    public Button costomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        mContext = this;
        initListener();
    }


    /**
     * 初始化按钮点击事件
     */
    private void initListener() {

        /**
         * 测试快速点击事件
         */
        fastButton.setOnClickListener(new OnClickFastListener() {
            @Override
            public void onFastClick(View v) {
                Toast.makeText(mContext, "您点击了测试网络按钮...", Toast.LENGTH_LONG).show();
            }
        });

        /**
         * 测试网络状况
         */
        networkButton.setOnClickListener(new OnClickNetworkListener() {
            @Override
            public void onNetworkClick(View v) {
                Toast.makeText(mContext, "当前设备有网络,执行后续操作...", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNoNetworkClick(View v) {
                Toast.makeText(mContext, "当前设备没有网络...", Toast.LENGTH_LONG).show();
            }
        });

        /**
         * 测试是否登陆
         */
        loginButton.setOnClickListener(new OnClickLoginedListener(mContext) {
            @Override
            public boolean isLogined(Activity context, View view) {
                return false;
            }

            @Override
            public void onLoginedClick(View v) {
                Toast.makeText(mContext, "设备已登录,之后后续操作...", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNoLoginedClick(View v) {
                Toast.makeText(mContext, "设备未登陆,无法执行后续操作...", Toast.LENGTH_LONG).show();
            }
        });


        /**
         * 定制化判断逻辑
         */
        costomButton.setOnClickListener(new OnClickCostomListener() {
            @Override
            public boolean isCorrect() {
                return false;
            }

            @Override
            public void onCorrentClick(View v) {
                Toast.makeText(mContext, "判断通过,执行后续操作...", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNoCorrentClick(View v) {
                Toast.makeText(mContext, "判断未通过,无法执行后续操作...", Toast.LENGTH_LONG).show();
            }
        });
    }
}
