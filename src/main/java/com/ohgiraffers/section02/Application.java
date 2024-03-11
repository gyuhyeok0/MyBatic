package com.ohgiraffers.section02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";

        /* 필기. Mybatis 측에서 제공하는 Resources 라는 클래스 */
        InputStream inputStream;

        {
            try {
                inputStream = Resources.getResourceAsStream(resource);
                // 공장으로 세션 만듬
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

                // 세션 열기
                SqlSession session = sqlSessionFactory.openSession(false);

                //
                java.util.Date date = session.selectOne("mapper.selectSysdate");

                System.out.println("date = " + date);

                session.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}