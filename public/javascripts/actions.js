/**
 * Created by dev-00 on 9/27/17.
 */

window.onload = function () {
    $('.navbar-nav li').click(toggleSelectedMenu);

    function toggleSelectedMenu() {
        $('.navbar-nav li').removeClass();
        $(this).addClass("active")
    }

    // Get the modal
    var modal = document.getElementById("myModal");

    // Get the button that opens the modal
    var btn = document.getElementById("sign_up_btn");

    // When the user clicks on the button, open the modal
    btn.onclick = function() {
        modal.style.display = "block";
    };

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target === modal) {
            modal.style.display = "none";
            $('.navbar-nav li').removeClass();
        }
    }

};
