$(document).ready(function () {
    
      $('#reviewBtn').click(function(){
          $('.ui.modal.small').modal('show');
  });

    $('.ui .item').on('click', function () {
        var id = $(this).parent().attr('id');
        $('.ui .' + id + '.item').removeClass('active');
        $('.' + id + '.segment').removeClass('active');
        var currentTab = $(this).attr("data-tab");
        $("[data-tab='" + currentTab + "']").addClass('active');
        $(this).addClass('active');
    });
    
    
});



document.addEventListener('DOMContentLoaded', function (event) {
/*
     //Get the review modal
     var myReview = document.getElementById("myReview");
     
     // Get the + button that opens the review modal
     var btn = document.getElementById("reviewBtn");
     
     // Get the <span> element that closes the modal
     var span = document.getElementsByClassName("closeReview")[0];
     
     // When the user clicks the + button, open the review modal 
     btn.onclick = function () {
     myReview.style.display = "block";
     }
     
     // When the user clicks on <span> (x), close the modal
     span.onclick = function () {
     myReview.style.display = "none";
     }
     
     // When the user clicks anywhere outside of the modal, close it
     window.addEventListener("click",function (event) {
     if (event.target == myReview) {
     myReview.style.display = "none";
     }
     });
     */
     
     
    
});

function closeModal(){
    //Get the review modal
     var myReview = document.getElementById("myReview");
     var titleError=document.getElementById("titleError");
     var reviewError=document.getElementById("reviewError");
     console.log(titleError.innerHTML);
     if(reviewError.innerHTML!=null &&titleError.innerHTML !=null){
         myReview.style.display = "none";
     }
       
    
}
function viewAd(url){
    window.open(url);
}

function addReview() {
    document.getElementById("reviewModal").style.display = 'block';
}

function showMore() {
    
    var dots = document.getElementById("dots");
    var moreText = document.getElementById("more");
    var btnText = document.getElementById("moreBtn");

    if (dots.style.display === "none") {
        dots.style.display = "inline";
        btnText.innerHTML = "Read more";
        moreText.style.display = "none";
    } else {
        dots.style.display = "none";
        btnText.innerHTML = "Read less";
        moreText.style.display = "inline";
    }
} 