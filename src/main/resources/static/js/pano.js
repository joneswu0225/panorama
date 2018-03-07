/**
 * 新增评论
 * @param comment：comment 的具体内容
 * @param callback: 回调函数
 */
function addComment(comment, callback){
    doPost("/comment/add", comment, function(data){
        if(callback){
            callback.call(this, data);
        }
    })
}
/**
 * 热点内容点赞
 * @param hotspotCode： 热点编号
 * @param isThumbUp： 是否点赞
 * @param callback: 回调函数
 */
function submitThumbUp(comment, callback){
    doPost("/comment/thumbUp",comment, function(data){
        if(callback){
            callback.call(this, data);
        }
    })
}
/**
 * 热点评论列表
 * @param hotspotCode： 热点编号
 * @param page： 页码
 * @param size： 每页记录数
 * @param callback： 回调函数
 */
function getCommentList(hotspotCode, page, size, callback){
    doGet("/comment/list", {"hotspotCode": hotspotCode, "page": page, "size": size}, function(data){
        if(callback){
            callback.call(this, data);
        }
    })
}

var syncScreen = {
    stompClient: null,
    frequent: 50,
    init: function(data){
        syncScreen.frequent = data.frequent;
    },
    connect: function (callback) {
        var socket = new SockJS('/panopipe');
        syncScreen.stompClient = Stomp.over(socket);
        syncScreen.stompClient.connect({}, function (frame) {
            console.log('Connected:' + frame);
            if(callback){
                callback.call(this, stompClient);
            }
        });
    },
    disconnect: function () {
        if (syncScreen.stompClient != null) {
            syncScreen.stompClient.disconnect();
        }
        console.log('Disconnected');
    },
    changePanoScene: function (krpano, krObj){
        var hlookat = krObj.hlookat;
        var vlookat = krObj.vlookat;
        var fov = krObj.fov;
        var scenepath = krObj.scenepath;
        var scene_name = scenepath.split("/")[4]
        if (krpano && krpano.set) {
            if(scenepath != krpano.get("xml.url")){
                krpano.call("loadpanoscene('" + scenepath + "', '" + scene_name + "');")
            }
            krpano.set("view.hlookat", hlookat);
            krpano.set("view.vlookat", vlookat);
            krpano.set("view.fov", fov);
        } else {
            console.log("fail to change pano scene")
        }
    },
    syncMsg: function(panoId){
        var krpano = document.getElementById(panoId);
        if (krpano && krpano.get) {
            var hlookat = krpano.get("view.hlookat");
            var vlookat = krpano.get("view.vlookat");
            var fov = krpano.get("view.fov");
            var scenepath = krpano.get("xml.url");
            var krObj = {
                hlookat: hlookat,
                vlookat: vlookat,
                fov: fov,
                scenepath: scenepath
            }
            syncScreen.stompClient.send("/ws/sendLocation", {}, JSON.stringify({message: krObj}));
        } else {
            console.log("pano is not undefined")
        }
    },
    initServer: function(panoId, callback){
        syncScreen.connect(function(){
            if(callback){
                callback.call(this, stompClient);
            }
        })
    },
    initClient: function(panoId){
        var stompClient = syncScreen.stompClient;
        syncScreen.connect(function(){
            var krpano = document.getElementById(panoId);
            stompClient.subscribe('/client/getLocation', function (frame) {
                krObj = JSON.parse(frame.body).message;
                this.changePanoScene(krpano, krObj);
            })
        })
    }

}
