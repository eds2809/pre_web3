package dao;

import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactory {

    public static UserDaoFactory instance = new UserDaoFactory();
    private Properties properties = new Properties();

    private UserDaoFactory() {

    }

    private static UserDao getUserDao(String jpaType) {
        if (jpaType.equalsIgnoreCase("UserJDBCDao")) {
            return new UserJDBCDao();
        } else if (jpaType.equalsIgnoreCase("UserHibernateDAO")) {
            return new UserHibernateDAO();
        }
        return null;
    }

    public UserDao getUserDao() {
        InputStream csv =
                UserDaoFactory.class.getResourceAsStream("/WEB-INF/config.properties");
        try /*(FileInputStream fis = new FileInputStream("/WEB-INF/config.properties"))*/ {
            properties.load(csv);
            return getUserDao(properties.getProperty("jpaType"));
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
        return new UserHibernateDAO();
    }
}
