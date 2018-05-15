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

/**
 * A slight extension to SimpleTask. This 
 * 
 * [compile] javac -d ./classes SimpleTask2.java
 * [weave]   java kilim.tools.Weave -d ./classes kilim.examples.SimpleTask
 * [run]     java -cp ./classes:./classes:$CLASSPATH  kilim.examples.SimpleTask2
 */
public class MultipleTask extends Task {
    static Mailbox<Integer> mb = new Mailbox<Integer>();
    static Mailbox<ExitMsg> exitmb = new Mailbox<ExitMsg>();
    
    public static void main(String[] args) throws Exception {
    	//System.out.println("thread id="+Thread.currentThread().getId());
    	for(int i=0;i<10000;i++){
    		Task t = new MultipleTask().start();
    		mb.putnb(i);
    	}
        
    	for(int i=0;i<10000;i++)
    		exitmb.getb();
        System.exit(0);
    }

    /**
     * The entry point. mb.get() is a blocking call that yields
     * the thread ("pausable")
     */

    public void execute() throws Pausable{
        Integer s = mb.get();
        System.out.println("thread id="+Thread.currentThread().getId()+" tast id="+Task.getCurrentTask().id+" Number:"+s);
        Task.sleep(10);
        exitmb.putb(new ExitMsg(this,null));
       // Task.exit(0);
    }
}
