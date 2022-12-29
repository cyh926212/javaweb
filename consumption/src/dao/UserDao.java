package dao;

import entity.User;
import util.JDBCUtil;

public class UserDao {
    JDBCUtil jdbcUtil = new JDBCUtil();
    //用户注册
    public boolean register(User user) throws Exception {
        String sql_1 = "select * from t_user where username=?";
        String sql_2 = "insert into t_user values(0,?,?)";
        //查询用户名是否已经存在
        if(jdbcUtil.getUsername(sql_1,user.getUsername())){
            return false;
        }else{
            jdbcUtil.executeNonQuery(sql_2,user.getUsername(),user.getPassword());
            return true;
        }
    }
    //用户登入
    public User login(String username,String password) throws Exception {
        String sql = "select * from t_user where username=? and password=?";
        User user = jdbcUtil.getUser(sql,username,password);
        if(user!=null){
            return user;
        }
        return null;
    }
    //统计类型消费总额
    public Double statisticsType(String type,Integer id) throws Exception {
        String sql = "select sum(money) from t_consumption where type=? and user_id=? group by type";
        Double sumMoney = jdbcUtil.statisticsType(sql,type,id);
        return sumMoney;
    }

}
