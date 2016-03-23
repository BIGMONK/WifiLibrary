需要权限
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />


使用方法：

第一步，在Application的onCreate方法中进行初始化
WifiLibInitializer.init(this);

第二步，设置wifi相关的事件监听器
WifiLib.getInstance().setOnWifiBroadcastReceiveCallback(OnWifiBroadcastReceiveCallback cbk);

第四步，调用相关方法进行wifi操作
WifiLib.getInstance().openWifi() //打开wifi
WifiLib.getInstance().closeWifi() //打开wifi
WifiLib.getInstance().startScan(long periodMillis) //开始扫描wifi热点,扫描结果在第二步的回调中获取
WifiLib.getInstance().stopScan() //停止热点扫描
WifiLib.getInstance().createAccessPoint(int apType, String ssid, String password) //创建wifi热点
WifiLib.getInstance().connectToAccessPoint(AccessPoint accessPoint, String password)//连接wifi热点
WifiLib.getInstance().closeWifiAp();//关闭wifi热点
WifiLib.getInstance().realse();//释放资源
