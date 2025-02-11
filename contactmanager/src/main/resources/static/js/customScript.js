$(document).ready(function () {
    // Ensure sidebar starts hidden
    $(".sidebar").css("left", "-18%");
    $(".overlay").hide();

    // Toggle Sidebar when clicking the icon
    $(".fa-bars").click(function () {
        if ($(".sidebar").css("left") === "0px") {
            // If sidebar is open, close it
            $(".sidebar").css("left", "-18%");
            $(".overlay").fadeOut();
        } else {
            // If sidebar is closed, open it
            $(".sidebar").css("left", "0px");
            $(".overlay").fadeIn();
        }
    });

    // Hide Sidebar when clicking outside (on overlay)
    $(".overlay").click(function () {
        $(".sidebar").css("left", "-18%");
        $(".overlay").fadeOut();
    });

    // Close Sidebar with ESC key
    $(document).keyup(function (e) {
        if (e.key === "Escape") { // ESC key
            $(".sidebar").css("left", "-18%");
            $(".overlay").fadeOut();
        }
    });
});
