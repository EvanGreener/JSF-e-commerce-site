document.addEventListener('DOMContentLoaded', function(){
    var bookCards=document.getElementsByClassName('image');
    var index;
for(index=0;index<bookCards.length;index++){
    bookCards[index].addEventListener('mouseover',displayCardHoverButton); bookCards[index].addEventListener('mouseout',removeCardHoverButton);
}});
function displayCardHoverButton()
{
   var btn = document.createElement("BUTTON");
   
   //TODO: put into message bundle for localization
    btn.innerHTML = "Add To Cart";
    btn.classList.add("cardHoverBtn");
 this.appendChild(btn);
}
function removeCardHoverButton()
{
   var btn = document.getElementsByClassName("cardHoverBtn");
  btn[0].remove();
}