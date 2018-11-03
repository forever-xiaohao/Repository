/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: MybatisTest
 * Author:   haoc
 * Date:     2018/11/3 9:23
 * Description: Mybatis测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csic;

import com.csic.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Mybatis测试〉
 *
 * @author haoc
 * @date 2018/11/3
 * @since 1.0.0
 */
public class MybatisTest {

    private SqlSessionFactory build;
    private SqlSession sqlSession;
    private User user;

    @Test
    public void testFindUserById() throws IOException {
        //加载配置文件
        String resources = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resources);
        //创建发SessionFactory
        build = new SqlSessionFactoryBuilder().build(in);
        //打开session
        sqlSession = build.openSession();
        //执行sql语句
        user = sqlSession.selectOne("test.findUserById", 10);
        System.out.println(user.toString());
    }

}
