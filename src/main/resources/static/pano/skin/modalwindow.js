define(["../skin/res/layer/layer","css!../skin/res/layer/skin/default/layer"],function(layer){
	layer.config({
		path: '../skin/res/layer/'
	});		

	function webpage(url,title,w,h,sctype,shade,cbtype,skin){
		var url=(url.indexOf('/')>-1)?url:'html/index.html?fn='+url;
		var title=(title!='null')?title:'介绍';
		var w=(w!='null' && w.length>0)?w:'90%';
		var h=(h!='null' && h.length>0)?h:'90%';
		var sctype=(sctype!='null' && sctype.length>0)?sctype:'true';
		var shade=(shade!='null' && shade.length>0)?shade:0.8;
		var cbtype=(cbtype!='null' && cbtype.length>0)?cbtype:1;
//		if(is_weixin() && cbtype==1){cbtype=2;}
		var skin=(skin!='null' && skin.length>0)?skin:'';
		layer.open({
		  type: 2,
		  title: title,
		  shadeClose: sctype=='true',
		  shade: parseFloat(shade),
		  area: [w, h],
		  closeBtn: parseInt(cbtype),
		  skin: skin,
		  content: url 
		}); 
	};	

	function html(body,title,w,h,shift,cbtype,skin){
		var d=body.split(":");
		if (d[0]=='data'){body=html_decode(VRM_GetValue('data['+d[1]+'].content'));};
		var title=(title!='null')?title:'';
		var w=(w!='null' && w.length>0)?w:'60%';
		var h=(h!='null' && h.length>0)?h:'60%';
		var shift=(shift!='null' && shift.length>0)?shift:0;
		var cbtype=(cbtype!='null' && cbtype.length>0)?cbtype:0;
		var skin=(skin!='null' && skin.length>0)?skin:'';
		layer.open({
		  type: 1,
		  title: title,
		  closeBtn: parseInt(cbtype),
		  shift: shift,
		  shadeClose: true,
		  area: [w, h],
		  skin: skin,
		  content: body		
		});
	};			
	function picture(imageurl,title,w,h,shift,cbtype,skin){
		var content="<div class='divtable'><div class='divcell'><img src='"+imageurl+"'/></div></div>";		
		var title=(title!='null')?title:'查看图片';
		var w=(w!='null' && w.length>0)?w:'60%';
		var h=(h!='null' && h.length>0)?h:'60%';
		var shift=(shift!='null' && shift.length>0)?shift:0;
		var cbtype=(cbtype!='null' && cbtype.length>0)?cbtype:0;
		var skin=(skin!='null' && skin.length>0)?skin:'';
		layer.open({
		  type: 1,
		  title: title,
		  closeBtn: parseInt(cbtype), 
		  shift: shift,
		  shadeClose: true,
		  area: [w, h],
		  skin: skin,
		  content: content
		});
	};	
	function video(fn,title,videotype,url){
			function getRootPath()   
			{   
				var str = location.href;
				var arr = str.split("/");
				delete arr[arr.length-1];
				return arr.join("/");  
			}   
		var title=(title!='null')?title:'视频播放';
		// console.info(getRootPath());
		var url_projectvideo=getRootPath()+'files/video/';
		var url=(url!='null')?url:url_projectvideo;
		url=escape(url);
		var videotype=(videotype!='null' && videotype.length>0)?videotype:'mp4';
		var w,h,player;
		if (is_Mobile()){
			w='320px',h='275px';
			player='skin/res/video/player_mobile.html?fn='+fn+'&title='+title+'&videotype='+'&videotype='+videotype+'&url='+url;
		}else{
			w='642px',h='458px';
			player='skin/res/video/player.html?fn='+fn+'&title='+title+'&videotype='+videotype+'&url='+url;
		};//360+96+2=458
		//console.info(url);
		layer.open({
		  type: 2,
		  title: false,
		  area: [w,h],
		  shade: 0.8,
		  closeBtn: 0,
		  shadeClose: true,
		  scrollbar: false,
		  skin: 'layui-layer-nobg',
		  content: [player, 'no']//url+fn+'.mp4'
		});
	};	
	function photos(gallery){
		$.getJSON('gallery/'+gallery+'/photos.json', function(json){
		  layer.photos({
			shade: 0.6,
			photos: json
			,anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
		  });
		}); 
	};
	function hint(msg,tim){	
		var tim=(tim!='null' && tim.length>0)?tim:1000;
		layer.open({
		  type: 1,
		  title: '',
		  closeBtn: 0, 
		  shade: 0,
		  time: tim,
		  content:'&nbsp;'+msg+'&nbsp;'
		});
	};	
	function message(msg,tim,offset,anim,action){	
		var tim=(tim!='null' && tim.length>0)?tim:3000;
		var offset=(offset!='null' && offset.length>0)?offset:'center';
		var anim=(anim!='null' && anim.length>0)?anim:-1;
		var action=(action!='null')?action:'';
		var o={};
		if(offset=='center'){o={
			time: tim,
			anim: anim
		}}else{o={
			offset:offset,
			time: tim,
			anim: anim
		}}
		layer.msg(msg,o, function(index){
			layer.close(index);
			pano().call(action);
		});
	};		
	function input(stitle,theaction,vdefault,formtype){
		var theaction=(theaction!='null')?theaction:'';
		var sdefault=(vdefault!='null')?vdefault:'';
		var formtype=(formtype!='null' && formtype.length>0)?formtype:0;
		layer.prompt({
			title: stitle, 
			value: sdefault,
			formType: parseInt(formtype)
			},function(str, index){
			layer.close(index);
			var act=theaction+"("+str+")";
			pano().call(act);
		});
	};	
	function dialog(msg,btn1,btn2,action1,action2){
		var msg=(msg!='null')?msg:'';
		var btn1=(btn1!='null')?btn1:'';
		var btn2=(btn2!='null')?btn2:'';
		var action1=(action1!='null')?action1:'';
		var action2=(action2!='null')?action2:'';
		layer.confirm(msg, {
			title: '询问',
			btn: [btn1,btn2]
		}, function(index){
			layer.close(index);
			pano().call(action1);
		}, function(index){
			layer.close(index);
			pano().call(action2);
		});		
	};
	function loading(type,tim,sd){	
		var tim=(tim!='null' && tim.length>0)?tim:0;
		var sd=(sd!='null' && sd.length>0)?sd:0;
		layer_index_loading = layer.load(parseInt(type), {
		  shade: parseFloat(sd),
		  time: parseInt(tim)
		});	
	};	
	function loadinghide(){	
		layer.close(layer_index_loading);	
	};	
	
	return {
		showwebpage:webpage,
		showhtml:html,
		showpicture:picture,
		showvideo:video,
		showphotos:photos,
		showhint:hint,
		showmessage:message,
		showinput:input,
		showdialog:dialog,
		showloading:loading,
		hideloading:loadinghide
	};
});
