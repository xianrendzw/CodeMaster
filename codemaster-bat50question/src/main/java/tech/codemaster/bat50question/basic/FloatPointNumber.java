package tech.codemaster.bat50question.basic;

import java.math.BigDecimal;

/**
 * 浮点数运算、精度丢失
 * Created by tomdeng on 16/11/2.
 */
public class FloatPointNumber {
    public static void main(String[] args){
//        System.out.println(BitConverter.getBits(0.4));
//        System.out.println(BitConverter.getBits(0.2 + 0.2));
//        System.out.println(BitConverter.getBits(0.4 + 0.2));
//        System.out.println(BitConverter.getBits(0.5));
        BigDecimal a = new BigDecimal("0.203023402402342034230492409");
        BigDecimal b = new BigDecimal("0.4");
        System.out.println(a.add(b).doubleValue());
    }
}
