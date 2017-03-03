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
package tech.codemaster.spring.container;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.codemaster.spring.container.bean.CompactDisc;
import tech.codemaster.spring.container.config.CDPlayerConfig;

import javax.annotation.Resource;

/**
 * @author tomdeng<14068728@qq.com>
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
//@ContextConfiguration({"classpath:appContext.xml"})
public class CDPlayerTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().mute().enableLog();
    @Resource(name = "KuaiZiBrotherAlbum")
    private CompactDisc compactDisc;

    @Test
    public void cdCanNotBeNull() {
        Assert.assertThat(compactDisc, IsNull.notNullValue());
    }

    @Test
    public void playTest() {
        this.compactDisc.player();
        Assert.assertThat(systemOutRule.getLog(), IsEqual.equalTo("song:小苹果,artis:筷子兄弟"));
    }
}
