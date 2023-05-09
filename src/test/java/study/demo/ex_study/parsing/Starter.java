package study.demo.ex_study.parsing;


/** 날것 그대로 문자열들  parsing 해보기
 */
public class Starter {

    public static void main(String[] args) {

        String rawString = "GET / HTTP/1.1\r\n"
                + "Host: www.naver.com:443\r\n"
                + "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n"
                + "sec-ch-ua: \"Chromium\";v=\"92\", \" Not A;Brand\";v=\"99\", \"Google Chrome\";v=\"92\"\r\n"
                + "sec-ch-ua-mobile: ?0\r\n"
                + "Upgrade-Insecure-Requests: 1\r\n"
                + "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36\r\n";

        Parser httpParser = new Parser(rawString);

        httpParser.run();
    }
}
