<select>
<#if type="user">
    <#list list as item>
        <option value="${item.username!}">${item.username!}</option>
    </#list>
<#elseif type="tag">
    <#list list as item>
        <option value="${item.id!}">${item.tagName!}</option>
    </#list>
<#elseif type="cron">
    <#list list as item>
        <option value="${item.cronExpr!}">${item.cronName!} / ${item.cronExpr!}</option>
    </#list>
<#elseif type="job">
    <#list list as item>
        <option value="${item.id!}">${item.jobName!}</option>
    </#list>
<#else>
</#if>
</select>

