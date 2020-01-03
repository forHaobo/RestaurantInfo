package dao.StudentDaoImpl;

import dao.RestaurantDao;
import daomain.Expenses;
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
    @Override
    public List<Restaurant> findByPageRank(int start) {
        String sql = "select * from restaurant order by rsum desc limit ? , ?";

        return template.query(sql, new BeanPropertyRowMapper<Restaurant>(Restaurant.class), start, 5);
    }

    /**
     * 根据rnum查询
     */
    @Override
    public Restaurant findByRnum(int rnum) {
        String sql = "select * from restaurant where rnum = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Restaurant>(Restaurant.class), rnum);
    }

    /**
     * 设置餐厅收入
     * @param rnum
     * @param rmoney
     */
    @Override
    public void addMoney(int rnum, int rmoney) {
        String sql = "update restaurant set rsum = ? where rnum = ?";
        template.update(sql, rmoney, rnum);
    }

    /**
     * 设置消费记录
     * @param snum
     * @param rnum
     * @param rname
     */
    @Override
    public void setExpenses(String snum, int rnum, String rname, int money) {
        String sql = "insert expenses(rnum, snum, emsg, money) value(?, ?, ?, ?) ";
        template.update(sql,rnum, snum, rname, money);
    }

    /**
     * 查询消费记录
     * @param snum
     * @return
     */
    @Override
    public List<Expenses> findPageBySnum(String snum, int start) {
        List<Expenses> exception = null;
        String sql = "select * from expenses where snum = ? limit ?, ?";
        try {
            exception = template.query(sql, new BeanPropertyRowMapper<Expenses>(Expenses.class), snum, start, 5);
        }catch (Exception e){
            System.out.println("消费记录页面查询不到");
        }
        return exception;
    }
    /**
     * 查询消费记录
     * @param snum
     * @return
     */
    @Override
    public List<Expenses> findBySnum(String snum) {
        List<Expenses> exception = null;
        String sql = "select * from expenses where snum = ? ";
        try {
            exception = template.query(sql, new BeanPropertyRowMapper<Expenses>(Expenses.class), snum);
        }catch (Exception e){
            System.out.println("消费记录查询不到");
        }
        return exception;
    }
}
