package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016082100308211"/*"2016080400165292"*/;
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    //public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCfFCiHGUjD3Ac1H+mXjLKztj/qIZIlCX6jQcYm6I0dbgysHipULSUA2mA7COFQalCv6fXRQIQt0/4c/UWcCYG7NSPL3q3Tlq13EI99bq4jLl29YlZ4C4154LuqbVJ5fbysPNfnwFLVvi8X5j5XWQU+1RszM3MbtEVenWE39vWUai7bIJy71j2CuVoRwnK5sv7X2G0K9gf15e7P5hN+6vQKylr/kidXR/A4U8B67PKBHwv8xtFVbsqrMn0HdfIlBkxzA9rNLoHuYG5eJsx1hzoq8ns4wsx4A5yHOGCupDfPks4REFRMVyt2vAh5WsAxAScW4HKfeU6SA5dcgn3+kR1TAgMBAAECggEBAIvi0Bis9T22GGhw3Zq00NgTZXTffIIxLTkmt7azPJQql94q0JIg+K8dWQ3Qq0Fpm/Z1SAJwN0uNZaHcXf/upDQZcJbwA+9SSsuutl9Ymqy5Mxk8hkkd75TDOIOPirznAqh7AGj8yFrI2OStRRjOYTx1bWvCzHAKQA4JWto5wo50xM1Soo62sHFMNT9ewJ2lls/5XZT/CGPEZadwq8HFqAyK2t1iwuLUBCh7c+bmtNJj2d4QqnJXd20BaPlmIiLpNdXiqNb2b+PNI0DaISa64eQHnT5uwOM551hV9gjrNHOFfP78GQPU4Z0A9L+xng7tdnWi5H24p9mYv6iWTWSrIOECgYEA3OZLL2rquyEQ5PlBEt4SeH0+7PhHnCQbK8DgnlrGMfX3l1AvILSmFlpu+1JdJQLJzCWkNaKm7P/2uckwPmcCcMVUhIzA/LM07EbBBBP0nj98YPLuczq9BMJ6bCdShraSDRZcUt1cRLnmjPbJfx4WDKLmLDL4Z2xwkqOQoxQljlsCgYEAuFshLL1CC7bmTqWB6pxMk0za2JONv2GdqLw+xgWDZOJyDY6CAQ7LSq+QXjJ5TxniciArmw3hXWDHlVEg7qYudrZ8rPa34wVu8aRpTQc6fgCd8WDYtrqBOfepKhQ6FIk2IM/OGULsad6uMD+hugoiS4rm45n6GppxsCEjuPt+TmkCgYASAJ6t/Zulpns2/e1EuV5t/V8Mdut3GSYxuaVUonc2iSIlbb55ft9uQO58gujeZEzH22V3jYrnE7Eq0O+ilkiHoj1SFBqCPaSZgOaoC2xLHUdoq0OtlmLjKWpKuCWsnuJmOKVLh4jGfRQB9vbS6kPHwdraTUkbPKYr/TKDZ9frswKBgQCDetrKIaA84pCWfouNWzNxylo6I+HwIBplAPx0FfKDvMxCxuQJBRgPh+6af7zsoTVS14bB6sBT7HXrFBU8nuB8YeHBKaQ0EOfzBqLjAMjCnIYIZF2q1JDdWrgW/p39j24/MHV4prYdO2dXmcop+JhE8CeDI4mv934lcz0a7KJEIQKBgA05isJvS7gd2bzr/clwMX0eDjtRZeID4H3XmaHUpL6YEHJxZmzvCQTOzk3q7zO0Hsj8FnSO8JmCJRleUfo/MDGuoLarTIEkA0g9+r3k1K9EonC5iN+tvQhwKZ7387KT3fD6FuwRUeJLmedxm7tB03a9h8bf0hafTDymYxXd+NQg";
	public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCGYTEmlUdt/XgywkTfj61DAAkIQRH0wJ8YAx9M4H0nSdE5EdFC2XliMGDZ7MWH/ja4Se/ZIfwawuN5EEBdn+nWZzwNdlCZNBogWZVL3LaDZCxH90ype2wMCwwh8bAu66ErMa0L/2JDe4aIx434nzdE7RTDsvr+LUl2atY2c37jP3W/1tXn1xzFKU9Dm0teHcXlTF8eX0M9ecvUGtOui83p45lfV0WbloJwAFvd+FYuKfS8CAYB4pUylZC1q8NwUZ2XN/hOIUjZ81ApF09PHcGASN4oMNo4IE4ovxflvB71xPqGFJTgLGEUl8lKuaPd0UvXyB8jjspLfvk7IUOnu/XFAgMBAAECggEAR1bBqSIG0bWGYiwQND8qVC9onCEvTygTTcQakc17o6fkks+KsFqTvjTAtfCkzRWAJ0XZNwR7uhlMebDO+uUyVshncR4mm661UAc+4w9BNW+wsmPvJuqG6b3TqxGL3tzoqu2sWHozyG+DdIm8LQkZZlYWd+5EoTuZjGwbXLzj1+/KLB9o8OZ38lt35HlAnaoKJgnYIlg9q4fLGHqRxtE4CJyRBmoUmZv4ebvVxU25grulP6087dooJvCjyCh6dKxYycCFDyA2Wv6uUDzbx3FPkob/Jb6hbX8BrVkpzbixQTtpRMatTntX27hq3XDg05nGL0QLw0NBAWJyW0copU/0AQKBgQDSXtR4pFsBNJp4jmTEHMAE0LiBibP2S1QTVUYBmcoYu742tLVVvrnV/snlCmyZhAeergWrT1JEPZbP2ZEa80J9NmIsxjl8bXpWdIhOSRhO/lTX+icn6rL2IXPAWw9oa6EY0dJXpS1oYXy2zQsjz6BkJDYJcvUyxhfGim6ZpGlfIQKBgQCjhtjjACYKyEby9osyQ3c+ZsgIWBhgKqzxD9Svsbmm3OE1b90DrDxuHz4Anmy5bHco0pjV/r2Y8JMSJS6YBwudAe/DSuIqhhmqMBdNwCvGa2s2LZVUB9i308RugcSPf6DF3CtEUKc3odtGIWn+wcQrgVfYiP3dauOM4wP8Rah2JQKBgGwcb/TQAjTMY9Yw13gxjjzrRubLbcDVVY/Z8vA/qKytT0Ot+sLmEXr4Ral/gfAi+geCR0eSrCSFwktu9DN1cGYI3MtF06UuXgCwQpx41BVEfzW/SQAqjW4QIvxnz7NKHLA0pHSGXp+V+hG3rlHpEfRk56BTg89kHjPaUJyE8eIBAoGBAILHrJtXGhWTeNKFBGvNcwdP8fhiZBQ87RTZgVKGA6EEk4RGE28Fh0rW56JdETz2FxJp4tt6IK248RYY8HubXtlRnCwGrnwtxUbLsUd4QkoszJCGwh9zKwpRbY6nb8kH3E+BNoUrL6CZbKFYxcl9s+LLTbMaVFWJT7T0NdLC7uiVAoGAfnozM9oygN1Qs4ppl3oE4yITKyZCesg4APxBoo242MvTR+FDJIWmLOwc0vRh8gf0mvL5rr6JCJfMH7fXZhotQPu58GlwXPlozE9Ir2pynjqqc+AQjmWHweSSH9OEI5yaKTxYItOkLD4wCrJ6S7J3l5Kt67+5IGNOR/pfm8IC0wo=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    //public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlfZigqsYQzf0jUwO/WspKma+qRMIv9MHh+AIB8/PjEZEwqsAxJvK4ZR+j8iVCPnmsrVXJ/cJh4jRb7LgXQkEaSN7DAgY6ACKzuhAiAHfnoWcAKe57gcartj/AOs/TRY08y/awaHhsQ+JvlEzeAz5E/sT4fcpvW6UEF7SGJUh9z/OyNnp0D4FHZNnyf5Y5cO51Lwu0J37K5Pbul8/BO8UeW5nhYgXdGZ80b9acudWgkvbinjMAxjLm7vGidDqjjIWKkZqgx7cU2fclruk2qPQRPqW818tysjBs+rC72SrFud8AKRet1fNfsO7UTsiaRiwK8J3iYE/5MK4IvjhfNcYCwIDAQAB";
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA+FpGbwi0hIBo1VWF1auy/ldwotLKn9sNjxXQY6GUmqnOS2AOVygDidbZuBUoZu/hIZCPIF16NSoVgNCziMAfTjdYKUc1YDasgtTr47Z2ppOAFJVgFtZANGW3SNliaVSzZDVnsE+W5QgKNztqA1l/8/tEC/13B7t7sD0URA1sKK3CfvCMYsBBTGusIIo565rgZ1FkSpquCtQTs7evdoKpFStul9e831wXPMEvO6sHmqBrbmnbaeNO5YcHnEcF/KVkMupKOAyRAPctYm/udZ8oJBhcCwy+jH+gwwXlkNTCyXhcRYUOAebU+iWIB6wPvq9dQDmId8lv+7dErA80ro1RBQIDAQAB";
	
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://gpj.hk1.tunnelfrp.cc/Alipay/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/Alipay/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";/*"https://openapi.alipay.com/gateway.do"*/;
	
	// 支付宝日志
	public static String log_path = "C:\\Users\\Administrator\\Desktop\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

