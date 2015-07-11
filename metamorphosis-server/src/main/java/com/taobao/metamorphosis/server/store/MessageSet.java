/*
 * (C) 2007-2012 Alibaba Group Holding Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Authors:
 *   wuhua <wq163@163.com> , boyan <killme2008@gmail.com>
 */
package com.taobao.metamorphosis.server.store;

import java.io.IOException;
import java.nio.ByteBuffer;

import com.taobao.metamorphosis.network.GetCommand;
import com.taobao.metamorphosis.server.network.SessionContext;


/**
 * ��Ϣ����
 * 
 * @author boyan
 * @Date 2011-4-19
 * 
 */
public interface MessageSet {
    /**
     * ��ȡһ����Ϣ����
     * @param offset
     * @param limit
     * @return
     * @throws IOException
     */
    public MessageSet slice(long offset, long limit) throws IOException;


    public void write(GetCommand getCommand, SessionContext ctx);

    /**
     * �洢һ����Ϣ����ʱ��û�д洢�����̣���Ҫ����flush�������ܱ�֤�洢������
     * @param buff
     * @return
     * @throws IOException
     */
    public long append(ByteBuffer buff) throws IOException;

    /**
     * �ύ������
     * @throws IOException
     */
    public void flush() throws IOException;

    /**
     * ��ȡ��Ϣ
     * @param bf
     * @param offset
     * @throws IOException
     */
    public void read(final ByteBuffer bf, long offset) throws IOException;

    /**
     * ��ȡ��Ϣ
     * @param bf
     * @throws IOException
     */
    public void read(final ByteBuffer bf) throws IOException;

    /**
     * ������Ϣ����
     * @return
     */
    public long getMessageCount();

}