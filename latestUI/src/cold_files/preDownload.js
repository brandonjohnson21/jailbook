function preDownload(pid,file){
	var data={act:'preDownload',file:file,pid:pid};
	$.post(window.location.basepath+'?module=images',data,function(response){
		$('#download-modal').detach();
		$('body').append('<div id="download-modal">'+response+'</div>');
	});
}