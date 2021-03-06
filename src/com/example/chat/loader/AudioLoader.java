package com.example.chat.loader;

import java.util.List;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.chat.manage.MsgManager;
import com.example.chat.model.AudioItem;
import com.example.chat.util.SystemUtil;

/**
 * 加载音乐文件列表
 * @author huanghui1
 * @version 1.0.0
 * @update 2014年11月22日 下午3:23:38
 */
public class AudioLoader extends AsyncTaskLoader<List<AudioItem>> {
	private MsgManager msgManager = MsgManager.getInstance();
	private List<AudioItem> list = null;

	public AudioLoader(Context context) {
		super(context);
	}

	@Override
	protected void onStartLoading() {
		if (!SystemUtil.isEmpty(list)) {
			deliverResult(list);
		}
		if (takeContentChanged() || SystemUtil.isEmpty(list)) {
			forceLoad();
		}
	}

	@Override
	protected void onStopLoading() {
		cancelLoad();
	}

	@Override
	protected void onReset() {
		onStopLoading();
		list = null;
	}

	@Override
	public List<AudioItem> loadInBackground() {
		list = msgManager.getAudioList();
		return list;
	}

}
