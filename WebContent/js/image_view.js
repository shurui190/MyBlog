/**
 * 
 */
 $('#chooseImage').on('change',function(){
    	var filePath = $(this).val(),         //获取到input的value，里面是文件的路径
    		fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase(),
    		src = window.URL.createObjectURL(this.files[0]); //转成可以在本地预览的格式
    		
    	// 检查是否是图片
    	if( !fileFormat.match(/.png|.jpg|.jpeg/) ) {
    		error_prompt_alert('上传错误,文件格式必须为：png/jpg/jpeg');
        	return;  
        }
  
        $('#cropedBigImg').attr('src',src);
});

 
 function imgPreview(fileDom){
     //判断是否支持FileReader
     if (window.FileReader) {
         var reader = new FileReader();
     } else {
         alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
     }

     //获取文件
     var file = fileDom.files[0];
     var imageType = /^image\//;
     //是否是图片
     if (!imageType.test(file.type)) {
         alert("请选择图片！");
         return;
     }
     //读取完成
     reader.onload = function(e) {
         //获取图片dom
         var img = document.getElementById("preview");
         //图片路径设置为读取的图片
         img.src = e.target.result;
     };
     reader.readAsDataURL(file);
 }

