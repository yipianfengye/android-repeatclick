# android-repeatclick
android组件点击事件，防止重复点击，判断是否有网络，判断是否登录，点击事件执行之前定制化执行逻辑...
<img src="https://github.com/yipianfengye/android-repeatclick/blob/master/images/test.gif" width="360dp" height="600dp">


###使用方式

- 屏蔽多次点击事件
<pre><code>
/**
         * 测试快速点击事件
         */
        fastButton.setOnClickListener(new OnClickFastListener() {
            @Override
            public void onFastClick(View v) {
                Toast.makeText(mContext, "您点击了测试网络按钮...", Toast.LENGTH_LONG).show();
            }
        });
</code></pre>
这里默认的屏蔽多次点击事件的时间间隔为900ms，也就是说第二次点击时若距离第一次点击事件小于0.9s，则第二次点击不起作用；

- 屏蔽网络情况
<pre><code>
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
</code></pre>
其中onNetworkClick方法用于执行当前设备有网的情况，其中onNoNetworkClick方法用于处理当前设备没有网络的后续操作；

- 屏蔽是否登录情况
<pre><code>
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
</code></pre>
其中方法isLogined用于判断当前用户是否登录，方法onLoginedClick用于执行登录之后的逻辑，方法onNoLoginedClick用于执行用户尚未登录的逻辑
