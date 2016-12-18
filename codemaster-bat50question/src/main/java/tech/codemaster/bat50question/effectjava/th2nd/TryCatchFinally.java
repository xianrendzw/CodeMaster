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
package tech.codemaster.bat50question.effectjava.th2nd;

/**
 * @author tomdeng<14068728@qq.com>
 * @since 1.0
 */
public class TryCatchFinally {
    public static void main(String... args) {
        notException();
        notCatchException();
        catchExcpetion();
    }

    private static int notException() {
        try {
            int a = 4 / 1;
        } catch (Exception ex) {
            System.out.println("notException finally end");
        } finally {
            System.out.println("notException finally");
        }
        System.out.println("notException finally end");
        return 0;
    }

    private static int notCatchException() {
        try {
            return 4 / 0;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("notCatchException ex");
        } finally {
            System.out.println("notCatchException finally");
        }
        System.out.println("notCatchException finally end");
        return 0;
    }

    private static int catchExcpetion() {
        try {
            return 4 / 0;
        } catch (Exception ex) {
            System.out.println("catchExcpetion finally ex");
        } finally {
            System.out.println("catchExcpetion finally");
        }
        System.out.println("catchExcpetion finally end");
        return 0;
    }
}
