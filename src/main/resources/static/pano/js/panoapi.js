function pano()
{
	return document.getElementById("tourSWFObject");
}
function VRM_GetValue(attribute)
{
	var value = pano().get(attribute);
	return value;
}
function VRM_SetValue(attribute,value)
{
	 pano().set(attribute,value);
}
function VRM_Call(Fun)
{
	pano().call(Fun);
}

function browserZoom (p1){ 
  var ratio = 0,
    screen = window.screen,
    ua = navigator.userAgent.toLowerCase();
   if (window.devicePixelRatio !== undefined) {
      ratio = window.devicePixelRatio;
  }
  else if (~ua.indexOf('msie')) {  
    if (screen.deviceXDPI && screen.logicalXDPI) {
      ratio = screen.deviceXDPI / screen.logicalXDPI;
    }
  }
  else if (window.outerWidth !== undefined && window.innerWidth !== undefined) {
    ratio = window.outerWidth / window.innerWidth;
  }
   if (ratio){
    ratio = Math.round(ratio * 100);
    ratio = ratio / 100;
  }
   VRM_SetValue(p1,ratio);
   return ratio;
};
function loadJs(src) {
    var includeNode = document.getElementsByTagName('script')[0];
    var tempInclude = document.createElement('script');
    tempInclude.src = src;
    includeNode.parentNode.insertBefore(tempInclude, includeNode);
}
function loadCss(src) {
    var includeNode = document.getElementsByTagName('script')[0];
    var tempInclude = document.createElement("link");
    tempInclude.rel = "stylesheet";
    tempInclude.type = "text/css";
    tempInclude.href = src;
    includeNode.parentNode.insertBefore(tempInclude, includeNode);
}
function html_encode(str) {
    var div = document.createElement("div");
    div.appendChild(document.createTextNode(str));
    return div.innerHTML;
}

function html_decode(str) {
    var div = document.createElement("div");
    div.innerHTML = str;
    return div.innerText;
}

function Screen_orientationchange(){
	isWX = window.navigator.userAgent.toLowerCase().match(/MicroMessenger/i) == 'micromessenger';
	if(isWX){
		VRM_Call("set(fullscreen,false);delayedcall(0.5,set(fullscreen,true););");
	}
	if(window.orientation==180||window.orientation==0){ 
		VRM_Call("CallSkin_ScreenOnVertical();");        
	} 
	if(window.orientation==90||window.orientation==-90){ 
		VRM_Call("CallSkin_ScreenOnHorizontal();");      
	} 
} 
			
window.addEventListener("onorientationchange" in window ? "orientationchange" : "resize", Screen_orientationchange, false);  