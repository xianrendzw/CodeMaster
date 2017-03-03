/*
* Copyright (c) 2016 Tom Deng
* 
* Permission is hereby granted, free of charge, to any person obtaining
* a copy of this software and associated documentation files (the
* "Software"), to deal in the Software without restriction, including
* without limitation the rights to use, copy, modify, merge, publish,
* distribute, sublicense, and/or sell copies of the Software, and to
* permit persons to whom the Software is furnished to do so, subject to
* the following conditions:
* 
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
* LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
* OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
* WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package tech.codemaster.bat50question.effectjava.sug151;

enum CarFactory {
    Bmw, Benz;

    public Car create() {
        switch (this) {
            case Benz:
                return new BenzCar();
            case Bmw:
                return new BMWCar();
            default:
                throw new AssertionError("无效参数");
        }
    }
}


enum FordCar implements Car {
    INSTANCE;

    @Override
    public void run() {
        System.out.println("Ford Car");
    }
}

interface Car {
    void run();
}

/**
 * @author tomdeng<14068728@qq.com>
 * @since 1.0
 */
public class Suggest88 {
    public static void main(String... args) {
        FordCar.INSTANCE.run();
    }
}

class BMWCar implements Car {
    @Override
    public void run() {
        System.out.println("BMW car");
    }
}

class BenzCar implements Car {

    @Override
    public void run() {
        System.out.println("Benz car");
    }
}