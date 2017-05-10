package hib.main;

import hib.domian.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Author:  Air
 * Date  :  2017/5/9.
 */
public class TestMain {
    public static void main(String[] args) {
        //读取配置
        Configuration conf = new Configuration().configure();
        //创建sessionFactory
        SessionFactory sf = conf.buildSessionFactory();
        //创建Session
        Session session = sf.openSession();
        Transaction tsc = session.beginTransaction();
        //开始操作！
        Customer customer = new Customer();
        //赋值
        /*customer.setCustName("第一啊！");
        customer.setCustMobile("13666666");
        customer.setCustSource("777");
        customer.setCustIndustry("富土康");
        customer.setCustLevel("9999");
        customer.setCustPhone("iPhone");
        //将customer存储到数据库
        session.save(customer);*/
        /**
         * 查询
         */
        customer = session.get(Customer.class, 666L);
        System.out.println(customer);

        /**
         * 修改  先查再改
         */
      /*  customer.setCustId(666L);
        customer.setCustIndustry("老子天下第一");
        customer.setCustLevel("9999999999");
        customer.setCustSource("有完没完");
        session.update(customer);
        System.out.println(customer);*/

        /**
         * 删除：先查再删除
         */
        session.delete(customer);
        System.out.println(customer);

        //提交事物
        tsc.commit();
        //关闭资源
        session.close();
        //关闭session工厂
        sf.close();

    }
}
