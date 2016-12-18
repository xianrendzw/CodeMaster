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
package tech.codemaster.bat50question.guava;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;


/**
 * @author tomdeng<14068728@qq.com>
 * @since 1.0
 */
public class EventBusExample {
    public static void main(String... args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new EventBusChangeRecorder());
        eventBus.post("tomdeng");
    }
}

@Slf4j
class EventBusChangeRecorder {
    @Subscribe
    public void change1(Object sender) {
        log.info("change1,sender:{}", sender);
        log.info("thread id:{}", Thread.currentThread().getId());
    }

    @Subscribe
    public void change2(Object sender) {
        log.info("change2,sender:{}", sender);
        log.info("thread id:{}", Thread.currentThread().getId());
    }
}
