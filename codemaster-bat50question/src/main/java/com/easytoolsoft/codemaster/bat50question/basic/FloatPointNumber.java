package com.easytoolsoft.codemaster.bat50question.basic;

import com.easytoolsoft.codemaster.common.BitConverter;

/**
 * 浮点数运算、精度丢失
 * Created by tomdeng on 16/11/2.
 */
public class FloatPointNumber {
    public static void main(String[] args){
        System.out.println(BitConverter.getBits(0.4));
        System.out.println(BitConverter.getBits(0.2 + 0.2));
        System.out.println(BitConverter.getBits(0.4 + 0.2));
        System.out.println(BitConverter.getBits(0.5));
    }
}
