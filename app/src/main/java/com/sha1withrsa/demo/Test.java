package com.sha1withrsa.demo;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;


public class Test {

	public static final String privateKeyPKCS1 = "MIICXAIBAAKBgQDn24WfYWVfcCa/4Jz/h0sJkke8OJN/eKMJ1fmu48T4qbZb998M"
			+ "SyW+9TP3ddHAt+PE2o06Jk8rTDwTnlADLF7f+Tj1O3zw5YvYuDRrJvCf50tDHG4u"
			+ "6E049RmGXWqDmmFewV9cEvGIQVzwfZekcvXzP1qQFH2Vd2Z3LwDEb8VWfwIDAQAB"
			+ "AoGAKpWqPDTCTr4lj9ZsX4503MQuQsbNaHs6zsKrQlD5S4a4RLoJEJP40dLtgYT1"
			+ "SoU741sU11pT7irpWd0Y6wxKPFVQDYkqtM47GHhfN3Z33l8bmTNlBbh4AeM2C2e3"
			+ "pSWCjs33o4BBm/P1le58WPjV3VmOfgfQwLN5Lj109/8J2EECQQD+mMl6cuMJRfML"
			+ "cbx93lpq2XuHN/idpikl3zNJ5HHnl8at4LLCUJr4ATop+9JLZBTqOnt+usSN7Etz"
			+ "ziW/YNRhAkEA6SKm3lHgPhB1KJEW4Q/05zAeluMd0sAxUqSLOmvewkFjfbfBXvtl"
			+ "PvJlh2PFSJ+VDl7vd1pLmdT9gLptF6wW3wJAFUfkH24W+CF2rVA2dzbsy92d67GM"
			+ "AHFxIw9DFDwaIUeYfdQ4XPGr4msH15aK/25AKUv2IqOt5kcID4f9s79+QQJAZtsk"
			+ "590TpA46wkUQ5QbXM9BlDojxNXQZzq5Nxt6kjuuua17Q74jWaGklJhB8j8foSUjV"
			+ "OcEaranslgip7NG93QJBANtgQMrdw+0UnAI85Dlhr9IepWYxu5J5Y36UUMc0LBlM"
			+ "S1/bscvSlHnOnHJS7mHZHm50RGGkxU6HQGDK1wMexl8=";

	public static final String privateKeyPKCS1withEnter = "MIICXAIBAAKBgQDn24WfYWVfcCa/4Jz/h0sJkke8OJN/eKMJ1fmu48T4qbZb998M\r\n"
			+ "SyW+9TP3ddHAt+PE2o06Jk8rTDwTnlADLF7f+Tj1O3zw5YvYuDRrJvCf50tDHG4u\r\n"
			+ "6E049RmGXWqDmmFewV9cEvGIQVzwfZekcvXzP1qQFH2Vd2Z3LwDEb8VWfwIDAQAB\r\n"
			+ "AoGAKpWqPDTCTr4lj9ZsX4503MQuQsbNaHs6zsKrQlD5S4a4RLoJEJP40dLtgYT1\r\n"
			+ "SoU741sU11pT7irpWd0Y6wxKPFVQDYkqtM47GHhfN3Z33l8bmTNlBbh4AeM2C2e3\r\n"
			+ "pSWCjs33o4BBm/P1le58WPjV3VmOfgfQwLN5Lj109/8J2EECQQD+mMl6cuMJRfML\r\n"
			+ "cbx93lpq2XuHN/idpikl3zNJ5HHnl8at4LLCUJr4ATop+9JLZBTqOnt+usSN7Etz\r\n"
			+ "ziW/YNRhAkEA6SKm3lHgPhB1KJEW4Q/05zAeluMd0sAxUqSLOmvewkFjfbfBXvtl\r\n"
			+ "PvJlh2PFSJ+VDl7vd1pLmdT9gLptF6wW3wJAFUfkH24W+CF2rVA2dzbsy92d67GM\r\n"
			+ "AHFxIw9DFDwaIUeYfdQ4XPGr4msH15aK/25AKUv2IqOt5kcID4f9s79+QQJAZtsk\r\n"
			+ "590TpA46wkUQ5QbXM9BlDojxNXQZzq5Nxt6kjuuua17Q74jWaGklJhB8j8foSUjV\r\n"
			+ "OcEaranslgip7NG93QJBANtgQMrdw+0UnAI85Dlhr9IepWYxu5J5Y36UUMc0LBlM\r\n"
			+ "S1/bscvSlHnOnHJS7mHZHm50RGGkxU6HQGDK1wMexl8=";

	public static final String privateKeyPKCS8 = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAOfbhZ9hZV9wJr/g"
			+ "nP+HSwmSR7w4k394ownV+a7jxPiptlv33wxLJb71M/d10cC348TajTomTytMPBOe"
			+ "UAMsXt/5OPU7fPDli9i4NGsm8J/nS0Mcbi7oTTj1GYZdaoOaYV7BX1wS8YhBXPB9"
			+ "l6Ry9fM/WpAUfZV3ZncvAMRvxVZ/AgMBAAECgYAqlao8NMJOviWP1mxfjnTcxC5C"
			+ "xs1oezrOwqtCUPlLhrhEugkQk/jR0u2BhPVKhTvjWxTXWlPuKulZ3RjrDEo8VVAN"
			+ "iSq0zjsYeF83dnfeXxuZM2UFuHgB4zYLZ7elJYKOzfejgEGb8/WV7nxY+NXdWY5+"
			+ "B9DAs3kuPXT3/wnYQQJBAP6YyXpy4wlF8wtxvH3eWmrZe4c3+J2mKSXfM0nkceeX"
			+ "xq3gssJQmvgBOin70ktkFOo6e366xI3sS3POJb9g1GECQQDpIqbeUeA+EHUokRbh"
			+ "D/TnMB6W4x3SwDFSpIs6a97CQWN9t8Fe+2U+8mWHY8VIn5UOXu93WkuZ1P2Aum0X"
			+ "rBbfAkAVR+Qfbhb4IXatUDZ3NuzL3Z3rsYwAcXEjD0MUPBohR5h91Dhc8aviawfX"
			+ "lor/bkApS/Yio63mRwgPh/2zv35BAkBm2yTn3ROkDjrCRRDlBtcz0GUOiPE1dBnO"
			+ "rk3G3qSO665rXtDviNZoaSUmEHyPx+hJSNU5wRqtqeyWCKns0b3dAkEA22BAyt3D"
			+ "7RScAjzkOWGv0h6lZjG7knljfpRQxzQsGUxLX9uxy9KUec6cclLuYdkebnREYaTF" + "TodAYMrXAx7GXw==";

	public static final String privateKeyPKCS8withEnter = "MIICXAIBAAKBgQDn24WfYWVfcCa/4Jz/h0sJkke8OJN/eKMJ1fmu48T4qbZb998M\r\n"
			+ "SyW+9TP3ddHAt+PE2o06Jk8rTDwTnlADLF7f+Tj1O3zw5YvYuDRrJvCf50tDHG4u\r\n"
			+ "6E049RmGXWqDmmFewV9cEvGIQVzwfZekcvXzP1qQFH2Vd2Z3LwDEb8VWfwIDAQAB\r\n"
			+ "AoGAKpWqPDTCTr4lj9ZsX4503MQuQsbNaHs6zsKrQlD5S4a4RLoJEJP40dLtgYT1\r\n"
			+ "SoU741sU11pT7irpWd0Y6wxKPFVQDYkqtM47GHhfN3Z33l8bmTNlBbh4AeM2C2e3\r\n"
			+ "pSWCjs33o4BBm/P1le58WPjV3VmOfgfQwLN5Lj109/8J2EECQQD+mMl6cuMJRfML\r\n"
			+ "cbx93lpq2XuHN/idpikl3zNJ5HHnl8at4LLCUJr4ATop+9JLZBTqOnt+usSN7Etz\r\n"
			+ "ziW/YNRhAkEA6SKm3lHgPhB1KJEW4Q/05zAeluMd0sAxUqSLOmvewkFjfbfBXvtl\r\n"
			+ "PvJlh2PFSJ+VDl7vd1pLmdT9gLptF6wW3wJAFUfkH24W+CF2rVA2dzbsy92d67GM\r\n"
			+ "AHFxIw9DFDwaIUeYfdQ4XPGr4msH15aK/25AKUv2IqOt5kcID4f9s79+QQJAZtsk\r\n"
			+ "590TpA46wkUQ5QbXM9BlDojxNXQZzq5Nxt6kjuuua17Q74jWaGklJhB8j8foSUjV\r\n"
			+ "OcEaranslgip7NG93QJBANtgQMrdw+0UnAI85Dlhr9IepWYxu5J5Y36UUMc0LBlM\r\n"
			+ "S1/bscvSlHnOnHJS7mHZHm50RGGkxU6HQGDK1wMexl8=";

	public static void main(String[] args) {
		System.out.println(sign("this is a test.", privateKeyPKCS1));
	}

	public static String sign(String content, String privateKey) {
		try {
			

			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
			
			byte[] base64Byte = Base64.getDecoder().decode(privateKey);
			String base64ByteStr = "";
			for (byte b : base64Byte) {
				base64ByteStr += b + " ";
			}
			System.out.println(base64ByteStr);
			
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);

			java.security.Signature signature = java.security.Signature.getInstance("SHA1WithRSA");

			signature.initSign(priKey);
			signature.update(content.getBytes("utf-8"));

			byte[] signed = signature.sign();

			return new String(Base64.getEncoder().encode(signed));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
