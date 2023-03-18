package backendspring.infrasructure.postprocessor;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class JpaRepositoryProfilerBeanPostProcessor implements BeanPostProcessor {

    Map<String, Object> beanExtendsJpaRepository = new HashMap<>();

    ConfigurableListableBeanFactory factory;


    public JpaRepositoryProfilerBeanPostProcessor(ConfigurableListableBeanFactory factory) {
        this.factory = factory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (beanName.contains("Repository")) {
            beanExtendsJpaRepository.put(beanName, bean);
        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (beanExtendsJpaRepository.containsKey(beanName)) {
            var beanClass = bean.getClass();
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            String originalClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(originalClassName);
                return Proxy.newProxyInstance(beanClass.getClassLoader(), new Class[]{originalClass}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Начал");
                        var retVal = method.invoke(proxy, args);
                        System.out.println("Кончил");
                        return retVal;
                    }
                });
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        return bean;
    }
}
