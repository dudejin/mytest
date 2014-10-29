package com.example.chat.model;

/**
 * 聊天消息实体类
 * @author huanghui1
 * @version 1.0.0
 * @update 2014年10月28日 下午9:25:58
 */
public class MsgInfo {
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 会话id
	 */
	private String threadID;
	/**
	 * 发送人jid,格式为xxx@domain或者xxx@domain/resource
	 */
	private String fromJid;
	/**
	 * 收件人jid,格式为xxx@domain或者xxx@domain/resource
	 */
	private String toJid;
	/**
	 * 消息内容
	 */
	private String content;
	/**
	 * 消息主题
	 */
	private String subject;
	
	/**
	 * 消息创建时间
	 */
	private long creationDate;
	
	/**
	 * 是否是进来的消息
	 */
	private boolean isComming;
	
	/**
	 * 消息的附件
	 */
	private MsgPart msgPart;
	
	/**
	 * 消息的类型，默认是文本消息
	 */
	private Type msgType = Type.TEXT;
	
	/**
	 * 消息的发送状态，默认是正在发送
	 */
	private SendState sendState = SendState.SENDING;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getThreadID() {
		return threadID;
	}

	public void setThreadID(String threadID) {
		this.threadID = threadID;
	}

	public String getFromJid() {
		return fromJid;
	}

	public void setFromJid(String fromJid) {
		this.fromJid = fromJid;
	}

	public String getToJid() {
		return toJid;
	}

	public void setToJid(String toJid) {
		this.toJid = toJid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isComming() {
		return isComming;
	}

	public void setComming(boolean isComming) {
		this.isComming = isComming;
	}

	public Type getMsgType() {
		return msgType;
	}

	public void setMsgType(Type msgType) {
		this.msgType = msgType;
	}

	public SendState getSendState() {
		return sendState;
	}

	public void setSendState(SendState sendState) {
		this.sendState = sendState;
	}

	public MsgPart getMsgPart() {
		return msgPart;
	}

	public void setMsgPart(MsgPart msgPart) {
		this.msgPart = msgPart;
	}

	/**
	 * 消息的分类，主要有:
	 * <ul>
	 * 	<li>Type.TEXT -- 普通文本</li>
	 * 	<li>Type.IMAGE -- 图片</li>
	 * 	<li>Type.AUDIO -- 音频</li>
	 * 	<li>Type.VIDEO -- 视频</li>
	 * 	<li>Type.LOCATION -- 地理位置</li>
	 * 	<li>Type.VCARD -- 名片</li>
	 * 	<li>Type.FILE -- 文件</li>
	 * </ul>
	 * @author huanghui1
	 * @update 2014年10月28日 下午9:57:28
	 */
	public enum Type {
		/**
		 * 普通文本
		 */
		TEXT,
		IMAGE,
		AUDIO,
		VIDEO,
		LOCATION,
		VCARD,
		FILE;
		
		/**
		 * 将数字转换成Type
		 * @update 2014年10月28日 下午10:14:57
		 * @param value
		 * @return
		 */
		public static Type valueOf(int value) {
			switch (value) {
			case 0:
				return TEXT;
			case 1:
				return IMAGE;
			case 2:
				return AUDIO;
			case 3:
				return VIDEO;
			case 4:
				return LOCATION;
			case 5:
				return VCARD;
			case 6:
				return FILE;
			default:
				return TEXT;
			}
		}
	}
	
	/**
	 * 消息的发送状态，主要有三种：
	 * <ul>
	 * 	<li>SENDING -- 正在发送，默认的发送状态</li>
	 * 	<li>SUCCESS -- 发送成功</li>
	 * 	<li>FAILED -- 发送失败</li>
	 * </ul>
	 * @author huanghui1
	 * @update 2014年10月29日 上午10:16:26
	 */
	public enum SendState {
		/**
		 * 正在发送，默认的发送状态
		 */
		SENDING,
		/**
		 * 发送成功
		 */
		SUCCESS,
		/**
		 * 发送失败
		 */
		FAILED;
		
		public static SendState vauleOf(int vaule) {
			switch (vaule) {
			case 0:
				return SendState.SENDING;
			case 1:
				return SendState.SUCCESS;
			case 2:
				return SendState.FAILED;

			default:
				return SendState.SENDING;
			}
		}
	}
	
}