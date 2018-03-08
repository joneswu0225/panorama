<#assign page_title="功能测试",page_type="",nosidebar=true>
<#include "./common/header.ftl"/>
<script>
    $(function(){
        $("#submitComment").on("click", function(){
            var hotspotCode = $("#form-comment-edit input[name='hotspotCode']").val();
            var thumbUp = $("#form-comment-edit input[name='thumbUp']").val();
            var content = $("#form-comment-edit textarea[name='content']").val();
            addComment({"hotspotCode": hotspotCode, "thumbUp": thumbUp, "content":content}, function(data){
                console.log(data);
                alert("添加评论成功！")
            })
        })
        $("#submitThumbUp").on("click", function(){
            var hotspotCode = $("#form-comment-edit input[name='hotspotCode']").val();
            var thumbUp = $("#form-comment-edit input[name='thumbUp']:checked").val();
            submitThumbUp({"hostspotCode": hotspotCode, "thumbUp": thumbUp}, function(data){
                console.log(data);
                alert("点赞成功！")
            })
        })
        $("#getComments").on("click", function(){
            var hotspotCode = $("#form-comment-list input[name='hotspotCode']").val();
            var page = $("#form-comment-list input[name='pageNum']").val();
            var size = $("#form-comment-list input[name='pageSize']").val();
            getCommentList({"hostspotCode": hotspotCode, "page": page, "size": size}, function(data){
                console.log(data);
                windowOpen("/comment/list?hotspotCode=" + hotspotCode + "&page=" + page + "&size=" + size);
            })
        })
    })
</script>
<div class="am-tabs">
    <div class="am-tab-panel am-fade am-in am-active">
        <!--评论信息-->
        <form id="form-comment-edit">
        <div class="am-panel am-panel-default">
            <div class="am-panel-hd am-panel-title">发表评论</div>
            <div class="am-panel-collapse am-collapse am-in">
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-6 am-u-md-2 am-text-right">热点编号</div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <input type="text" name="hotspotCode" value=""/>
                    </div>
                    <div class="am-u-sm-6 am-u-md-2 am-text-right">是否点赞</div>
                    <div class="am-u-sm-6 am-u-md-3 am-u-end">
                        <label class="am-radio-inline"><input type="radio" name="likeFlag" value="true"/>是</label>
                        <label class="am-radio-inline"><input type="radio" name="likeFlag" value="false" checked/>否</label>
                    </div>
                </div>
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-6 am-u-md-2 am-text-right">评论内容</div>
                    <div class="am-u-sm-12 am-u-md-10"><textarea name="content" class="textarea-default"></textarea></div>
                </div>
                <div class="am-g am-margin-top">
                    <div class="am-u-md-4 am-u-end">
                        <input class="am-btn am-btn-success" id="submitComment" type="button" value="提交"/>
                        <#--<input class="am-btn am-btn-success" id="submitThumbUp" type="button" value="点赞"/>-->
                    </div>
                </div>
            </div>
        </div>
        </form>
        <form id="form-comment-list">
        <div class="am-panel am-panel-default">
            <div class="am-panel-hd am-panel-title">评论列表</div>
            <div class="am-panel-collapse am-collapse am-in">
                <div class="am-g am-margin-top">
                    <div class="am-u-sm-6 am-u-md-2 am-text-right">热点编号</div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <input type="text" name="hotspotCode" value=""/>
                    </div>
                    <div class="am-u-sm-6 am-u-md-2 am-text-right">分页信息</div>
                    <div class="am-u-sm-6 am-u-md-2">
                        <input type="text" name="pageNum" value="1" placeholder="页码"/>
                    </div>
                    <div class="am-u-sm-6 am-u-md-2 am-u-end">
                        <input type="text" name="pageSize" value="10" placeholder="每页大小"/>
                    </div>
                </div>
                <div class="am-g am-margin-top">
                    <div class="am-u-md-4 am-u-end">
                        <input class="am-btn am-btn-success" id="getComments" type="button" value="获取"/>
                    </div>
                </div>
            </div>
        </div>
        </form>
    </div>
    <!--基本信息结束-->
</div>
