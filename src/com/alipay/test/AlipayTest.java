package com.alipay.test;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayFundTransOrderQueryRequest;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradePayResponse;

public class AlipayTest {

	private final String SERVER_URL = "https://openapi.alipaydev.com/gateway.do";// 支付宝网关（沙箱测试固定）
	// private final String SERVER_URL =
	// "https://openapi.alipay.com/gateway.do";//支付宝网关（固定）

	// 应用私钥
	private final String PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCzPMqRrW62vhBqpKbgjAFxbc1I1191C9QX+qnxYKnOUd4Mzb8gcC7oqV7fjAeM/7eeFSRc6kcgJ+WqMKtJHL/bZYq6vs+x1feqeiuHDkpImBDQWMCqwoYz5AwMRxlHmX0cOyADCr2opPj5NSzXrOSxp9nKQ0vZ0b10LVNKt8Jv4pjQ4fwNZ10lMI3KeY7lrjnXZXR+/J/wIdt9NLMuDjhxqqqdmcW9HVhV9ubDeqh69lFwqBb8NsycFaAsxYhwcy0mMJw4cQBWFCLuXFOzm0gtGgUZwX3fCsV5fTLQl27iETZ/9GxjGlLkRxFf9P8JMm1WcHzesDm8D62/oapQ5kZRAgMBAAECggEAOT3W68NZsl7s20IOUXQlGdaZUwQFZloKuEXDdGUMlemrYqdqvK9XK9K7i+UqnCsmtwPFgy8G3Awh2sKEUWsvEqBRN+asaf0NhZJSyGUV8C0wYXmWvnI1bekMt/cU6brpK9TuGkqZ23wkT2JeGdsLhnk2otPvK3dCbBH1oc0h+Zz4kb+HUrAnfiOo9GXpio1ebsxv+Egrmjy8bdLYfqd+lXR0UgPx/MkF8xeAsBEA9TXVMnMXHRgFSArVmgrgmgJd7/EC02vEV45dKgYFCFQCiVeU+glcIU1yMtumOV3cMqZIyapSaSFeDxqpBYz7po0jhwsGKjCAlD5IX7JKENWw4QKBgQDyq2StIi5O302qyCy5sXZF8H3l7aJTQ1e+QCpGVWgcasu2pDPc5pXuDZ21sdEd/PRl0sBm8dyYZHgFRLMZfcOjc/1TqFkWmId8upvt3NCldUd4X8Goo1T/J3lGognCpMU2ZdthE5lmBggZyF1uaBroL2+2DjqlfQHzO1GQfQUAJQKBgQC9FV4Uvo+NjDnvda3aEPs/zppFPrE3VrOsiGslX3x7z3Nepj8vc8k11WfldfAUCs3PbrziNfSCQHg7E4Lz9tUc6FlDqkLSusCGfnhRgaY5j8zlHT1UYZVLasXyI2XBXmnHM+qpkKymUAMhXxusFPYHrpeGMapDC9GRWML0iHcPvQKBgQDGq1by/2bWH68gQF2NcSIZRDhuQ0x/ykRNd46koktn6G77CheDpCvfBrq1A+zmFi+oJRBrt1sYUDiKZ6IRHotKiC0/jjXRb/KMROJfrEYND6UBgbO0cnOlqRV6pDJFbkwequkd4sPVaN687PLA7u4IZL2aWK/eyCcOkOPH3PJ5GQKBgFato+pIjRArVyexv5e2rybJ9CiIG78tjMIr60o/opYzPEUIWvDK2FNIWA91aDAX388WiZn9d+/50+PpBuAFqB5PWRROycFGgRlmgouCrou2owvowoObFFB1Sva8SVpCiKUb5JgEzVCUX0r+CXZySXKuE6IdxFpl4ZUKppxoroPVAoGBAOetM6twdl1ZwCooJjnd3mVSoC/aYwN9+xXvsT6Omn0DMCNB/EJ1GDClURjixhRD7EkokVYPdSg6j56DPNpLgo2JhUldv0oc8QmV9hPb4hqhcppMqZVAGWNb/MiroBDGeZWOc/Uho93nHyDbzgsZXfFwgVk30oSoEWpUMibQTPda";
	// 以下信息不需要修改
	private final String FORMAT = "json";
	private final String CHARSET = "utf-8";
	private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqID2JNr/iDLd1f1qXNpDWZVkHMtJgnniq31pJNwHK/LF+B+HZkjo69hMQOJAqCwGzgzm/689ASg7zvI9UZ0gJlIsJ72mh71llXLO2mmmm6XMQClRTx8CFyauVd2V6Hw0g+IWMZ82LuYiseUFLOfe1c3mqPiGoJYoUJ8SL7Oq2lT6i+ou3cxzRHyYmysBfG6Cgj+VwW51NBy7ccpGVZYEARdRHRqhrOypSfcWvujckejNAj32TDgrhrghprU4hpzgdhvmjzqhqNb93jV/gQtc32qol+UIxr09kVAPEKIh75g84XtnhcAZymySjJmBhni0YOudjWccSaNxB/fqSTdUIQIDAQAB";
	private final String SIGN_TYPE = "RSA2";

	// 当面付
	private final String APP_ID = "2016080500171240";// 沙箱APPID(测试)

	private String AUTH_CODE = "287108181444710874";// 付款码(一码一用)

	private AlipayClient alipayClient;

	@Before
	public void setUp() {
		alipayClient = new DefaultAlipayClient(SERVER_URL, APP_ID, PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY,
				SIGN_TYPE);
	}

	@Test
	public void testTradePay() {// 当面付
		AlipayTradePayRequest request = new AlipayTradePayRequest();
		AlipayTradePayModel model = new AlipayTradePayModel();

		model.setOutTradeNo(System.currentTimeMillis() + "");// 订单号
		model.setSubject("单车");// 商品说明
		model.setTotalAmount("10");// 金额
		model.setAuthCode(AUTH_CODE);// 沙箱钱包中的付款码
		model.setScene("bar_code");// wave_code 声波支付; bar_code 条码支付

		try {
			request.setBizModel(model);
			AlipayTradePayResponse response = alipayClient.execute(request);

			System.out.println(response.getBody());
			System.out.println(response.getTradeNo());
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTransToaccount() {// 单笔转账(退款)
		AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
		// 生成 转账信息
		String bizContent = getBizContent01();
		request.setBizContent(bizContent);

		try {
			AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);

			System.out.println(response.isSuccess());
			System.out.println(response.getCode());
			System.out.println(response.getBody());
		} catch (AlipayApiException e) {

			e.printStackTrace();
		}
	}

	private String getBizContent01() {
		// qhskwo0031@sandbox.com(买家) pcbwne3288@sandbox.com(商家)
		// ALIPAY_USERID ALIPAY_LOGONID
		String outBizNo = System.currentTimeMillis() + "";

		JSONObject object = new JSONObject();
		object.put("out_biz_no", outBizNo);// 唯一订单号
		object.put("payee_type", "ALIPAY_LOGONID");// 收款账户类型
		object.put("payee_account", "qhskwo0031@sandbox.com");// 收款帐号
		object.put("payee_real_name", "沙箱环境");// 收款方真实姓名

		object.put("amount", 0.1);// 金额
		object.put("remark", "转账备注");// 转账备注

		return object.toJSONString();
	}

	@Test
	public void testTransQuery() {// 单条转账记录查询
		AlipayFundTransOrderQueryRequest request = new AlipayFundTransOrderQueryRequest();
		String bizContent = "{out_biz_no:1501047155276}";
		request.setBizContent(bizContent);

		try {
			AlipayFundTransOrderQueryResponse response = alipayClient.execute(request);

			System.out.println(response.isSuccess());
			System.out.println(response.getCode());
			System.out.println(response.getBody());

		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
	}

}
