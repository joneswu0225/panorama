document.ontouchmove = function(e){ e.preventDefault(); };
document.write("<link rel=stylesheet href='skin/skin.css' />");
function is_weixin(){  
	var ua = navigator.userAgent.toLowerCase();  
	if(ua.match(/MicroMessenger/i)=="micromessenger") {  
		return true;  
	} else {  
		return false;  
	}  
}  
function is_Mobile()  
{  
	return navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i);  
}      
if(unescape(window.location.href).toLowerCase().indexOf('file:///')!=0){
  if(is_weixin()){document.write("<div style='display:none'><img src='wximg.jpg' width='301' height='301' id='wximg'/></div>");}
  document.write("<div id='divWaitInfo' style='display: table;width: 100%;height: 100%;'><div id='loading' style='display: table-cell;text-align: center;vertical-align: middle;'><font color='FFFFFF'>正在准备全景<br>请稍候...</font></div></div>");
}
function RemoveWaitInfo(){
   var div=document.getElementById('divWaitInfo');
   if (div != null){
	   div.parentNode.removeChild(div);
	   //div.style.opacity=1;
	   //DivHidden(div,1,-0.01);
   };
}
function DivHidden(o,i,s){
  t=setInterval(function(){  
  i+=s;
  o.style.opacity=i;
  if(i<0){window.clearInterval(t); o.parentNode.removeChild(o);};
  },1);  
};
function EnterTour()
{
	RemoveWaitInfo();
}	
