package backendspring.infrasructure.ex;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import javax.transaction.Transactional;
import java.lang.reflect.Method;

public class CustomPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return true;
    }

    @Override
    public ClassFilter getClassFilter() {
        return clazz -> clazz.getAnnotation(Transactional.class) != null;
    }
}
