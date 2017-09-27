/**
 * Created by dev-00 on 9/27/17.
 */

window.onload = function () {
    $('.navbar-nav li').click(toggleSelectedMenu);

    function toggleSelectedMenu() {
        $('.navbar-nav li').removeClass();
        $(this).addClass("active")
    }
};
