package com.example.chat.listener;

import java.util.Collection;

import org.jivesoftware.smack.RosterListener;
import org.jivesoftware.smack.packet.Presence;

import com.example.chat.manage.UserManager;
import com.example.chat.util.SystemUtil;

/**
 * 状态监听器
 * @author huanghui1
 * @update 2014年11月18日 下午2:13:20
 */
public class ChatRostListener implements RosterListener {
	public static boolean hasRosterListener = false;
	private UserManager mUserManager = UserManager.getInstance();

	@Override
	public void entriesAdded(Collection<String> addresses) {
		// TODO Auto-generated method stub
//			Log.d("------entriesAdded-----" + addresses.toString());
	}

	@Override
	public void entriesUpdated(Collection<String> addresses) {
		// TODO Auto-generated method stub
//			Log.d("------entriesUpdated-----" + addresses.toString());
	}

	@Override
	public void entriesDeleted(Collection<String> addresses) {
		// TODO Auto-generated method
//			Log.d("------entriesDeleted-----" + addresses.toString());
	}

	@Override
	public void presenceChanged(final Presence presence) {
		//更新用户状态
		SystemUtil.getCachedThreadPool().execute(new Runnable() {
			
			@Override
			public void run() {
				mUserManager.updateUserPresence(presence);
			}
		});
	}
	
}