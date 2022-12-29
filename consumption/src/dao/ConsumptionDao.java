package dao;

import entity.Consumption;
import util.JDBCUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ConsumptionDao {
    JDBCUtil jdbcUtil = new JDBCUtil();
    //添加消费支出
    public boolean addConsumption(Consumption consumption)  throws Exception {
        String sql = "insert into t_consumption values(0,?,?,?,?,?)";
        if(jdbcUtil.executeNonQuery(sql,consumption.getType(), consumption.getName(),
                consumption.getMoney(),consumption.getDate(),consumption.getUserId())>0){
            return true;
        }
        return false;
    }

    //根据用户ID查询消费
    public List<Consumption> getByUserIdConsumption(Integer id) throws Exception {
        String sql = "select * from t_consumption where user_id=?";
        List<Consumption> list = new ArrayList<Consumption>();
        list = jdbcUtil.getByUserIdConsumption(sql,id);
        if(list!=null){
            return list;
        }
        return null;
    }
    //删除消费
    public boolean delByConsumptionId(Integer id) throws Exception {
        String sql = "delete from t_consumption where id=?";
        if(jdbcUtil.executeNonQuery(sql,id)>0){
            return true;
        }
        return false;
    }
    //根据消费名称询
    public List<Consumption> getByNameConsumption(String name,Integer userId) throws Exception {
        String sql = "select * from t_consumption where name=? and user_id=?";
        List<Consumption> list = new ArrayList<Consumption>();
        list = jdbcUtil.getByNameConsumption(sql,name,userId);
        if(list!=null){
            return list;
        }
        return null;
    }
    //根据日期查询
    public List<Consumption> getByDateConsumption(Date date,Integer userId) throws Exception {
        String sql = "select * from t_consumption where date=? and user_id=?";
        List<Consumption> list = new ArrayList<Consumption>();
        list = jdbcUtil.getByNameConsumption(sql,date,userId);
        if(list!=null){
            return list;
        }
        return null;
    }

    //统计各类型的消费
    public Double statisticsType(String type,Integer id) throws Exception {
        String sql = "select sum(money) as sumMoney from t_consumption where type=? and user_id=? group by type";
        Double sumMoney=0.0;
        sumMoney = jdbcUtil.statisticsType(sql,type,id);
        return sumMoney;
    }

    //根据消费id查询
    public Consumption getByIdConsumption(Integer id) throws Exception {
        String sql = "select * from t_consumption where id=?";
        List<Consumption> list = new ArrayList<Consumption>();
        Consumption consumption = jdbcUtil.getByIdConsumption(sql,id);
        if(consumption!=null){
            return consumption;
        }
        return null;
    }
    //更新消费
    public boolean updateConsumption(Consumption consumption)  throws Exception {
        String sql = "update t_consumption set type=?,name=?,money=?,date=?,user_id=? where id=?";
        if(jdbcUtil.executeNonQuery(sql,consumption.getType(), consumption.getName(),
                consumption.getMoney(),consumption.getDate(),consumption.getUserId(),consumption.getId())>0){
            return true;
        }
        return false;
    }
}
