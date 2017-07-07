
$(function () {
    $(".ua").click(function () {
        $(".la").css("display","block");
        $(".lb,.lc,.ld").css("display","none");
    })
    $(".ub").click(function () {
        $(".lb").css("display","block");
        $(".la,.lc,.ld").css("display","none");
    })
    $(".uc").click(function () {
        $(".lc").css("display","block");
        $(".lb,.la,.ld").css("display","none");
    })
    $(".ud").click(function () {
        $(".ld").css("display","block");
        $(".lb,.lc,.la").css("display","none");
    })
})

