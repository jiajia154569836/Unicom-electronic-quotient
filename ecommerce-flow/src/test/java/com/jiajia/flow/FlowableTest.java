package com.jiajia.flow;

import org.flowable.bpmn.model.TimerEventDefinition;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.common.api.delegate.Expression;
import org.flowable.engine.common.impl.calendar.DurationBusinessCalendar;
import org.flowable.engine.common.impl.calendar.DurationHelper;
import org.flowable.engine.common.impl.el.DefaultExpressionManager;
import org.flowable.engine.common.impl.util.DefaultClockImpl;
import org.flowable.engine.impl.util.TimerUtil;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.job.service.impl.persistence.entity.TimerJobEntity;
import org.flowable.variable.service.impl.el.NoExecutionVariableScope;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: weizh
 * Date: 2018-1-24
 * Time: 17:14
 * Description:
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = FlowApplication.class)
public class FlowableTest {
//    @Autowired
    private RuntimeService runtimeService;

//    @Test
    public void testStartFlowable(){
        Map<String, Object> variables = new HashMap<>(8);
        variables.putIfAbsent("orderId", "orderId123456");
        variables.putIfAbsent("orderNum", "orderNum123456");
        variables.putIfAbsent("flowStatus", 1);
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("broadband", variables);
        String processInstanceId = instance.getProcessInstanceId();
        System.out.println(processInstanceId);
    }

    @Test
    public void testTimeDuration() throws Exception {

        DefaultClockImpl defaultClock = new DefaultClockImpl();
        Calendar calendar = ISODateTimeFormat.dateTimeParser().withZone(DateTimeZone.forTimeZone(
                defaultClock.getCurrentTimeZone())).parseDateTime("+02").toCalendar(null);

        System.out.println(calendar.getTime());
        System.out.println(calendar.getTime().toLocaleString());
    }
}
