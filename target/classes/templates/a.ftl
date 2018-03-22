<#--测试直接赋值-->
你好啊！${user},今天你精神不错！
<#--测试逻辑运算-->
<#if num0 gt 18>
成年！
<#else>
未成年！
</#if>
<#--测试内置函数-->
转义成html输出${html?html}
字母大写${str?upper_case}
<#--测试空值处理-->
测试空值处理${null!"aaa"}
<#if aaa??>aaa存在，它的值是${aaa}</#if>
<#--测试文件的引入-->
<#import "b.ftl" as bb/>
<@bb.copyright date = "2018-03-22"/>
${bb.mail}
<#assign mail = "245252333@qq.com">
${mail}