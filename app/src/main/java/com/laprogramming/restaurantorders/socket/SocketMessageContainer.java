package com.laprogramming.restaurantorders.socket;

class SocketMessageContainer {
    private static final String requestAnswerTag="requestAnswer";
    private static final String messageInfoTag="messageInfo";
    private static final String messageTag="message";

    public static String toXml(SocketMessage sm){
        StringBuffer out=new StringBuffer();

        out.append(tagToAppend(requestAnswerTag, Boolean.toString(sm.getRequestAnswer())));
        out.append(tagToAppend(messageInfoTag, Integer.toString(sm.getMessageInfo())));
        out.append(tagToAppend(messageTag, sm.getMessage()));

        return new String(out);
    }

    private static String tagToAppend(String tag, String content){
        StringBuffer out=new StringBuffer();
        out.append("<"+tag+">");
        out.append(content);
        out.append("</"+tag+">");
        return new String(out);
    }

    public static SocketMessage readXml(String in){
        SocketMessage sm=new SocketMessage();

        sm.setRequestAnswer(Boolean.parseBoolean(getContent(requestAnswerTag, in)));
        sm.setMessageInfo(Integer.parseInt(getContent(messageInfoTag, in)));
        sm.setMessage(getContent(messageTag, in));

        return sm;
    }

    private static String getContent(String tag, String in){
        int open=in.indexOf("<"+tag+">")+new String("<"+tag+">").length();
        int close=in.indexOf("</"+tag+">", open);
        return in.substring(open, close);
    }
}
