					//获取数据库数据显示在前端页面
                 function clik(){
 				    	 $.post({
 					         	url: "../admin_gainMessage",
 					         	success:function(result){
 				 					console.log(result.info);
 				 				}
 					     });
 				 }	 