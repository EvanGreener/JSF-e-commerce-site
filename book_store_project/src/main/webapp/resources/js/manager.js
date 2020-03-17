

$(document).ready(function(){

	init();
	});
function init()
{
    frontButtons();
}
function frontButtons()
{
    
    $('#manage-client-button').hover(
    function () {  
       $('#manage-client-button').attr("value","Add, delete and alter Users");
    });
    $('#manage-client-button').mouseout(
    function () {  
       $('#manage-client-button').attr("value","Users");
    });
    
    $('#edit-inventory-button').hover(
    function () {  
       $('#edit-inventory-button').attr("value","Add, edit, delete and recover inventory");
    });
    $('#edit-inventory-button').mouseout(
    function () {  
       $('#edit-inventory-button').attr("value","Inventory");
    });
    
    $('#set-sales-button').hover(
    function () {  
       $('#set-sales-button').attr("value","Set new sales and edit existing ones, or end a sale.");
    });
    $('#set-sales-button').mouseout(
    function () {  
       $('#set-sales-button').attr("value","Sales");
    });
    
    $('#order-management-button').hover(
    function () {  
       $('#order-management-button').attr("value","Edit or delete orders");
    });
    $('#order-management-button').mouseout(
    function () {  
       $('#order-management-button').attr("value","Orders");
    });
    
    $('#review-management-button').hover(
    function () {  
       $('#review-management-button').attr("value","Approve, edit, or deny Reviews");
    });
    $('#review-management-button').mouseout(
    function () {  
       $('#review-management-button').attr("value","Reviews");
    });
    
    $('#reporting-button').hover(
    function () {  
       $('#reporting-button').attr("value","Review sales statistics, Client statistics, and stock reports");
    });
    $('#reporting-button').mouseout(
    function () {  
       $('#reporting-button').attr("value","Reports");
    });
    
    $('#newsfeed-management-button').hover(
    function () {  
       $('#newsfeed-management-button').attr("value","Change, add, or delete newsfeeds");
    });
    $('#newsfeed-management-button').mouseout(
    function () {  
       $('#newsfeed-management-button').attr("value","Newsfeeds");
    });
    
    $('#survey-management-button').hover(
    function () {  
       $('#survey-management-button').attr("value","Change, add or delete surveys");
    });
    $('#survey-management-button').mouseout(
    function () {  
       $('#survey-management-button').attr("value","Surveys");
    });
    
    $('#ad-management-button').hover(
    function () {  
       $('#ad-management-button').attr("value","Change add or delete banner ads");
    });
    $('#ad-management-button').mouseout(
    function () {  
       $('#ad-management-button').attr("value","Ads");
    });
    
    
    
}
        