
function GetRequest() {
    var url = location.search; 
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        if (str.indexOf("&") != -1) {
            strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = decodeURI(strs[i].split("=")[1]);
            }
        } else {
            theRequest[str.split("=")[0]] = decodeURI(str.split("=")[1]);
        }
    }
    return theRequest;
}
function ReadRequest() {
	VRM_SetValue('request_group',request['tour.group']);
	VRM_SetValue('request_scene',request['group.scene']);
	VRM_SetValue('request_hlookat',request['view.hlookat']);
	VRM_SetValue('request_vlookat',request['view.vlookat']);
	VRM_SetValue('request_fov',request['view.fov']);				
}

var request =new Object();
request = GetRequest();