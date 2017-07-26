package com.xl.mybatis.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory;

    /**
     * Singleton model to get SqlSessionFactory instance.
     *
     * @return SqlSessionFactory instance
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        String mybatisConfigPath = "config/mybatis/mybatis.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(mybatisConfigPath);
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    /**
     * Open a SqlSession via SqlSessionFactory.
     * By the way, you should close the SqlSession in your code.
     *
     * @return SqlSession sqlSession instance.
     */
    public static SqlSession getSqlSession() {
        return MybatisUtil.getSqlSessionFactory().openSession();
    }
}
