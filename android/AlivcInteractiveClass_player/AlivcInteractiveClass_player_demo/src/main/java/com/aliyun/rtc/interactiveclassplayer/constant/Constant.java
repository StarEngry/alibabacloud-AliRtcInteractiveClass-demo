package com.aliyun.rtc.interactiveclassplayer.constant;

public class Constant {

    public static final String NEW_TOKEN_PARAMS_KEY_USERID = "userId";
    public static final String NEW_TOKEN_PARAMS_KEY_ROLE = "role";
    public static final String NEW_TOKEN_PARAMS_KEY_PLATFORM = "platform";
    public static final String NEW_TOKEN_PARAMS_VALUE_ROLE = "student";
    public static final String NEW_TOKEN_PARAMS_VALUE_PLATFORM = "android";
    /**
     * server端的请求域名，需要用户自己替换成自己server端的请求接口域名
     */
    private static final String BASE_URL = "";
    /**
     * 分享链接的域名，需要用户自己替换成自己的域名
     */
    private static final String BASE_WEB_PLAY = "";
    /**
     * 获取鉴权信息
     */
    private static final String URL_NEW_TOKEN = BASE_URL + "/interactive-live-class/getRtcAuth";
    /**
     * 获取播放地址
     */
    private static final String URL_LIVE_PLAY = BASE_URL + "/interactive-live-class/getPlayUrl";
    /**
     * 分享链接
     */
    private static final String URL_WEB_PLAY = BASE_WEB_PLAY + "/index.html#/studentOnly";
    /**
     * 获取频道中的用户人数
     */
    private static final String URL_CHANNEL_USER_NUM = BASE_URL + "/interactive-live-class/describeChannelUsers";

    public static final String NEW_GUEST_PARAMS_KEY_PACKAGE = "PACKAGE_NAME";
    public static final String NEW_TOKEN_PARAMS_KEY_CHANNELID = "channelId";
    //sp key
    public static final String ALIVC_VOICE_CALL_SP_KEY_USER_INFO = "user_info";

    public static String getUserLoginUrl() {
        return URL_NEW_TOKEN;
    }

    public static String getLivePlayUrl() {
        return URL_LIVE_PLAY;
    }

    public static String getWebPlayUrl(String channelid) {
        return URL_WEB_PLAY + "?channel=" + channelid + "&role=1";
    }

    public static String getChannelUserNumUrl() {
        return URL_CHANNEL_USER_NUM;
    }
}
