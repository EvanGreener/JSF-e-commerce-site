document.addEventListener('DOMContentLoaded', function (event) {
    var editModal = document.getElementById("editModal");
    
    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        editModal.style.display = "none";
    }
});

function showModal() {
    document.getElementById("editModal").style.display = 'block';
    return false;
}