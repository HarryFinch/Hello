package jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Harold
 * @Date 2020/7/12
 * @Description :
 */
public class JDBCTest {

    private ApplicationContext ctx = null;

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
    }

    /*
     * @Description : JDBC的具名参数模板
     *      优点：若有多个参数，则不用对应位置，直接对应参数名，便于维护
     *      缺点：挨个参数起名，有点麻烦
     *@Param :
     */
    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "insert into superproviders (providerid,providername,providerdesc) values(:id,:name,:desc)";
        Map<String, Object> map = new HashMap<>();
        map.put("id", 12);
        map.put("name", "asdf");
        map.put("desc", "hello");
        namedParameterJdbcTemplate.update(sql, map);
    }

    /*
     * @Description : 具名参数模板，也可以使用update(sql,SqlParameterSource parameterSource)方法进行更新操作
     *      优点
     *          SQL语句中的参数名与类的属性一致
     *          使用SqlParameterSource 的实现类 BeanPropertySqlParameterSource作为参数
     * @Param :
     */
    @Test
    public void testNamedParameterJdbcTemplate1() {
        String sql = "insert into superproviders (providerid,providername,providerdesc) values" +
                "(:providerId ,:providerName,:providerDesc)";
        SuperProvider superProvider = new SuperProvider();
        superProvider.setProviderId(13);
        superProvider.setProviderName("Harold");
        superProvider.setProviderDesc("Hacker");
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(superProvider);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    @Test
    public void testQueryForObject2() {
        String sql = "select count(providerid) from superproviders";
        long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }


    /*
     * 查询实体类集合，也就是多条数据
     */
    @Test
    public void queryForObjectList() {
        String sql = "select providerid,providername,providerdesc from superproviders where providerid > 2";
        RowMapper<SuperProvider> rowMapper = new BeanPropertyRowMapper<>(SuperProvider.class);
        List<SuperProvider> superProviders = jdbcTemplate.query(sql, rowMapper);
        for (SuperProvider s : superProviders) {
            System.out.println(s);
        }
    }


    /*
     * 从数据库汇总获取一条记录，实际得到对应的对象
     * 注意调用的不是queryForObject(String sql,Class<Object> requiredType,Object...args)方法
     * 调用的是queryForObject(String sql,RowMapper<Object> rowMapper,Object...args)方法
     *      RowMapper<Object> 指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
     *      使用SQL中列的别名完成列明和类属性的映射，
     *      不支持级联属性，JdbcTemplate到底是一个JDBC的小工具，而不是ORM框架
     */
    @Test
    public void testQueryForObject() {
        String sql = "select providerid,providername,providerdesc from superproviders where providerid=?";
        RowMapper<SuperProvider> rowMapper = new BeanPropertyRowMapper<>(SuperProvider.class);
        SuperProvider superProvider = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(superProvider);
    }


    /*
     * @Description : 批量更新，即批量的增删改查
     * @Param :
     */
    @Test
    public void testBatchUpdate() {
        String sql = "insert into superproviders (providerid,providername,providerdesc) values(?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{3, "AAAA", "No heart"});
        batchArgs.add(new Object[]{4, "BBBB", "Wolf heart"});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    @Test
    public void testUpdate() {
        String sql = "update superproviders set providername = ? where providerid = ?";
        jdbcTemplate.update(sql, "pwj", "111111");
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSources = ctx.getBean(DataSource.class);
        System.out.println(dataSources.getConnection());
    }

}
