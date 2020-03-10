document.addEventListener('DOMContentLoaded', function (event) {
    var testModal = document.getElementById("test");
    
    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        testModal.style.display = "none";
    }
});

function showModal() {
    document.getElementById("test").style.display = 'block';
    return false;
}