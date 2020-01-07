package com.workman.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2020/1/7 17:40
 * @Version 1.0
 */
@Component
public class PrintTask {

//    cron一共有7位，但是最后一位是年，可以留空，所以我们可以写6位：
//            * 第一位，表示秒，取值0-59
//            * 第二位，表示分，取值0-59
//            * 第三位，表示小时，取值0-23
//            * 第四位，日期天/日，取值1-31
//            * 第五位，日期月份，取值1-12
//            * 第六位，星期，取值1-7，星期一，星期二...，注：不是第1周，第二周的意思
//          另外：1表示星期天，2表示星期一。
//            * 第7为，年份，可以留空，取值1970-2099
//
//    cron中，还有一些特殊的符号，含义如下：
//            (*)星号：可以理解为每的意思，每秒，每分，每天，每月，每年...
//            (?)问号：问号只能出现在日期和星期这两个位置，表示这个位置的值不确定，每天3点执行，所以第六位星期的位置，我们是不需要关注的，就是不确定的值。同时：日期和星期是两个相互排斥的元素，通过问号来表明不指定值。比如，1月10日，比如是星期1，如果在星期的位置是另指定星期二，就前后冲突矛盾了。
//            (-)减号：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点，即10,11,12
//            (,)逗号：表达一个列表值，如在星期字段中使用“1,2,4”，则表示星期一，星期二，星期四
//            (/)斜杠：如：x/y，x是开始值，y是步长，比如在第一位（秒） 0/15就是，从0秒开始，每15秒，最后就是0，15，30，45，60    另：*/y，等同于0/y
//
//    下面列举几个例子:
//            0 0 3 * * ?     每天3点执行
//            0 5 3 * * ?     每天3点5分执行
//            0 5 3 ? * *     每天3点5分执行，与上面作用相同
//            0 5/10 3 * * ?  每天3点的 5分，15分，25分，35分，45分，55分这几个时间点执行
//            0 10 3 ? * 1    每周星期天，3点10分 执行，注：1表示星期天    
//            0 10 3 ? * 1#3  每个月的第三个星期，星期天 执行，#号只能出现在星期的位置

    /**
     * 每10秒执行一次该方法
     * @throws Exception
     */
    @Scheduled(cron = "*/10 * * * * *")
    public void cron() throws Exception {
        System.out.println("执行测试cron时间："+ new Date(System.currentTimeMillis()));
    }

    /**
     * 是上一个调用开始后再次调用的延时（不用等待上一次调用完成）
     * 该属性的含义是上一个调用开始后再次调用的延时（不用等待上一次调用完成），
     * 这样就会存在重复执行的问题，所以不是建议使用，但数据量如果不大时在配置的间隔时间内可以执行完也是可以使用的
     * @throws Exception
     */
    //@Scheduled(fixedRate = 1000 * 1)
    public void fixedRate() throws Exception {
        Thread.sleep(2000);//每次都会在上一次执行的基础上延时2秒执行
        System.out.println("执行测试fixedRate时间："+ new Date(System.currentTimeMillis()));
    }

    /**
     * 上一个调用完成后再次调用的延时调用
     * 该属性的功效与上面的fixedRate则是相反的，配置了该属性后会等到方法执行完成后延迟配置的时间再次执行该方法
     * @throws Exception
     */
    //@Scheduled(fixedDelay = 1000 * 1)
    public void fixedDelay() throws Exception{
        //Thread.sleep(3000);
        System.out.println("执行测试fixedDelay时间："+ new Date(System.currentTimeMillis()));
    }

    /**
     * 第一次被调用前的延时，单位毫秒
     * 该属性的作用是第一次执行延迟时间，只是做延迟的设定，
     * 并不会控制其他逻辑，所以要配合fixedDelay或者fixedRate来使用
     * @throws Exception
     */
    @Scheduled(initialDelay = 1000*10,fixedDelay = 1000*2)
    public void initialDelay() throws Exception{
        System.out.println("执行测试initialDelay时间："+ new Date(System.currentTimeMillis()));
    }
}
