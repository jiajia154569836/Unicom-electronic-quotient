/**
 * Copyright (c) 2018 www.bonc.com.cn. All Rights Reserved.
 */
package com.jiajia.flow.config;

import org.flowable.engine.IdentityService;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述当前功能
 *
 * @author yangwang1@bonc.com.cn
 * @version V1.0.0
 */
@Configuration
public class FlowableConfig {

    @Bean
    InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {
        return () -> {
            int size = identityService.createUserQuery().userId("icrm").list().size();
            if(size == 0){// init db data
                // install groups & users
                User icrm = identityService.newUser("icrm");
                icrm.setFirstName("bonc");
                icrm.setLastName("icrm");
                icrm.setPassword("57X155dvQi3o");
                identityService.saveUser(icrm);
                identityService.createMembership("icrm", "user");
            }
        };
    }

}
