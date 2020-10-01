package com.myproject.basic;

import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.myproject.basic.Main.print;

public class StringDemo implements Demo {

    @Override
    public void test() {
        testBuffers();

        testRegexp();
    }

    private void testBuffers(){
        StringBuilder strBld = new StringBuilder();
        strBld.append("S-One ");

        StringBuffer strBuf = new StringBuffer();
        strBuf.append(strBld).append("S-Two ");

        strBuf.insert(6, "S-1.5 ");
        print(strBuf);

        ByteBuffer byteBuf = ByteBuffer.allocate(10);
        byteBuf.put("S-3.0".getBytes());
        strBuf.append(new String(byteBuf.array()));
        print(strBuf);
    }

    private void testRegexp(){
        String src = "<html>" +
                "<head><style>body{color:gray;}</style></head>" +
                "<body>" +
                "<h1>Hello java regex!</h1>" +
                "<a href='page1.html'>First page</a>" +
                "<a href='page1.html'>Second page</a>" +
                "<a href='https://google.com'>Google it</a>" +
                "<div>Lorem ipsum dolor...</div>" +
                "</body>" +
                "</html>";
        String regStr = "<([^/][^>\\s]*)\\s*([^>]*)>([^<]*)</\\1>";
        Pattern regex = Pattern.compile(regStr);
        Matcher matcher = regex.matcher(src);
        int count = 1;
        while(matcher.find()){
            String tag = matcher.group(1);
            String prop = matcher.group(2);
            String content = matcher.group(3);
            print(String.format("%d. {%s}[%s]:%s", count, tag, prop, content));
            count ++;
        }
    }
}
