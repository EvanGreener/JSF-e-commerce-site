document.addEventListener('DOMContentLoaded', function (event) {// Get the modal
      

    // Get the modal
    var modal = document.getElementById("myModal");
// Get the image and insert it inside the modal - use its "alt" text as a caption
       var img1 = document.getElementById("img01");
    var captionText = document.getElementById("caption");

    var bookCards = document.getElementsByClassName('homepageImg');
    var index;
    for (index = 0; index < bookCards.length; index++) {
        bookCards[index].onclick = function () {
          
            
        }
    }

var imgBtn = document.getElementsByClassName('cardHoverBtn');
    for (index = 0; index < imgBtn.length; index++) {
        imgBtn[index].onclick = function () {
         
            // Get the modal
    var modal = document.getElementById("myModal");
// Get the image and insert it inside the modal - use its "alt" text as a caption
       var img1 = document.getElementById("img01");
    var captionText = document.getElementById("caption");
          modal.style.display = "block";
            img1.src=this.parentElement.getElementsByTagName('img')[0].src;
            captionText.innerHTML = this.alt;
            
        }
    }



      
    

            

// Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    }


    /*
     //Get the modal
     var modal = document.getElementById("myModal");
     
     // Get the button that opens the modal
     var btn = document.getElementById("reviewBtn");
     
     // Get the <span> element that closes the modal
     var span = document.getElementsByClassName("close")[0];
     
     // When the user clicks the button, open the modal 
     btn.onclick = function () {
     modal.style.display = "block";
     }
     
     // When the user clicks on <span> (x), close the modal
     span.onclick = function () {
     modal.style.display = "none";
     }
     
     // When the user clicks anywhere outside of the modal, close it
     window.onclick = function (event) {
     if (event.target == modal) {
     modal.style.display = "none";
     }
     }
     var bookCards = document.getElementsByClassName('homepageImg');
     var index;
     for (index = 0; index < bookCards.length; index++) {
     bookCards[index].addEventListener('mouseover', displayCardHoverButton);
     bookCards[index].addEventListener('mouseout', removeCardHoverButton);
     }*/
});

function displayCardHoverButton()
{
    var btn = document.createElement("BUTTON");
    btn.addEventListener('click', displayBookCover);
    btn.innerHTML = "View Cover";
    btn.classList.add("cardHoverBtn");
    this.appendChild(btn);
}

function viewAd(url){
    window.open(url);
}

function addReview() {
    document.getElementById("reviewModal").style.display = 'block';
}

function removeCardHoverButton(){
    var btn = document.getElementsByClassName("cardHoverBtn");
    btn[0].remove();
}

function addToCart(isbn, format){
    var bookItem = {
        ISBN: isbn,
        bookFormat:format
    };
    var cartItems = localStorage.getItem("BOOK_STORE_CART") ? JSON.parse(localStorage.getItem("BOOK_STORE_CART")) : [] ;
    var duplicateFound = cartItems.find(item => item.ISBN === bookItem.ISBN);
    if(!duplicateFound){
        cartItems.push(bookItem);
        localStorage.setItem("BOOK_STORE_CART",JSON.stringify(cartItems));
    }
     event.stopPropagation();
}

function removeFromCart(isbn){
    var cartItems = JSON.parse(localStorage.getItem("BOOK_STORE_CART"));
    var updatedCart = cartItems.filter(item=>item.ISBN !== isbn);
    localStorage.setItem("BOOK_STORE_CART",JSON.stringify(updatedCart));
}

function signOut(){
    document.cookie = 'BOOK_STORE_LOGIN=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

function showResults(){   
    document.getElementById("survey").remove();
    document.getElementById("results").setAttribute("class","visible");
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