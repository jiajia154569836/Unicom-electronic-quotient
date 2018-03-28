package com.jiajia.flow.config;

import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.ProcessEngineConfigurationConfigurer;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: weizh
 * Date: 2018-1-19
 * Time: 17:46
 * Description:
 */
@Component
public class FlowableFontConfigurer implements ProcessEngineConfigurationConfigurer {

    public void configure(SpringProcessEngineConfiguration processEngineConfiguration) {
        processEngineConfiguration.setActivityFontName("文泉驿正黑");
        processEngineConfiguration.setLabelFontName("文泉驿正黑");
        processEngineConfiguration.setAnnotationFontName("文泉驿正黑");
    }

}
