package com.goddess.base.design_model.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject mSubscriptionSubject=new SubscriptionSubject();
        //创建微信用户
        GuardianObserver user1=new GuardianObserver("杨影枫");
        GuardianObserver user2=new GuardianObserver("月眉儿");
        GuardianObserver user3=new GuardianObserver("紫轩");
        //订阅公众号
        mSubscriptionSubject.addObserver(user1);
        mSubscriptionSubject.addObserver(user2);
        mSubscriptionSubject.addObserver(user3);
        //公众号更新发出消息给订阅的微信用户
        mSubscriptionSubject.notifyObserver("刘望舒的专栏更新了");
    }
}
