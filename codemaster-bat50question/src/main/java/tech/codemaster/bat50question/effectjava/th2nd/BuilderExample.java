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
public class BuilderExample {
    private final String name;
    private final String sex;
    private final int age;
    private final String country;
    private final int weight;

    private BuilderExample(Builder builder) {
        this.name = builder.name;
        this.sex = builder.sex;
        this.age = builder.age;
        this.country = builder.country;
        this.weight = builder.weight;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return String.format("%s-%s", this.name, this.sex);
    }

    public static class Builder {
        private String name;
        private String sex;
        private int age;
        private String country;
        private int weight;

        public Builder name(String value) {
            this.name = value;
            return this;
        }

        public Builder sex(String value) {
            this.sex = value;
            return this;
        }

        public Builder age(int value) {
            this.age = value;
            return this;
        }

        public Builder country(String value) {
            this.country = value;
            return this;
        }

        public Builder weight(int value) {
            this.weight = value;
            return this;
        }

        public BuilderExample build() {
            return new BuilderExample(this);
        }
    }
}
