package cn.yhm.developer.ecology.core;

import cn.yhm.developer.ecology.constant.EcologyConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import java.util.Properties;

/**
 * 运行应用程序
 *
 * @author victor2015yhm@gmail.com
 * @since 2022-10-14 23:46:27
 */
@Slf4j
public class App {

    public static void run(Class<?> appClass, String[] args) {
        if (null == appClass || null == args) {
            log.error("appClass or args can not be null");
            System.exit(-1);
        }
        // 环境变量
        Properties properties = System.getProperties();
        // 校验环境变量
        check(properties);
        // 启动项目
        SpringApplication.run(appClass, args);
        // 项目名称
        String appName = properties.getProperty(EcologyConstants.VmOption.APP_NAME_KEY);
        // 打印启动成功日志
        log.info("The project {} started successfully.", appName);
    }

    private static void check(Properties properties) {
        // 当前项目所在时区
        String timezone = properties.getProperty(EcologyConstants.VmOption.TIMEZONE_KEY);
        // 当前项目默认编码
        String encoding = properties.getProperty(EcologyConstants.VmOption.ENCODING_KEY);
        // 当前项目名
        String appName = properties.getProperty(EcologyConstants.VmOption.APP_NAME_KEY);

        if (!EcologyConstants.VmOption.TIMEZONE_VALUE.equalsIgnoreCase(timezone)) {
            log.error("VM Option: [-Duser.timezone] value should be {}", EcologyConstants.VmOption.TIMEZONE_VALUE);
            System.exit(-1);
        }
        if (!EcologyConstants.VmOption.ENCODING_VALUE.equalsIgnoreCase(encoding)) {
            log.error("VM Option: [-Dfile.encoding] value should be {}", EcologyConstants.VmOption.ENCODING_VALUE);
            System.exit(-1);
        }
        if (null == appName) {
            log.error("VM Option: [-Dapp.name] should be set");
            System.exit(-1);
        }
    }

}
