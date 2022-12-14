package com.healt.cloud.checkup.anno;

import com.healt.cloud.checkup.config.CheckupServiceConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CheckupServiceConfiguration.class})
public @interface EnableCheckupService {
}
