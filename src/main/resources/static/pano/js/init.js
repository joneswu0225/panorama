require.config({
    baseUrl: 'skin',
	paths: {
		"request":"../js/request",
		"panoapi":"../js/panoapi",
		"h5soundcore":"../js/h5sound.core",
		"h5soundeffects":"../js/h5sound.effects",
		"domReady":"../js/lib/domReady",
		"css":"../js/lib/css",
		"json":"../js/lib/json",
		"text":"../js/lib/text",
		"font":"../js/lib/font",
		"jquery":"../js/lib/jquery"
	}
});

require(["request","panoapi","jquery","h5soundcore"],function(){
	require(["skin","h5soundeffects","domReady!"],function(skin){
		skin.loadcomponents();
	});
});
