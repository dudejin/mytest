package com.example.chat.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.chat.ChatApplication;

/**
 * 系统常用的工具方法
 * 
 * @author huanghui1
 *
 */
public class SystemUtil {
	/**
	 * 检测系统网络是否可用
	 * @return
	 */
	public static boolean isNetworkOnline() {
		boolean status = false;
		try {
			ConnectivityManager cm = (ConnectivityManager) ChatApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo netInfo = cm.getNetworkInfo(0);
			if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED) {
				status = true;
			} else {
				netInfo = cm.getNetworkInfo(1);
				if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED)
					status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return status;
	}
	
	/**
	 * 隐藏输入法
	 * @param view
	 */
	public static void hideSoftInput(View view) {
		InputMethodManager imm = (InputMethodManager)view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}
	
	/**
	 * 显示短时间的toast
	 * @author Administrator
	 * @update 2014年10月7日 上午9:49:18
	 * @param text
	 */
	public static void makeShortToast(CharSequence text) {
		Toast.makeText(ChatApplication.getInstance(), text, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * 显示短时间的toast
	 * @author Administrator
	 * @update 2014年10月7日 上午9:49:18
	 * @param text
	 */
	public static void makeShortToast(int resId) {
		Toast.makeText(ChatApplication.getInstance(), resId, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * 显示长时间的toast
	 * @author Administrator
	 * @update 2014年10月7日 上午9:50:02
	 * @param text
	 */
	public static void makeLongToast(CharSequence text) {
		Toast.makeText(ChatApplication.getInstance(), text, Toast.LENGTH_LONG).show();
	}
	
	/**
	 * 显示长时间的toast
	 * @author Administrator
	 * @update 2014年10月7日 上午9:50:02
	 * @param text
	 */
	public static void makeLongToast(int resId) {
		Toast.makeText(ChatApplication.getInstance(), resId, Toast.LENGTH_LONG).show();
	}
	
	/**
	 * 获取手机型号
	 * @update 2014年10月9日 上午8:39:55
	 * @return
	 */
	public static String getPhoneModel() {
		String model = android.os.Build.MODEL;
		if(TextUtils.isEmpty(model)) {
			model = "Android";
		}
		return model;
	}
	
	/**
	 * 获得当前的Android版本
	 * @update 2014年10月13日 上午9:11:10
	 * @return
	 */
	public static final int getCurrentSDK() {
		return android.os.Build.VERSION.SDK_INT;
	}
	
	/**
	 * SD卡是否可用
	 * @update 2014年10月23日 下午5:17:09
	 * @return
	 */
	public static boolean isSdcardAvailable() {
		return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
	}
	
	/**
	 * 保存文件，根据用户名动态生成文件夹，该用户名为当前登录的用户名
	 * @update 2014年10月23日 下午5:06:50
	 * @param data
	 * @param filePath 保存文件的路径，不含文件名
	 * @param filename 保存的文件名称，不含有路径
	 * @return
	 */
	public static File saveFile(byte[] data, String filePath, String filename) {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if (!dir.exists() && dir.isDirectory()) {
				dir.mkdirs();
			}
			file = new File(dir, filename);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bos = null;
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fos = null;
			}
		}
		return file;
	}
	
	/**
	 * 保存文件，根据用户名动态生成文件夹，该用户名为当前登录的用户名
	 * @update 2014年10月23日 下午5:06:50
	 * @param data
	 * @param saveFile 保存文件的路径，不含文件名
	 * @return
	 */
	public static File saveFile(byte[] data, File saveFile) {
		if (data == null || data.length <= 0) {
			return null;
		}
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		try {
			File dir = saveFile.getParentFile();
			if (!dir.exists() && dir.isDirectory()) {
				dir.mkdirs();
			}
			fos = new FileOutputStream(saveFile);
			bos = new BufferedOutputStream(fos);
			bos.write(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bos = null;
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fos = null;
			}
		}
		return saveFile;
	}
	
	/**
	 * 将字节数组转换成文件
	 * @update 2014年10月23日 下午5:26:48
	 * @param file
	 * @return
	 */
	public static byte[] getFileBytes(File file) {
		
		byte[] data = null;
		FileInputStream fis = null;
		ByteArrayOutputStream baos = null;
		try {
			fis = new FileInputStream(file);
			baos = new ByteArrayOutputStream(1024);
			byte[] buf = new byte[1024];
			int len = -1;
			while ((len = fis.read(buf)) != -1) {
				baos.write(buf, 0, len);
			}
			data = baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			baos = null;
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fis = null;
		}
		return data;
	}
	
	/**
	 * 将字节数组转换成文件
	 * @update 2014年10月23日 下午5:26:48
	 * @param filename 文件的全路径，包含文件名
	 * @return
	 */
	public static byte[] getFileBytes(String filename) {
		File file = new File(filename);
		return getFileBytes(file);
	}
	
	private static String convertByteArrayToHexString(byte[] arrayBytes) {
	    StringBuffer stringBuffer = new StringBuffer();
	    for (int i = 0; i < arrayBytes.length; i++) {
	        stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
	                .substring(1));
	    }
	    return stringBuffer.toString();
	}
	
	/**
	 * 根据文件的字节数组获取文件的hash值
	 * @update 2014年10月23日 下午5:35:11
	 * @param bytes
	 * @return
	 */
	public static String getFileHash(byte[] bytes) {
		String hash= null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.update(bytes);
			byte[] hashbyte = digest.digest();
			hash = convertByteArrayToHexString(hashbyte);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash;
	}
	
	/**
	 * 根据文件的字节数组获取文件的hash值
	 * @update 2014年10月23日 下午5:35:11
	 * @param file
	 * @return
	 */
	public static String getFileHash(File file) {
		String hash= null;
		FileInputStream fis = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			fis = new FileInputStream(file);
			byte[] buf = new byte[1024];
			int len = -1;
			while ((len = fis.read(buf)) != -1) {
				digest.update(buf, 0, len);
			}
			byte[] hashbyte = digest.digest();
			hash = convertByteArrayToHexString(hashbyte);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fis = null;
			}
		}
		return hash;
	}
	
	/**
	 * 获取头像默认的存放路径
	 * @update 2014年10月23日 下午6:09:27
	 * @param username
	 * @return
	 */
	public static String getDefaultIconPath(String username) {
		File dir = new File(Environment.getExternalStorageDirectory(), username + File.separator + "head_icon");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir.getAbsolutePath();
	}
	
	/**
	 * 根据用户名创建图像的名称
	 * @update 2014年10月23日 下午6:11:41
	 * @param username
	 * @return
	 */
	public static File generateIconFile(String username) {
		return new File(getDefaultIconPath(username), "icon_" + username + ".jpg");
	}
	
	/**
	 * 更具jid获取用户登录的资源
	 * @update 2014年10月23日 下午7:23:52
	 * @param jid
	 * @return
	 */
	public static String getResourceWithJID(String jid) {
		if (TextUtils.isEmpty(jid)) {
			return null;
		}
		if (jid.contains("/")) {
			return jid.substring(jid.indexOf("/") + 1);
		} else {
			return null;
		}
	}
}
