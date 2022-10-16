package cn.yhm.developer.ecology.core;

import cn.yhm.developer.ecology.common.constant.EcologyConstants;
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

    private interface ExceptionMessage {
        String MSG_001 = "The appClass or args can not be null";
        String MSG_002 = "The project {} started successfully";
        String MSG_003 = "VM Option: [-Duser.timezone] value should be {}";
        String MSG_004 = "VM Option: [-Dfile.encoding] value should be {}";
        String MSG_005 = "VM Option: [-Dapp.name] should be set";
    }

    public static void run(Class<?> appClass, String[] args) {
        if (null == appClass || null == args) {
            log.error(ExceptionMessage.MSG_001);
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
        log.info(ExceptionMessage.MSG_002, appName);
    }

    private static void check(Properties properties) {
        // 当前项目所在时区
        String timezone = properties.getProperty(EcologyConstants.VmOption.TIMEZONE_KEY);
        // 当前项目默认编码
        String encoding = properties.getProperty(EcologyConstants.VmOption.ENCODING_KEY);
        // 当前项目名
        String appName = properties.getProperty(EcologyConstants.VmOption.APP_NAME_KEY);

        if (!EcologyConstants.VmOption.TIMEZONE_VALUE.equalsIgnoreCase(timezone)) {
            log.error(ExceptionMessage.MSG_003, EcologyConstants.VmOption.TIMEZONE_VALUE);
            System.exit(-1);
        }
        if (!EcologyConstants.VmOption.ENCODING_VALUE.equalsIgnoreCase(encoding)) {
            log.error(ExceptionMessage.MSG_004, EcologyConstants.VmOption.ENCODING_VALUE);
            System.exit(-1);
        }
        if (null == appName) {
            log.error(ExceptionMessage.MSG_005);
            System.exit(-1);
        }
    }

}
