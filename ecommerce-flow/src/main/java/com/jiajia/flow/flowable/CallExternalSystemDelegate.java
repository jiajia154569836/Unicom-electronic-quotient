package com.jiajia.flow.flowable;



import com.jiajia.flow.kafka.KafkaProperties;
import com.jiajia.flow.kafka.MyKafkaProducer;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class CallExternalSystemDelegate implements JavaDelegate {
	public void execute(DelegateExecution execution) {
		System.out.println("Calling the external system for employee " + execution.getVariable("employee"));
		System.out.println("aaaaaaaa--------------kafka 生产者开始------------------------aaaaaaaaaa");
		MyKafkaProducer producerThread = new MyKafkaProducer(KafkaProperties.topic);
		producerThread.start();

	}
}
