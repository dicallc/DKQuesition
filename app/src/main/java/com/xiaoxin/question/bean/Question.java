package com.xiaoxin.question.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2016/8/30.
 */
public class Question extends BmobObject{
    /**
     * 问题类别
     */
    public String type;
    /**
     * 关键词
     */
    public String keyword;
    /**
     * 问题描述
     */
    public String content;

    /**
     * 问题回答
     */
    public String answer;

    /**
     * 问题提交人
     */
    public String name;

}
