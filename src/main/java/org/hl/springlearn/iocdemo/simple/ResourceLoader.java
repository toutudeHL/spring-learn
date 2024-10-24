package org.hl.springlearn.iocdemo.simple;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 资源加载器，用来完成配置文件中配置的加载
 * 在spring中，会根据配置的包路径（如通过@ComponentScan注解指定）扫描指定包下的所有类。
 * 在扫描过程中，Spring会识别带有特定注解的类，如@Component、@Service、@Repository、@Controller等。
 *
 * @author houlei
 */
@Slf4j
public class ResourceLoader {

    public static Map<String, BeanDefinition> getResource() {
        log.info("资源加载");
        Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>(16);
        Properties properties = new Properties();
        try (InputStream inputStream = ResourceLoader.class.getResourceAsStream("/iocdemo/config.properties")) {
            properties.load(inputStream);
            for (String key : properties.stringPropertyNames()) {
                log.info("加载-beanName:{}", key);
                String className = properties.getProperty(key);
                /**
                 * 实例化Bean
                 * 实际根据Bean定义，Spring会实例化这些Bean，并将它们注册到IoC容器中。
                 * 实例化过程中，Spring会处理依赖注入，即根据Bean定义中的依赖关系，自动将所需的其他Bean注入到当前Bean中。
                 */
                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setBeanName(key);
                Class<?> clazz = Class.forName(className);
                beanDefinition.setBeanClass(clazz);
                /**
                 * 初始化Bean
                 * 实例化完成后，Spring会调用Bean的初始化方法（如@PostConstruct注解的方法或通过init-method属性指定的方法）。
                 * 初始化方法可以用于执行一些额外的配置或初始化逻辑。
                 */
                //
                beanDefinitionMap.put(key, beanDefinition);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            log.error("加载配置文件出错");
        }
        log.info("资源加载完成");
        log.info("----------------------");
        return beanDefinitionMap;
    }

}
