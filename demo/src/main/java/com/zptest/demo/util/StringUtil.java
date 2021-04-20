/**
 * File Name:    IdentityNoUtil
 *
 * File Desc:    证件处理
 *
 * Product AB:   携宁基金销售管理平台
 *
 * Product Name: SFM
 *
 * Module Name:  UM系统
 *
 * Module AB:    SFM_UM
 *
 * Author:       Qizhan Lu
 *
 * History:      12-6-21 created by  Qizhan Lu
 */
package com.zptest.demo.util;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * 服务功能：字符处理
 *
 * @author Qizhan Lu
 * @version 1.0
 */
public class StringUtil
{
     /**
     * 转为半角字符串
     *
     * @param str 源字符串
     * @return 半角字符串
     */
    public static String toDBCString(String str)
    {
        if (StringUtils.isBlank(str))
        {
            return str;
        }

        String outStr = "";
        String Tstr;
        byte[] b;

        for (int i = 0; i < str.length(); i++)
        {
            try
            {
                Tstr = str.substring(i, i + 1);
                b = Tstr.getBytes("unicode");
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
                return str;
            }

            if (b[3] == -1)
            {
                b[2] = (byte) (b[2] + 32);
                b[3] = 0;

                try
                {
                    outStr = outStr + new String(b, "unicode");
                }
                catch (UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                    return str;
                }
            } else
            {
                outStr = outStr + Tstr;
            }
        }

        return outStr;
    }

    public static String getLeftSafely(String s, int len)
    {
        if (StringUtils.isBlank(s))
        {
            return s;
        }

        byte[] sBytes;
        try
        {
            sBytes = s.getBytes("GBK");
        } catch (UnsupportedEncodingException e)
        {
            throw new RuntimeException(e);
        }

        int sLen = sBytes.length;
        if (sLen <= len)
        {
            return s;
        } else
        {
            try
            {
                return new String(ArrayUtils.subarray(sBytes, 0, len), "GBK");
            } catch (UnsupportedEncodingException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args)
    {
        String str = "898全角转半角ＤＡＯ￥２３４42 3";
        System.out.println(getLeftSafely(str, 8));
//        String result = toDBCString(str);
//        System.out.println(str + "\n" + result);
    }
}
