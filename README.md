需要权限
android.permission.ACCESS_WIFI_STATE＜/br＞
android.permission.CHANGE_NETWORK_STATE＜/br＞
android.permission.CHANGE_WIFI_STATE＜/br＞
＜/br＞
＜/br＞
使用方法：＜/br＞

第一步，在Application的onCreate方法中进行初始化＜/br＞
WifiLibInitializer.init(this);＜/br＞
＜/br＞
第二步，设置wifi相关的事件监听器＜/br＞
WifiLib.getInstance().setOnWifiBroadcastReceiveCallback(OnWifiBroadcastReceiveCallback cbk);＜/br＞

第四步，调用相关方法进行wifi操作＜/br＞
WifiLib.getInstance().openWifi() //打开wifi＜/br＞
WifiLib.getInstance().closeWifi() //打开wifi＜/br＞
WifiLib.getInstance().startScan(long periodMillis) //开始扫描wifi热点,扫描结果在第二步的回调中获取＜/br＞
WifiLib.getInstance().stopScan() //停止热点扫描＜/br＞
WifiLib.getInstance().createAccessPoint(int apType, String ssid, String password) //创建wifi热点＜/br＞＜/br＞
WifiLib.getInstance().connectToAccessPoint(AccessPoint accessPoint, String password)//连接wifi热点＜/br＞
WifiLib.getInstance().closeWifiAp();//关闭wifi热点＜/br＞
WifiLib.getInstance().realse();//释放资源＜/br＞
