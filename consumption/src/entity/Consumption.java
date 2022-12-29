package entity;


import java.sql.Date;

public class Consumption  {
    private Integer id; //消费ID
    private String type; //消费类型
    private String name; //消费名称
    private Double money; //消费金额
    private Date date; //消费日期
    private Integer userId; //属于哪个用户发布的

    public Consumption() {
    }

    public Consumption(Integer id, String type, String name, Double money, Date date, Integer userId) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.money = money;
        this.date = date;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
