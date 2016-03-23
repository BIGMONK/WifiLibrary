package com.cy.demo.wifi;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.cy.lib.wifi.AccessPoint;
import com.cy.lib.wifi.WifiApManager;
import com.cy.lib.wifi.WifiBroadcastReceiver.OnWifiBroadcastReceiveCallback;
import com.cy.lib.wifi.WifiLib;
import com.cy.lib.wifi.WifiLibInitializer;
import com.cy.lib.wifi.WifiUtils;
import com.example.netextenddemo.R;

public class MainActivity extends Activity implements OnClickListener {
	private Button btOpenWifi;
	private Button btCloseWifi;
	private Button btStartScan;
	private Button btStopScan;
	private Button btCreateAp;
	private Button btCloseAp;
	private Button btConnect;
	private WifiLib wifiLib;
	private String connectSsid = "hcy";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btOpenWifi = (Button) findViewById(R.id.btOpenWifi);
		btCloseWifi = (Button) findViewById(R.id.btCloseWifi);
		btStartScan = (Button) findViewById(R.id.btStartScan);
		btStopScan = (Button) findViewById(R.id.btStopScan);
		btCreateAp = (Button) findViewById(R.id.btCreateAp);
		btCloseAp = (Button) findViewById(R.id.btCloseAp);
		btConnect = (Button) findViewById(R.id.btConnect);
		btOpenWifi.setOnClickListener(this);
		btCloseWifi.setOnClickListener(this);
		btStartScan.setOnClickListener(this);
		btStopScan.setOnClickListener(this);
		btCreateAp.setOnClickListener(this);
		btCloseAp.setOnClickListener(this);
		btConnect.setOnClickListener(this);
		WifiLibInitializer.init(this);
		wifiLib = WifiLib.getInstance();
		wifiLib.setOnWifiBroadcastReceiveCallback(callback);

	}

	private OnWifiBroadcastReceiveCallback callback = new OnWifiBroadcastReceiveCallback() {
		public void onScanResultsAvailable(
				java.util.List<AccessPoint> accessPoints) {
			WifiUtils.printAccessPoints(accessPoints);
			for (int i = 0; i < accessPoints.size(); i++) {
				AccessPoint ap = accessPoints.get(i);
				if (!TextUtils.isEmpty(connectSsid)
						&& ap.getSsid().equals(connectSsid)) {
					boolean isSuccess = wifiLib.connectToAccessPoint(ap,
							"12345678");
					Log.i("HCY", isSuccess ? "连接热点成功" : "连接热点失败");
					wifiLib.stopScan();
				}
			}
		};
	};

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btOpenWifi:
			wifiLib.openWifi();
			break;
		case R.id.btCloseWifi:
			wifiLib.closeWifi();
			break;
		case R.id.btStartScan:
			wifiLib.startScan(1000);
			break;
		case R.id.btStopScan:
			wifiLib.stopScan();
			break;
		case R.id.btCloseAp:
			wifiLib.closeWifiAp();
			break;
		case R.id.btCreateAp:
			wifiLib.createAccessPoint(WifiApManager.WifiApType.TYPE_WPA_PSK,
					"money888", "12345678");
			break;
		case R.id.btConnect:
			connectSsid = "hcy";
			Log.i("HCY", "wifi 连接中...");
			break;
		}
	}
}
