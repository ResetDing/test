package net.wanho.datasource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBCPTest {

    @Test
    public void  testDbcp() throws Exception {
        Properties properties = new Properties();
        InputStream is = DBCPTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(is);
        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);

        for (int i = 0; i < 30; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(connection.hashCode());
        }


    }
}
