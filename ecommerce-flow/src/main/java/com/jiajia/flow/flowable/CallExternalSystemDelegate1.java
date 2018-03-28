package com.jiajia.flow.flowable;


import com.jiajia.flow.kafka.MyKafkaConsumer1;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class CallExternalSystemDelegate1 implements JavaDelegate {
	public void execute(DelegateExecution execution) {
		System.out.println("Calling the external system for employee " + execution.getVariable("employee"));
		System.out.println("aaaaaaaa--------------kafka 消费者开始------------------------aaaaaaaaaa");
		MyKafkaConsumer1 myKafkaConsumer1 = new MyKafkaConsumer1();
		myKafkaConsumer1.start();

	}
}
