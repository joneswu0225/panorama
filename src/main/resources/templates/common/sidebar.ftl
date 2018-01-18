<script>
    $(function(){
        $("#myreviewcount").on("click", function(e){
            e.stopPropagation()
            windowLocate("/etljob/myReviews")
        })
        doGet("/etljob/myReviewCount",{},function(data){
            $("#myreviewcount").html(data);
        })
        $("#admin-offcanvas a[href]").on("click",function(){
            windowLocate($(this).attr("link"));
        })
        $("#sidebar_fade").on("click",function(){
            $("#admin-offcanvas").toggle("normal");
        })
    })
//    function autoHeight(){
//        var ifr = document.getElementById('page_content');
//        ifr.height = ( ifr.contentDocument && ifr.contentDocument.body.offsetHeight ) ||
//                ( ifr.contentWindow.document.body.scrollHeight );
//    }
</script>
<!-- sidebar start -->
<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
    <div class="am-offcanvas-bar admin-offcanvas-bar">
        <ul class="am-list admin-sidebar-list">
            <#--<li><a><span class="am-icon-home" data-am-collapse="{target: '#topbar-collapse'}"></span> 首页</a></li>-->
            <#--<li class="admin-parent">-->
                <#--<a class="am-cf" data-am-collapse="{target: '#collapse-website'}"><span class="am-icon-table"></span> 网站 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>-->
                <#--<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-website">-->
                    <#--<li><a href="javascript:void(0);" link="/website/list" class="am-cf"><span class="am-icon-check"></span> 网站 </a></li>-->
                <#--</ul>-->
            <#--</li>-->
            <li class="admin-parent">
                <a href="javascript:void(0);" link="/etljob/list" class="am-cf"><span class="am-icon-pencil-square-o"></span> ETL任务 <span class="am-fr am-margin-right"></span></a>
                <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-etljob">
                    <li><a href="javascript:void(0);" link="/taskresult/list" class="am-cf"><span class="am-icon-check"></span> 任务执行结果 </a></li>
                    <li><a href="javascript:void(0);" link="/etljob/reviews" class="am-cf"><span class="am-icon-check"></span> 待Review任务 <span class="am-badge am-badge-secondary am-margin-right am-fr" id="myreviewcount">0</span></a></li>
                    <li><a href="javascript:void(0);" link="/engine/status" class="am-cf"><span class="am-icon-check"></span> 引擎状态 </a></li>
                </ul>
            </li>
            <li class="admin-parent">
                <a href="javascript:void(0);" link="/jobtag/list" class="am-cf"><span class="am-icon-pencil-square-o"></span> 标签设置 <span class="am-fr am-margin-right"></span></a>
            </li>
            <li class="admin-parent">
                <a href="javascript:void(0);" link="/cron/list" class="am-cf"><span class="am-icon-pencil-square-o"></span> cron配置 <span class="am-fr am-margin-right"></span></a>
            </li>
            <#--<#if Session["cur_user"]?? && Session["cur_user"].role=="MASTER">-->
            <li class="admin-parent">
                <a href="javascript:void(0);" link="/dbinfo/list" class="am-cf"><span class="am-icon-pencil-square-o"></span> 数据库配置 <span class="am-fr am-margin-right"></span></a>
            </li>
            <#--<#if user_role != 'DEVELOPER'>-->
            <#--<li class="admin-parent">-->
                <#--<a href="javascript:void(0);" link="/user/list" class="am-cf"><span class="am-icon-pencil-square-o"></span> 环境对应设置 <span class="am-fr am-margin-right"></span></a>-->
            <#--</li>-->
            <#--</#if>-->
            <#if user_role != 'DEVELOPER'>
            <li class="admin-parent">
                <a href="javascript:void(0);" link="/user/list" class="am-cf"><span class="am-icon-pencil-square-o"></span> 用户管理 <span class="am-fr am-margin-right"></span></a>
            </li>
            </#if>
            <#--</#if>-->
            <#--<li class="admin-parent"><a href="#"><span class="am-icon-sign-out"></span> 注销</a></li>-->
        </ul>
    </div>
</div>
<a href="javascript:void(0);" class="admin-menu" id="sidebar_fade">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>
<!-- sidebar end -->