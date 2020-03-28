document.addEventListener('DOMContentLoaded', function (event) {

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
    
});

function storeIsbn(isbn){
    if(isbn !=null){
        sessionStorage.isbn=isbn;
        document.getElementById("isbn").value=sessionStorage.isbn;
    }
    else{
        document.getElementById("isbn").value=sessionStorage.isbn;
    }
}



function insertParam(key, value)
{
    key = encodeURI(key); value = encodeURI(value);

    var kvp = document.location.search.substr(1).split('&');

    var i=kvp.length; var x; while(i--) 
    {
        x = kvp[i].split('=');

        if (x[0]==key)
        {
            x[1] = value;
            kvp[i] = x.join('=');
            break;
        }
    }

    if(i<0) {kvp[kvp.length] = [key,value].join('=');}

    //this will reload the page, it's likely better to store this until finished
    document.location.search = kvp.join('&'); 
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