package com.dachuan.oracle;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import org.junit.Test;

import java.sql.*;

public class OracleDeml {

    @Test
    public void testProcedure01() throws Exception {
        //加载驱动
        Class.forName("oracle.jdbc.OracleDriver");
        //得到connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.110.10:1521:orcl","itheima","itheima");
        //得到预编译的Statement对象
        PreparedStatement pstm = connection.prepareStatement("select * from emp where empno = ?");
        //给参数赋值
        pstm.setObject(1,7788);
        //执行数据库查询操作
        ResultSet rs = pstm.executeQuery();
        //输出结果
        while (rs.next()){
            System.out.println(rs.getString("ename"));
        }

        //释放资源
        rs.close();
        pstm.close();
        connection.close();

    }


    /**
     * java调用存储过程
     * @throws Exception
     * {?= call <procedure-name>[(<arg1>,<arg2>, ...)]}   调用存储函数 使用
     * {call <procedure-name>[(<arg1>,<arg2>, ...)]}      调用存储过程 使用
     *
     */
    @Test
    public void testProcedure02() throws Exception {
        //加载驱动
        Class.forName("oracle.jdbc.OracleDriver");
        //得到connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.110.10:1521:orcl","itheima","itheima");
        //得到预编译的Statement对象
        CallableStatement pstm = connection.prepareCall(" {call p_yearsal(?,?)}");
        //给参数赋值
        pstm.setObject(1,7788);
        pstm.registerOutParameter(2, OracleTypes.NUMBER);

        //执行数据库查询操作
       pstm.execute();
        //输出结果
        System.out.println(pstm.getObject(2));
        //释放资源
        pstm.close();
        connection.close();

    }
}











