package dao.StudentDaoImpl;

import dao.RestaurantDao;
import daomain.Restaurant;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

/**
 * @outhor li
 * @create 2020-01-01 21:30
 */
public class RestaurantDaoImpl implements RestaurantDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 查询总记录数
     */
    @Override
    public int findTotalCount() {
        String sql = "select count(*) from restaurant";
        return template.queryForObject(sql, Integer.class);
    }
    /**
     * 根据页码查询页面信息
     */
    @Override
    public List<Restaurant> findByPage(int start) {
        String sql = "select * from restaurant limit ? , ?";

        return template.query(sql, new BeanPropertyRowMapper<Restaurant>(Restaurant.class), start, 5);
    }
}
