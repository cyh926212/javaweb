package util;


import entity.Consumption;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;

    //数据库连接操作
    public void init() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/consumption";
        String user = "root";
        String pwd = "111111";
        conn = DriverManager.getConnection(url, user, pwd);
    }

    //数据库关闭操作
    public void closeAll() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }



    /*通用数据库所有 增删改 操作
     * sql 带？号的sql语句
     * params ？中具体的参数
     * Object... params  动态可变参数
     * @return 行数
     */
    public int executeNonQuery(String sql, Object... params) throws Exception {
        //获取一个连接
        init();
        //根据sql和连接，获取一个声明
        try {
            pstmt = conn.prepareStatement(sql);
            //加入所有参数
            for(int i =0;i<params.length;i++){
                pstmt.setObject(i+1,params[i]);
            }
            int hang = pstmt.executeUpdate(); //返回影响的行数
            this.closeAll();
            return hang;
        } catch (SQLException e){
            System.out.println("执行通用Sql出错");
            e.printStackTrace();
        }
        return 0;
    }

    /*自定义查询用户名是否存在
     * sql 带？号的sql语句
     * params ？中具体的参数
     * @return
     */
    public boolean getUsername(String sql,String username) throws Exception {
        //获取一个连接
        init();
        //根据sql和连接，获取一个声明
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,username);
            rs = pstmt.executeQuery();
            if(rs.next()){
                this.closeAll();
                return true;
            }
        }catch (SQLException e){
            System.out.println("执行查询用户名是否存在Sql出错");
            e.printStackTrace();
        }
        return false;
    }

    /*自定义查询用户登入，根据用户名和密码
     * sql 带？号的sql语句
     * params ？中具体的参数
     * @return
     */
    public User getUser(String sql,String username,String password) throws Exception {
        //获取一个连接
        init();
        //根据sql和连接，获取一个声明
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,username);
            pstmt.setObject(2,password);
            rs = pstmt.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                this.closeAll();
                return user;
            }
        }catch (SQLException e){
            System.out.println("执行查询用户登录是否存在Sql出错");
            e.printStackTrace();
        }
        return null;
    }

    /*自定义查询 根据用户id 查询消费
     * sql 带？号的sql语句
     * params ？中具体的参数
     * @return
     */
    public List<Consumption> getByUserIdConsumption(String sql,Integer id) throws Exception {
        //获取一个连接
        init();
        List<Consumption> list = new ArrayList<Consumption>();
        //根据sql和连接，获取一个声明
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,id);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Consumption consumption = new Consumption();
                consumption.setId(rs.getInt("id"));
                consumption.setType(rs.getString("type"));
                consumption.setName(rs.getString("name"));
                consumption.setMoney(rs.getDouble("money"));
                consumption.setDate(rs.getDate("date"));
                list.add(consumption);
            }
            this.closeAll();
            return list;
        }catch (SQLException e){
            System.out.println("执行查询消费(id)是否存在Sql出错");
            e.printStackTrace();
        }
        return null;
    }

    /*自定义查询 根据名称 查询消费
     * sql 带？号的sql语句
     * params ？中具体的参数
     * @return
     */
    public List<Consumption> getByNameConsumption(String sql,String name,Integer userId) throws Exception {
        //获取一个连接
        init();
        List<Consumption> list = new ArrayList<Consumption>();
        //根据sql和连接，获取一个声明
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,name);
            pstmt.setObject(2,userId);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Consumption consumption = new Consumption();
                consumption.setId(rs.getInt("id"));
                consumption.setType(rs.getString("type"));
                consumption.setName(rs.getString("name"));
                consumption.setMoney(rs.getDouble("money"));
                consumption.setDate(rs.getDate("date"));
                list.add(consumption);
            }
            this.closeAll();
            return list;
        }catch (SQLException e){
            System.out.println("执行查询消费(name)是否存在Sql出错");
            e.printStackTrace();
        }
        return null;
    }

    /*自定义查询 根据日期 查询消费
     * sql 带？号的sql语句
     * params ？中具体的参数
     * @return
     */
    public List<Consumption> getByNameConsumption(String sql,Date date,Integer userId) throws Exception {
        //获取一个连接
        init();
        List<Consumption> list = new ArrayList<Consumption>();
        //根据sql和连接，获取一个声明
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,date);
            pstmt.setObject(2,userId);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Consumption consumption = new Consumption();
                consumption.setId(rs.getInt("id"));
                consumption.setType(rs.getString("type"));
                consumption.setName(rs.getString("name"));
                consumption.setMoney(rs.getDouble("money"));
                consumption.setDate(rs.getDate("date"));
                list.add(consumption);
            }
            this.closeAll();
            return list;
        }catch (SQLException e){
            System.out.println("执行查询消费(date)是否存在Sql出错");
            e.printStackTrace();
        }
        return null;
    }


    /*自定义查询 根据类型 统计消费总额
     * sql 带？号的sql语句
     * params ？中具体的参数
     * @return
     */
    public Double statisticsType(String sql,String type,Integer id) throws Exception {
        //获取一个连接
        init();
        Double sumMoney=0.0;
        //根据sql和连接，获取一个声明
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,type);
            pstmt.setObject(2,id);
            rs = pstmt.executeQuery();
            if (rs.next()){
                sumMoney = rs.getDouble("sumMoney");
            }
            this.closeAll();
            return sumMoney;
        }catch (SQLException e){
            System.out.println("执行统计消费(type)是否存在Sql出错");
            e.printStackTrace();
        }
        return null;
    }

    /*自定义查询 根据消费ID 查询消费
     * sql 带？号的sql语句
     * params ？中具体的参数
     * @return
     */
    public Consumption getByIdConsumption(String sql,Integer id) throws Exception {
        //获取一个连接
        init();
        //根据sql和连接，获取一个声明
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1,id);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Consumption consumption = new Consumption();
                consumption.setId(rs.getInt("id"));
                consumption.setType(rs.getString("type"));
                consumption.setName(rs.getString("name"));
                consumption.setMoney(rs.getDouble("money"));
                consumption.setDate(rs.getDate("date"));
                consumption.setUserId(rs.getInt("user_id"));
                this.closeAll();
                return consumption;
            }
        }catch (SQLException e){
            System.out.println("执行查询消费(id)是否存在Sql出错");
            e.printStackTrace();
        }
        return null;
    }
}
