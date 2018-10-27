package ch.agilesolutions.boot.start.logging;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

public class LoggerInjector implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public Object postProcessBeforeInitialization(final Object bean, String name) throws BeansException {
		ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				ReflectionUtils.makeAccessible(field);// make sure the field accessible if defined private
				if (field.getAnnotation(AuditLogger.class) != null) {
					Logger log = LoggerFactory.getLogger("AuditLogger");
					field.set(bean, log);
				}
				if (field.getAnnotation(SecurityLogger.class) != null) {
					Logger log = LoggerFactory.getLogger("SecurityLogger");
					field.set(bean, log);
				}
			}
		});
		return bean;
	}
}