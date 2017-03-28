package com.laprogramming.restaurantorders.socket;

class SocketMessage {
    public static final boolean REQUEST=true;
    public static final boolean ANSWER=false;

    public static final int CLOSE=0;
    public static final int OK=1;
    public static final int LOGIN=10;
    public static final int LOGIN_OK=11;
    public static final int LOGIN_ERR=12;

    public static final String SEPARATOR="<next/>";

    private int messageInfo;
    private String message;
    private boolean requestAnswer;

    public SocketMessage(boolean requestAnswer,int messageInfo, String message) {
        this.requestAnswer=requestAnswer;
        this.messageInfo=messageInfo;
        this.message=message;
    }

    public SocketMessage(boolean requestAnswer,int messageInfo) {
        this.requestAnswer=requestAnswer;
        this.messageInfo=messageInfo;
    }

    public SocketMessage() {
        //What to do here?
    }


    public SocketMessage(SocketMessage sm){
        this.requestAnswer=sm.requestAnswer;
        this.messageInfo=sm.messageInfo;
        this.message=sm.message;
    }

    //TESTING
	/*
	public SocketMessage(String smString){
		try{
			System.out.println(smString+" ... converting");
			String[] strings=smString.split(SEPARATOR);
			if(strings.length==3){
				this.requestAnswer=Boolean.parseBoolean(strings[0]);
				this.messageInfo=Integer.parseInt(strings[1]);
				this.message=strings[2];
			}
		}
		catch(InputMismatchException e){
			System.out.println("Error converting to SocketMessage"+e.toString());
		}
	}
	public String toSend(){
		String smString=requestAnswer+SEPARATOR+messageInfo+SEPARATOR+message;
		return smString;
	}
	*/

    //TESTING-2
    //remove boolean parameter
    public SocketMessage(String smString){
        SocketMessage read=SocketMessageContainer.readXml(smString);
        this.requestAnswer=read.requestAnswer;
        this.messageInfo=read.messageInfo;
        this.message=read.message;
    }
    public String toSend(){
        return SocketMessageContainer.toXml(this);
    }

    //Getters
    public boolean getRequestAnswer() {
        return requestAnswer;
    }
    public int getMessageInfo() {
        return messageInfo;
    }
    public String getMessage() {
        return message;
    }

    //Setters
    public void setRequestAnswer(boolean requestAnswer) {
        this.requestAnswer = requestAnswer;
    }
    public void setMessageInfo(int messageInfo) {
        this.messageInfo = messageInfo;
    }
    public void setMessage(String message) {
        this.message = message;
    }


    public String toString(){
        //Substitute String with StringBuffer and use append
        String string="";
        if(this.requestAnswer==REQUEST)
            string=string+"REQUEST";
        else if(this.requestAnswer==ANSWER)
            string=string+"ANSWER";

        string=string+" ";

        if(this.messageInfo==CLOSE)
            string=string+"CLOSE";
        else if(this.messageInfo==OK)
            string=string+"OK";
        else if(this.messageInfo==LOGIN)
            string=string+"LOGIN";
        else if(this.messageInfo==LOGIN_OK)
            string=string+"LOGIN_OK";
        else if(this.messageInfo==LOGIN_ERR)
            string=string+"LOGIN_ERR";

        string=string+" / ";

        string=string+this.message;

        return string;
    }
}
