package com.example.chat.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 *
 * @author huanghui1
 * @version 1.0.0
 * @update 2014年10月13日 上午11:31:24
 */
public class Provider {
	public static final String AUTHORITY_USER = "com.example.chat.provider.user";
	public static final String AUTHORITY_MSG = "com.example.chat.provider.msg";
	public static final String AUTHORITY_NEW_FRIEND = "com.example.chat.provider.newFriend";
	public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.example.chat";
	public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.example.chat";

	/**
	 * 用户的表字段
	 * @author huanghui1
	 * @update 2014年10月13日 上午11:36:35
	 */
	public static final class UserColumns implements BaseColumns {
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY_USER + "/users");
		public static final Uri CONTENT_SEARCH_URI = Uri.parse("content://" + AUTHORITY_USER + "/users/search");
		
		public static final String TABLE_NAME = "t_user";
        public static final String DEFAULT_SORT_ORDER = "username ASC";
        
        public static final String USERNAME = "username";
        public static final String EMAIL = "email";
        public static final String NICKNAME = "nickname";
        public static final String PHONE = "phone";
        public static final String RESOURCE = "resource";
        public static final String STATUS = "status";
        public static final String MODE = "mode";
        public static final String FULLPINYIN = "fullPinyin";
        public static final String SHORTPINYIN = "shortPinyin";
        public static final String SORTLETTER = "sortLetter";
	}
	
	/**
	 * 个人信息的表字段
	 * @author coolpad
	 *
	 */
	public static final class PersonalColums implements BaseColumns {
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY_USER + "/personals");
		
		public static final String TABLE_NAME = "t_personal";
        public static final String DEFAULT_SORT_ORDER = "username ASC";
        
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
        public static final String NICKNAME = "nickname";
        public static final String REALNAME = "realName";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
        public static final String RESOURCE = "resource";
        public static final String STATUS = "status";
        public static final String MODE = "mode";
        public static final String STREET = "street";
        public static final String CITY = "city";
        public static final String PROVINCE = "province";
        public static final String ZIPCODE = "zipCode";
        public static final String ICONPATH = "iconPath";
        public static final String ICONHASH = "iconHash";
	}
	
	/**
	 * 用户名片表字段
	 * @author huanghui1
	 * @update 2014年10月13日 上午11:39:41
	 */
	public static final class UserVcardColumns implements BaseColumns {
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY_USER + "/userVcards");
		
		public static final String TABLE_NAME = "t_user_vcard";
        public static final String DEFAULT_SORT_ORDER = "userId ASC";
        
        public static final String USERID = "userId";
        public static final String NICKNAME = "nickname";
        public static final String REALNAME = "realName";
        public static final String EMAIL = "email";
        public static final String STREET = "street";
        public static final String CITY = "city";
        public static final String PROVINCE = "province";
        public static final String ZIPCODE = "zipCode";
        public static final String MOBILE = "mobile";
        public static final String ICONPATH = "iconPath";
        public static final String ICONHASH = "iconHash";
	}
	
	/**
	 * 聊天消息的字段
	 * @author huanghui1
	 * @update 2014年10月30日 下午3:42:57
	 */
	public static final class MsgInfoColumns implements BaseColumns {
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY_MSG + "/msgInfos");
		
		public static final String TABLE_NAME = "t_msg_info";
        public static final String DEFAULT_SORT_ORDER = "creationDate ASC";	//默认按时间降序，后面的消息先查出来
        
        public static final String THREAD_ID = "threadID";
        public static final String FROM_USER = "fromUser";
        public static final String TO_USER = "toUser";
        public static final String CONTENT = "content";
        public static final String SUBJECT = "subject";
        public static final String CREATIO_NDATE = "creationDate";
        public static final String IS_COMMING = "isComming";
        public static final String IS_READ = "isRead";
        public static final String MSG_TYPE = "msgType";
        public static final String SEND_STATE = "sendState";
	}
	
	/**
	 * 聊天消息附件的字段
	 * @author huanghui1
	 * @update 2014年10月30日 下午4:05:48
	 */
	public static final class MsgPartColumns implements BaseColumns {
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY_MSG + "/msgParts");
		public static final String TABLE_NAME = "t_msg_part";
		public static final String DEFAULT_SORT_ORDER = "msgId DESC";
		
		public static final String MSG_ID = "msgId";
		public static final String FILE_NAME = "fileName";
		public static final String FILE_PATH = "filePath";
		public static final String SIZE = "size";
		public static final String MIME_TYE = "mimeTye";
		public static final String CREATION_DATE = "creationDate";
	}
	
	/**
	 * 聊天的会话列表字段
	 * @author huanghui1
	 * @update 2014年10月30日 下午4:05:48
	 */
	public static final class MsgThreadColumns implements BaseColumns {
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY_MSG + "/msgThreads");
		public static final String TABLE_NAME = "t_msg_thread";
		public static final String DEFAULT_SORT_ORDER = "modifyDate DESC";	//最后修改时间的降序
		
		public static final String MSG_THREAD_NAME = "msgThreadName";
		public static final String UNREAD_COUNT = "unReadCount";
		public static final String MODIFY_DATE = "modifyDate";
		public static final String SNIPPET_ID = "snippetId";
		public static final String SNIPPET_CONTENT = "snippetContent";
		public static final String MEMBER_IDS = "memberIds";
	}
	
	/**
	 * 新的朋友信息列表
	 * @author Administrator
	 * @update 2014年11月9日 下午2:57:53
	 * @version 1.0.0
	 */
	public static final class NewFriendColumns implements BaseColumns {
		public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY_NEW_FRIEND + "/newFirends");
		public static final String TABLE_NAME = "t_new_friend";
		public static final String DEFAULT_SORT_ORDER = "creationDate DESC";	//最后修改时间的降序
		
		public static final String USER_ID = "userId";
		public static final String FRIEND_STATUS = "friendStatus";
		public static final String CONTENT = "content";
		public static final String CREATION_DATE = "creationDate";
		public static final String FROM_USER = "from_user";
		public static final String TO_USER = "to_user";
		public static final String ICON_HASH = "iconHash";
		public static final String ICON_PATH = "iconPath";
	}
}
