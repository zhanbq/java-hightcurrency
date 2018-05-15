/* Copyright (c) 2006, Sriram Srinivasan
 *
 * You may distribute this software under the terms of the license 
 * specified in the file "License"
 */

package kilim.examples;

import kilim.ExitMsg;
import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

public class HelloWorldTask extends Task {
    static Mailbox<String> mb = new Mailbox<String>();
    static Mailbox<ExitMsg> exitmb = new Mailbox<ExitMsg>();		
    int type=0;							//Task的类型区分，0表示接受者，1表示发送者
    public HelloWorldTask(int type){
    	this.type=type;
    }
    
    public static void main(String[] args) throws Exception {
        Task sender = new HelloWorldTask(1).start();
        Task reciever = new HelloWorldTask(0).start();
        reciever.informOnExit(exitmb);	//要求接受者在结束后，填写退出邮箱
        exitmb.getb();					//退出邮箱中内容，表示接受者已经结束
        System.exit(0);			
    }
    
    public void execute() throws Pausable{
    	if(type==0){					//接受者	
	        while (true) {
	            String s = mb.get();
	            if (s.equals("over")) 
	            	break;
	            System.out.print(s);
	        }
    	}else if(type==1){				//发送者
            mb.putnb("Hello ");
            mb.putnb("World\n");
            mb.putnb("over");
    	}
    }
}
