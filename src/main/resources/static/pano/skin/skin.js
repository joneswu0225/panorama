define(function(){	
    function JsonSort(json,key){
        for(var j=1,jl=json.length;j < jl;j++){
            var temp = json[j],
                val  = temp[key],
                i    = j-1;
            while(i >=0 && json[i][key]<val){
                json[i+1] = json[i];
                i = i-1;   
            }
            json[i+1] = temp;
        }
        return json;
    }
	function loadcomponents(){
		require(["componentsjson"],function(data){
            var json = JsonSort(data.components,'priority');
			var components = new Array()
			for(var i in json){
				components.push(json[i].name);
			}
			require(components,function(){
			});
		});
	};    
	return {
		loadcomponents: loadcomponents	
	};
});



