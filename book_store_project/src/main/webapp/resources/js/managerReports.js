$(document).ready(function(){

	init();
	});
function init()
{
    $(".close").mouseup(
            function(){
            $(this).parent().parent().css("visibility","hidden");
        });
}
function toggleVisible(name)
{
    
        $(name).css("visibility","visible");
    
}