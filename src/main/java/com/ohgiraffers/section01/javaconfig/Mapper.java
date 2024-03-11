package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

public interface Mapper {

    @Select("SELECT CURDATE() FROM DUAL")           // 호출을 받을 때 이 코드를 호출
    java.util.Date selectSysdate();


}