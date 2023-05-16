package configs;

import models.emp.EmpDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
public class AppCtx {
    /** 커넥션 풀 연결 설정 S */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");   // DB 드라이버 설정
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl"); // DB 연결주소 설정
        ds.setUsername("SCOTT");
        ds.setPassword("tiger");
        ds.setInitialSize(2);           // 최초 커넥션 풀 커넥션 숫자
        ds.setMaxActive(10);            // 최대 커넥션 풀 커넥션 숫자
        ds.setTestWhileIdle(true);      // 유후상태 체크 기능 활성화
        ds.setMinEvictableIdleTimeMillis(30000);     // 최대 유휴 시간
        ds.setTimeBetweenEvictionRunsMillis(3000);   // 테스트 주기

        return ds;
    }
    /** 커넥션 풀 연결 설정 E */

    /** DB 쿼리 사용을 위한 설정 S */
    @Bean
    public JdbcTemplate jdbcTemplate() {

        return new JdbcTemplate(dataSource());
    }

    @Bean
    public EmpDao empDao() {
        return new EmpDao();
    }

    /** DB 쿼리 사용을 위한 설정 E */

    /** 트랜잭션 수동 조작 사용 설정 S */
    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());

        return tm;
    }
    /** 트랜잭션 수동 조작 사용 설정 E */



}
