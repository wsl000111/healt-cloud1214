package com.healt.cloud.resultex.anno;

import com.healt.cloud.resultex.handler.GlobalExceptionHandler;
import com.healt.cloud.resultex.handler.ResultResponseHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author GuYue
 * @date 2022-02-28 8:52
 * @description: TODO
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({GlobalExceptionHandler.class, ResultResponseHandler.class})
public @interface EnableResultEx {
}
