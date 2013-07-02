package cn.try4.color;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public final class ColorModel {

	public static List<Bundle> colorList = new ArrayList<Bundle>();

	/*
	 * public static final List<Bundle> getColorList() { List<Bundle> colorList
	 * = new ArrayList<Bundle>(); String[] name = new String[] { "ǳ�ۺ�", "�ۺ�",
	 * "�ɺ�", "����ĵ���ɫ", "�԰׵���������ɫ", "����ķۺ�", "���ɫ", "���е���������ɫ", "��������ɫ", "��",
	 * "����", "������", "���", "��������(�Ϻ�ɫ)", "�����ɫ", "��ɫ", "���е�������", "��������ɫ", "��������",
	 * "����", "������������ɫ", "���е���ɫ", "���еİ��Ұ�����ɫ", "���Ұ�����ɫ" }; String[] hex = new
	 * String[] { "#FFB6C1", "#FFC0CB", "#DC143C", "#FFF0F5", "#DB7093",
	 * "#FF69B4", "#FF1493", "#C71585", "#DA70D6", "#D8BFD8", "#DDA0DD",
	 * "#EE82EE", "#FF00FF", "#FF00FF", "#8B008B", "#800080", "#BA55D3",
	 * "#9400D3", "#9932CC", "#4B0082", "#8A2BE2", "#9370DB", "#7B68EE",
	 * "#6A5ACD" };
	 * 
	 * // String[] name = new String[] { "ǳ�ۺ�", "�ۺ�", "�ɺ�"}; // String[] hex =
	 * new String[] { "#FFB6C1", "#FFC0CB", "#DC143C"};
	 * 
	 * for (int i = 0, len = name.length; i < len; i++) { Bundle bundle = new
	 * Bundle(); bundle.putString("name", name[i]); bundle.putString("hex",
	 * hex[i]); colorList.add(bundle); }
	 * 
	 * return colorList; }
	 */

	public static final void getColorModel(final Handler handler, final Context context) {// why final?
		Thread thread = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				// super.run();
				Message message = new Message();
				if(isNetworkConnected(context) == true){
					getColorFromNetwork();
					message.what = 0x123;
				} else {
					message.what = 0x000;
				}
				
				handler.sendMessage(message);
			}
		};
		thread.start();
	}

	private static final List<Bundle> getColorFromNetwork() {
		colorList = new ArrayList<Bundle>();

		String json = requestJSON("http://mingcolor.herokuapp.com/json");
		try {
			JSONArray jsonArray = new JSONArray(json);
			for (int i = 0, len = jsonArray.length(); i < len; i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				Bundle bundle = new Bundle();
				bundle.putString("en", jsonObject.getString("en").trim());
				bundle.putString("zh", jsonObject.getString("zh").trim());
				bundle.putString("hex", jsonObject.getString("hex").trim());
				bundle.putString("rgb", jsonObject.getString("rgb").trim());
				colorList.add(bundle);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return colorList;
	}

	private static final String requestJSON(String url) {
		StringBuilder sb = new StringBuilder();

		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);

		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(entity.getContent(), "UTF-8"),
						1024);
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				reader.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return sb.toString();
	}

	private static boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}
	
}